package com.coderswave.bo;

public class BookBO {
	private int bookid;
	private String bookName;
	private String author;
	private String status;
	private float price;
	private String category;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "BookBO [bookid=" + bookid + ", bookName=" + bookName + ", author=" + author + ", status=" + status
				+ ", price=" + price + ", category=" + category + "]";
	}
	
	
	
}
