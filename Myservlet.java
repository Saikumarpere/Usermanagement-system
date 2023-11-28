package com.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.Admin;
import com.admindao.Admindao;

@WebServlet("/")
public class Myservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		switch(path) {
		case "/update":updateUser(request,response);
		break;
		case "/edit" :selectUserById(request,response);
		break;
		case "/delete" : deleteUser(request,response);
		break;
		case "/insert" :insertUser(request,response);
		break;
		case "/add" : newuser(request, response);
		break;
		default:list(request,response);
		}
	}
	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id")); 
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		Admin a=new Admin(id,name,email,city);
		Admindao.updateuser(a);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void selectUserById(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		Admin a=Admindao.selectUserById(id);
		request.setAttribute("list",a);
		RequestDispatcher rd= request.getRequestDispatcher("Userform.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		Admindao.delete(id);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private void insertUser(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		Admin a=new Admin(name,email,city);
		Admindao.insert(a);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private void newuser(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd=request.getRequestDispatcher("Userform.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Admin> al= Admindao.display();
		request.setAttribute("display", al);
		RequestDispatcher rd=request.getRequestDispatcher("Userlist.jsp");
		
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
