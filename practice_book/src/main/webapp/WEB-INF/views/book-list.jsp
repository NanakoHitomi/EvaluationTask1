<%@page import="model.bean.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>書籍一覧</title>
</head>
<body>
<h1>書籍一覧</h1>
<span><strong>JANコード</strong><br></span>
<span><strong>書籍名称</strong><br></span>

	
	<%
	List<BookBean> list = (List<BookBean>)request.getAttribute("bookList");
	for (BookBean book : list) {
	%>
	
	<span><%= book.getJanCd() %></span>
	<span><a href='EditServlet?janCd=<%= book.getJanCd() %>'><%= book.getBookNm() %></a></span><br>
	
	
	
	<% } %>
	

</body>
</html>