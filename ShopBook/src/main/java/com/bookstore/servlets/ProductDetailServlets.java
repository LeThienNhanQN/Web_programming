package com.bookstore.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookInformationDAO;
import com.bookstore.model.BookInformation;
import com.bookstore.model.BookInformationImage;
import com.bookstore.services.BookImageService;


@WebServlet("/book-detail")
public class ProductDetailServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookInformationDAO bookInformationDAO;
    private BookImageService bookImageService;
    
    public ProductDetailServlets() {
        bookInformationDAO = new BookInformationDAO();
        bookImageService = new BookImageService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookId = request.getParameter("bookId");
		BookInformation bookInformation = bookInformationDAO.findById(bookId);
		request.setAttribute("bookInformation", bookInformation);
		List<BookInformationImage> images = bookImageService.findById(bookId);
		request.setAttribute("images", images);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/product-detail.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
