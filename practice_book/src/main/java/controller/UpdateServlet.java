package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.BookBean;
import model.dao.BookDAO;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String janCd = request.getParameter("janCd");
			
			BookDAO bDao = new BookDAO();
			
			List<BookBean> postLists = bDao.getbookDetail(janCd);
			
			request.setAttribute("bookLists", bookLists);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String view = "/WEB-INF/views/post-edit.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
