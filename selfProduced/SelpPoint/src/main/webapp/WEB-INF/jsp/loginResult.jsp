<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User" %>
<%
// セッションスコープからユーザー情報を取得
User loginUser = (User)session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<!-- ログイン結果画面を出力するビュー -->

<html>
<head>
<meta charset="UTF-8">
<title>SelpPoint</title>
</head>
<body>
<% if(loginUser != null) { %>
	<p>ログインしました</p>
	<p>ようこそ「<%= loginUser.getName() %>」さん</p>
	<a href="Main">メインメニューへ</a>
<% } else { %>
	<p>ログインに失敗しました</p>
	<a href="index.jsp">TOPへ</a>
<% } %>
</body>
</html>