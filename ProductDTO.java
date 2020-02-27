package com.capgemini.go.dto;

public class ProductDTO {
	private String productId;
	private double price;
	private String color;
	private String dimension;
	private String specification;
	private String manufacturer;
	private int quantity;
	private String productCategory;
	private String productName;
	
	public ProductDTO(String productId, double price, String color, String dimension, String specification,
			String manufacturer, int quantity, String productCategory, String productName) {
		super();
		this.productId = productId;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.productCategory = productCategory;
		this.productName = productName;
	}
	public ProductDTO()
	{
		
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductId() {
		return productId;
	}
	public double getPrice() {
		return price;
	}
	public String getColor() {
		return color;
	}
	public String getDimension() {
		return dimension;
	}
	public String getSpecification() {
		return specification;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public String getProductName() {
		return productName;
	}
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", price=" + price + ", color=" + color + ", dimension="
				+ dimension + ", specification=" + specification + ", manufacturer=" + manufacturer + ", quantity="
				+ quantity + ", productCategory=" + productCategory + ", productName=" + productName + "]";
	}
	
}
