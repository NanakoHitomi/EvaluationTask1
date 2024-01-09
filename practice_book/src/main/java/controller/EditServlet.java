package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BookDAO;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		//パラメータ取得
		String isbnCd = request.getParameter("isbnCd");
		String bookNm = request.getParameter("bookNm");
		String bookKana= request.getParameter("bookKana");
		int price= Integer.parseInt(request.getParameter("price"));
		String updateDatetime = request.getParameter("updateDatetime");
		String janCd = request.getParameter("janCd");
		
		 
		 
		 //データベース更新
		 try {
			 BookDAO bDao = new BookDAO();
			 int bookUpdate = bDao.bookUpdate(isbnCd, bookNm, bookKana, price, updateDatetime, janCd);

			 
			 if (bookUpdate > 0) {
				 
				 String forward = "/ListServlet?janCd =" + janCd;
	             RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
	             dispatcher.forward(request, response);
	             
	             System.out.println("成功"); 
			 } else {
	        	 System.out.println("失敗");
			 }
		 } catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
