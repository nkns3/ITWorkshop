<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User" %>
<%
// セッションスコープからユーザー情報を取得
User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<!-- ログイン結果画面を出力するビュー -->
<!-- リセットCSS -->
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<!-- オリジナルCSS -->
<link rel="stylesheet" href="css/style.css">

<html>
<head>
<meta charset="UTF-8">
<title>SelpPoint</title>
</head>
<body>
<% if(loginUser != null) { %>
	<h1>ログインしました</h1>
	<p>ようこそ「<%= loginUser.getName() %>」さん</p>
	<a href="Main">メインメニューへ</a>
<% } else { %>
	<p>ログインに失敗しました</p>
	<a href="index.jsp">TOPへ</a>
<% } %>
</body>
</html>