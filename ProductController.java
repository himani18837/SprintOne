package com.capgemini.go.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.go.exception.ProductException;
import com.capgemini.go.service.ProductService;
import com.capgemini.go.service.ProductServiceImpl;

public class ProductController {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String ch = "yes";
		ProductService service = null;
		try {
			service = new ProductServiceImpl();
		} catch (SQLException e1) {
			System.err.println(e1.getMessage());
		}

		while (ch.equalsIgnoreCase("yes")) {
			System.out.println("Select Operation");
			System.out.println("1. Add Product");
			System.out.println("2. Show All Product");
			System.out.println("3. Edit Product");
			System.out.println("4. Delete Product");

			int op = sc.nextInt();
			switch (op) {
			case 1:
				try {
					service.addProduct();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				try {
					service.showAllProduct();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				try {
					service.editProduct();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				try {
					service.deleteProduct();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
			System.out.println("Continue yes/no");
			ch = sc.next();
		}
	}
}
