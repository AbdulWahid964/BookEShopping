package com.books.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan(basePackages={"com.books.controller","com.books.service"})
@EnableJpaRepositories(basePackages="com.books.dao")
@EntityScan(basePackages="com.books.entity")
@EnableWebSecurity
public class BookConfiguration extends WebSecurityConfigurerAdapter{

	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource()).
		passwordEncoder(passwordEncoder()).
		usersByUsernameQuery("select user_name,encoded_password,enabled from user_registration where user_name=?").
		authoritiesByUsernameQuery("select u.user_name as username, r.roles as role from user_registration u INNER JOIN roles r ON r.role_id = u.role_role_id where user_name=?");
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		try{
			System.out.println("Config");
			http
			.authorizeRequests()
			.antMatchers("/css/*","/js/*","/img/*","/showUserRegistration","/saveUserRegistrationForm","/login").permitAll()
			//antMatchers("/home")
			//.hasAnyRole("admin")
			//for this /add it will authenticated apart from that nothing will be authenticated
			// .antMatchers("/add").authenticated()  
			//for every request i.e /home, /add .. anything it will be authenticated 
			.anyRequest().authenticated()
			//.and()
		  //  .exceptionHandling().accessDeniedPage("/accessDenied")
			.and()
			.formLogin()
			.loginPage("/login").defaultSuccessUrl("/home", true)
			.permitAll()
			.and()
			.logout()
			.and()
			.logout()
			// .invalidateHttpSession(true)
			//   .deleteCookies("JSESSIONID")
			.permitAll();
		}
		catch (Exception e) {

			System.out.println("Execption");
		}
		http.csrf().disable();
	}

	@Bean 
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");   //  this is depretected com.mysql.cj.jdbc.Driver
		dataSource.setUrl("jdbc:mysql://localhost:3306/books");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		return dataSource;
	}


}
