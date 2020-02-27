package com.capgemini.go.service;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.go.dao.ProductDao;
import com.capgemini.go.dao.ProductDaoImpl;
import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.exception.ProductException;

public class ProductServiceImpl implements ProductService
{
	ProductDTO productdto;
	ProductDao productdao;
	HashMap<String, ProductDTO> hashMap;
	public ProductServiceImpl() throws SQLException {
		productdao =new ProductDaoImpl();
	}
	@Override
	public void showAllProduct() throws SQLException {
		// TODO Auto-generated method stub
		try {
			hashMap=productdao.viewAllProduct();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Set<String> keyset=hashMap.keySet();
		for(String integer: keyset) {
			System.out.println(hashMap.get(integer));
		}	
	}
	@Override
	public void addProduct() throws Exception {
		productdto=new ProductDTO();
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product Details");
		System.out.println("Enter Product id");
		String id=sc.next();
		char ch[]=id.toCharArray();
		if(ch[0]>=65 && ch[0]<=90 || ch[0]>=97 && ch[0]<=122)
			productdto.setProductId(id);
		else
			throw new Exception ("Invalid product id");
		
		System.out.println("Enter Product price");
		productdto.setPrice(sc.nextDouble());
		
		System.out.println("Enter Product color");
		productdto.setColor(sc.next());
		
		System.out.println("Enter Product dimension");
		productdto.setDimension(sc.next());
		
		System.out.println("Enter Product specification");
		productdto.setSpecification(sc.next());
		
		System.out.println("Enter Product manufacturer");
		productdto.setManufacturer(sc.next());
		
		System.out.println("Enter Product quanity");
		productdto.setQuantity(sc.nextInt());
		
		System.out.println("Enter Product category");
		productdto.setProductCategory(sc.next());
		
		System.out.println("Enter Product Name");
		productdto.setProductName(sc.next());
		
		productdao.addProduct(productdto);
	}
	@Override
	public boolean editProduct() throws SQLException, ProductException {
		// TODO Auto-generated method stub
		productdto=new ProductDTO();
		System.out.println("Enter product id to change the color or quantity");
		String c;
		Scanner sc=new Scanner(System.in);
		c=sc.next();
			System.out.println("Edit the color or quanity");
			String c1=sc.next();
			if(c1.equals("color")) {
				System.out.println("Enter the color");
				String color=sc.next();
				if(productdao.editProduct(c,color,0))
					System.out.println("Color updated");
				return true;
			}
			else {
				System.out.println("Enter the quantity");
				int q=sc.nextInt();
				if(productdao.editProduct(c, null, q))
					System.out.println("Quantity updated");
				return true;
			}
	}
	@Override
	public void deleteProduct() throws SQLException, ProductException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product id to delete the product");
		String id=sc.next();
		productdao.deleteProduct(id);
	}
}
