package com.jsp.servlet.cardb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save-updated-car")
public class SaveUpdatedCarServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId=Integer.parseInt(req.getParameter("carId"));
		String carModel=req.getParameter("carModel");
		String carBrand=req.getParameter("carBrand");
		String carColor=req.getParameter("carColor");
		int carPrice=Integer.parseInt(req.getParameter("carPrice"));
		
		//JDBC Connection Logic
		
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=root");
					//provide details of your user id and password inside query parameter
			
			PreparedStatement pst=conn.prepareStatement("Update car set carModel=?,carBrand=?,carColor=?,carPrice=? where carId=?");
			
			pst.setString(1, carModel);
			pst.setString(2,carBrand);
			pst.setString(3, carColor);
			pst.setInt(4, carPrice);
			pst.setInt(5, carId);
			
			pst.executeUpdate();
			
			resp.sendRedirect("display-car");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
		}
	}
}
