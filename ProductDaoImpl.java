package com.capgemini.go.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.exception.ProductException;
import com.capgemini.go.util.DatabaseUtil;
public class ProductDaoImpl implements ProductDao {
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	ProductDTO productdto;
	HashMap<String, ProductDTO>hashMap;

	public ProductDaoImpl() throws SQLException{
	connection=DatabaseUtil.myConnection();
	}
	@Override
	public HashMap<String, ProductDTO> viewAllProduct() throws SQLException{
		st=connection.createStatement();
		rs=st.executeQuery("select * from product");
		hashMap=new HashMap<>();
		while(rs.next()) {
		productdto=null;
		productdto=new ProductDTO();

		productdto.setProductId(rs.getString(1));
		productdto.setPrice(rs.getDouble(2));
		productdto.setColor(rs.getString(3));
		productdto.setDimension(rs.getString(4));
		productdto.setSpecification(rs.getString(5));
		productdto.setManufacturer(rs.getString(6));
		productdto.setQuantity(rs.getInt(7));
		productdto.setProductCategory(rs.getString(8));
		productdto.setProductName(rs.getString(9));
		
		hashMap.put(rs.getString(1), productdto);
		}
		System.out.println(hashMap.size());
		return hashMap;
		}

	@Override
	public ProductDTO searchProduct(String ProductId) throws SQLException
	{
		pst=connection.prepareStatement("select * from product where productId=?");
		pst.setString(1, ProductId);
		rs=null;
		rs=pst.executeQuery();
		if(rs.next()) {
			productdto=null;
			productdto=new ProductDTO();
			productdto.setProductId(rs.getString(1));
			productdto.setPrice(rs.getDouble(2));
			productdto.setColor(rs.getString(3));
			productdto.setDimension(rs.getString(4));
			productdto.setSpecification(rs.getString(5));
			productdto.setManufacturer(rs.getString(6));
			productdto.setQuantity(rs.getInt(7));
			productdto.setProductCategory(rs.getString(8));
			productdto.setProductName(rs.getString(9));
		}
		return productdto;
	}
	@Override
	public boolean addProduct(ProductDTO Product) throws SQLException {
		// TODO Auto-generated method stub
		productdto=searchProduct(Product.getProductId());
		if(productdto==null) {
			pst=null;
			pst=connection.prepareStatement("insert into product values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1,Product.getProductId());
			pst.setDouble(2,Product.getPrice());
			pst.setString(3,Product.getColor());
			pst.setString(4,Product.getDimension());
			pst.setString(5,Product.getSpecification());
			pst.setString(6,Product.getManufacturer());
			pst.setInt(7,Product.getQuantity());
			pst.setString(8,Product.getProductCategory());
			pst.setString(9,Product.getProductName());
			int res=pst.executeUpdate();
			if(res==1)
				return true;
			else
				return false;
		}
		
		return false;
	}

	@Override
	public boolean editProduct(String id,String color,int quant) throws ProductException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		productdto=searchProduct(id);
		if(productdto!=null) {
			pst=connection.prepareStatement("update product set color=?, quantity=?");
			pst.setString(1, color);
			pst.setInt(2,quant);
			int res=pst.executeUpdate();
			if(res==1) {
				System.out.println("update into database y/n");
				String ch=sc.next();
				if(ch.equalsIgnoreCase("y")) {
					connection.commit();
					return true;
				}
			}
			else {
				connection.rollback();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean deleteProduct(String productId) throws ProductException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		productdto=searchProduct(productId);
		if(productdto!=null) {
			pst=null;
			pst=connection.prepareStatement("Delete from product where productId=?");
			pst.setString(1,productdto.getProductId());
			int res=pst.executeUpdate();
			if(res==1) {
				System.out.println("delete from database y/n");
				String ch=sc.next();
				if(ch.equalsIgnoreCase("y")) {
					connection.commit();
					return true;
				}
				else {
					connection.rollback();
					return false;
				}
			}
		}
		return false;
	}
}
