package com.BookStore.dto;

public class BookDTO {
    private String isbn;
    private String title;
    private double price;
    private int stockQuantity;
    private Long authorId;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	@Override
	public String toString() {
		return "BookDTO [isbn=" + isbn + ", title=" + title + ", price=" + price + ", stockQuantity=" + stockQuantity
				+ ", authorId=" + authorId + "]";
	}


}
