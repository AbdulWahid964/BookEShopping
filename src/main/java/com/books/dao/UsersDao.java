package com.books.dao;
import com.books.entity.Users;
import org.springframework.data.repository.CrudRepository;




public interface UsersDao extends CrudRepository<Users, Integer>{

	Users  findByUserName(String name);

}
