package com.capgemini.go.service;

import java.sql.SQLException;

import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.exception.ProductException;

public interface ProductService {
	public void showAllProduct() throws SQLException, ProductException;
	public void addProduct() throws SQLException, ProductException, Exception;
	public boolean editProduct() throws SQLException, ProductException;
	public void deleteProduct() throws SQLException, ProductException;
}
