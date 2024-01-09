package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.bean.BookBean;


public class BookDAO {
	
	//全書籍情報取得
		public List <BookBean> getAllBookList() throws ClassNotFoundException, SQLException {
			List<BookBean> list = new ArrayList<BookBean>();
			String sql = "SELECT * FROM BOOK";
			try (Connection con = DBConnection.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				ResultSet res = pstmt.executeQuery();
				while(res.next()) {
					String janCd = res.getString("JAN_CD");
					String isbnCd = res.getString("ISBN_CD");
					String bookNm = res.getString("BOOK_NM");
					String kanaNm = res.getString("KANA_NM");
					int price = res.getInt("PRICE");
					String issueDate = res.getString("ISSUE_DATE");
					String createDatetime = res.getString("CREATE_DATETIME");
					String updateDatetime = res.getString("UPDATE_DATETIME");

					list.add(new BookBean(janCd, isbnCd, bookNm, kanaNm, price, issueDate, createDatetime, updateDatetime));

				}
			}
			return list;
		}
		
//更新用の詳細取得
	public List<BookBean> getbookDetail(String janCd) throws ClassNotFoundException, SQLException {
			List<BookBean> bookList = new ArrayList<BookBean>();
			String sql = "SELECT * FROM BOOK WHERE JAN_CD = ?";
			
			try (Connection conn = DBConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, janCd);
				ResultSet res = pstmt.executeQuery();
				while(res.next()) {
					String jan_cd = res.getString("JAN_CD");
					String isbn_cd = res.getString("ISBN_CD");
					String book_nm = res.getString("BOOK_NM");
					String book_kana = res.getString("BOOK_KANA");
					int price = res.getInt("price");
					String issue_date = res.getString("ISSUE_DATE");
					String create_datetime = res.getString("CREATE_DATETIME");
					String update_datetime = res.getString("UPDATE_DATETIME");
					
					BookBean bookLists = new BookBean(jan_cd, isbn_cd, book_nm, book_kana, price, issue_date, create_datetime, update_datetime);
					
					bookLists.setJanCd(jan_cd);
					bookLists.setIsbnCd(isbn_cd);
					bookLists.setBookNm(book_kana);
					bookLists.setPrice(price);
					bookLists.setIssueDate(issue_date);
					bookLists.setCreateDatetime(create_datetime);
					bookLists.setUpdateDatetime(update_datetime);
					
					bookList.add(bookLists);
				}
			}
			return bookList;
		}
		
		//更新
		public int bookUpdate (String isbnCd, String bookNm, String bookKana, int price, String updateDatetime, String janCd) throws ClassNotFoundException, SQLException {
			int processingNum = 0;
			String sql = "UPDATE BOOK SET ISBN_CD = ?, BOOK_NM = ?, BOOK_KANA = ?, price = ?, UPDATE_DATETIME = ? WHERE  JAN_CD = ?";
			try (Connection con = DBConnection.getConnection(); 
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, isbnCd);
				pstmt.setString(2, bookNm);
			pstmt.setString(3, bookKana);
				pstmt.setInt(4, price);
				pstmt.setString(5, updateDatetime);
				pstmt.setString(6, janCd);
			
			processingNum = pstmt.executeUpdate();
			}
			return processingNum;
	}
		
}
