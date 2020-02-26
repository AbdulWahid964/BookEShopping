package com.books.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartID;
	
	private String bookName;
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name="bookid")
	private int bookId;
	
	@Column(name="user_id")
	private int users;
	
//	private String bookQuantity;
	
	private long price;
	private String description;
	
//	private double totalPrice;

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

//	public String getBookQuantity() {
//		return bookQuantity;
//	}
//
//	public void setBookQuantity(String bookQuantity) {
//		this.bookQuantity = bookQuantity;
//	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
//
//	public double getTotalPrice() {
//		return totalPrice;
//	}
//
//	public void setTotalPrice(double totalPrice) {
//		this.totalPrice = totalPrice;
//	}
	
	
	

}
