package com.capgemini.go.dao;
import com.capgemini.go.exception.*;

import java.sql.SQLException;
import java.util.HashMap;

import com.capgemini.go.dto.ProductDTO;

public interface ProductDao {
	public HashMap<String, ProductDTO> viewAllProduct() throws SQLException;
	public ProductDTO searchProduct(String ProductId) throws SQLException, ProductException;
	boolean addProduct(ProductDTO Product) throws SQLException, ProductException;
	boolean deleteProduct(String productId) throws SQLException, ProductException;
	boolean editProduct(String id, String color,int quant) throws ProductException, SQLException;
}
