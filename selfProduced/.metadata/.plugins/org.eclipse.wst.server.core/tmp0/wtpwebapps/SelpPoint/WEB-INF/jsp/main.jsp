<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.SelpMessage, model.SelpImg, java.util.List" %>
<%
// セッションスコープに保存されたユーザー情報を取得
User loginUser = (User)session.getAttribute("loginUser");
// アプリケーションスコープに保存されたユーザー情報を取得
List<SelpMessage> messageList = 
(List<SelpMessage>)application.getAttribute("messageList");
					// アプリケーションスコープに保存されたイメージ画像URLを取得
List<SelpImg> selpImgList =
(List<SelpImg>)application.getAttribute("selpImgList");
					

%>

<!DOCTYPE html>
<!-- // メイン画面を出力するビュー -->
<html>
<head>
<meta charset="UTF-8">
<title>SelpPoint</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body onload="LoadProc();">
<h1>SelpPoint</h1>
<!-- 現在の日時 -->
<div id="current_date">
    <script>
        const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
        document.getElementById("current_date").innerHTML = new Date().toLocaleDateString('ja-JP', options);
    </script>
</div>

<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
<input type="text" name="text">
<input type="submit" value="メッセージ">
</form>

<div>
<form action="Main" method="post">
  <input id="image_a" type="radio" value="stamp_sukkiri-01.png" name="selpImg">
  <label for="image_a"><img src="./images/stamp_sukkiri-01.png" width="100" height="100"></label>
  <input id="image_b" type="radio" value="stamp_sukkiri-02.png" name="selpImg">
  <label for="image_b"><img src="./images/stamp_sukkiri-02.png" width="100" height="100"></label>
  <input id="image_c" type="radio" value="stamp_sukkiri-05.png" name="selpImg">
  <label for="image_c"><img src="./images/stamp_sukkiri-05.png" width="100" height="100"></label>
  <input id="image_d" type="radio" value="stamp_sukkiri-07.png" name="selpImg">
  <label for="image_d"><img src="./images/stamp_sukkiri-07.png" width="100" height="100"></label>
  <input id="image_e" type="radio" value="stamp_sukkiri-08.png" name="selpImg">
  <label for="image_e"><img src="./images/stamp_sukkiri-08.png" width="100" height="100"></label>
  <input id="image_f" type="radio" value="stamp_sukkiri-24.png" name="selpImg">
  <label for="image_f"><img src="./images/stamp_sukkiri-24.png" width="100" height="100"></label>
  <input type="submit" value="イメージ">
</form>
</div>

<% for (SelpMessage selpMessage : messageList) {%>
	<% if (selpMessage.getText() != null) { %>
		<p><%= selpMessage.getUserName() %> : <%= selpMessage.getText() %></p>
	<% } else { %>
		
	<% } %>
<% } %>

<% for (SelpImg selpImg : selpImgList) {%>
	<% if (selpImg.getSelpImg() != null) { %>
		<p><%= selpImg.getUserName() %> : <img src="./images/<%= selpImg.getSelpImg() %>" width="100" height="100"></p>
	<% } else { %>
		
	<% } %>
<% } %>
<script type="text/javascript" src="./js/script.js"></script>
</body>
</html>