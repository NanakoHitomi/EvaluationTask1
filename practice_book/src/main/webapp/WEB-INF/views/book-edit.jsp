<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>
<%@ page import="model.bean.BookBean" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新画面</title>
</head>
<body>
 <%
 List<BookBean> bookLists = (List<BookBean>) request.getAttribute("bookLists");
 for (BookBean books : bookLists) {
 %>
 
 <form action="EditServlet" method="post">
 
 	<label>JANコード:</label><input type="text" name="janCd" value="<%= books.getJanCd() %>"><br>
 	
	<label>ISBNコード：</label><input type="text" name="isbnCd" value="<%=books.getIsbnCd() %>"><br>
	
	<label>書籍名称:</label><input type="text" name="bookNm" value="<%=books.getBookNm() %>"><br>
	
	<label>書籍名称カナ:</label><input type="text" name="bookKana" value="<%=books.getBookKana() %>"><br>
	
	<label>価格:</label><input type="text" name="praice" value="<%=books.getPrice() %>"><br>
	
	<label>書籍名称:</label><input type="text" name="bookNm" value="<%=books.getBookNm() %>"><br>
	
	<label>発行日:</label><input type="text" name="issueDate" value="<%=books.getIssueDate() %>"><br>
	
	<label>登録日時:</label><input type="text" name="createDatetime" value="<%=books.getCreateDatetime() %>"><br>
	
	<label>更新日時:</label><input type="date" name="updateDatetime" value="<%=books.getUpdateDatetime() %>"><br>
	
	
	
<%-- <%
 }
%> --%>
	
				
				<button type="submit">更新する</button>
</form>
<br>

	<a href="ListServlet?janCd=<%= books.getJanCd() %>">一覧に戻る</a>
	
	<%
 }
%>

			
</body>
</html>