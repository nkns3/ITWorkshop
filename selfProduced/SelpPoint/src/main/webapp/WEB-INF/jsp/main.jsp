<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.SelpMessage, model.SelpImg, java.util.List" %>
<script type="text/javascript" src="./js/script.js"></script>
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
<body>
<h1>SelpPoint</h1>
<!-- 現在の日時 -->
<div id="current_date">
    <script>
        const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
        document.getElementById("current_date").innerHTML = new Date().toLocaleDateString('ja-JP', options);
    </script>
</div>
<%-- <p>現在位置: 緯度 = <%= request.getAttribute("latitude") %>, 経度 = <%= request.getAttribute("longitude") %></p>
 --%>
<!--   <h1>逆ジオコーディング</h1>
  <button onclick="getLocation()">位置情報を取得</button>
  <p>住所: <span id="address">住所が表示されます</span></p>
  <form id="locationForm">
    <input type="hidden" id="latitude" name="latitude">
    <input type="hidden" id="longitude" name="longitude">
  </form> -->


<p>
<%= loginUser.getName() %>さん、ログイン中
<br><a href="Logout">ログアウト</a>
<p><a href="Main">更新</a></p>

<div>
<form action="Main" method="post" id="locationForm">
  <input id="image_e" type="radio" value="stamp_sukkiri-08.png" name="selpImg">
  <label for="image_e"><img src="./images/stamp_sukkiri-08.png" width="100" height="100"></label>
  <input id="image_f" type="radio" value="stamp_sukkiri-24.png" name="selpImg">
  <label for="image_f"><img src="./images/stamp_sukkiri-24.png" width="100" height="100"></label>
  <rd>
  <input id="image_a" type="radio" value="stamp_sukkiri-01.png" name="selpImg">
  <label for="image_a"><img src="./images/stamp_sukkiri-01.png" width="100" height="100"></label>
  <input id="image_b" type="radio" value="stamp_sukkiri-02.png" name="selpImg">
  <label for="image_b"><img src="./images/stamp_sukkiri-02.png" width="100" height="100"></label>
  <input id="image_c" type="radio" value="stamp_sukkiri-05.png" name="selpImg">
  <label for="image_c"><img src="./images/stamp_sukkiri-05.png" width="100" height="100"></label>
  <input id="image_d" type="radio" value="stamp_sukkiri-07.png" name="selpImg">
  <label for="image_d"><img src="./images/stamp_sukkiri-07.png" width="100" height="100"></label>

  <!-- レンジスライダー -->
  <br>[今の気分]<br>もう無理<input type="range" name="mentalValue" min="0" max="100" value="100">快調
  <!-- ボタン -->
  <br><input type="submit" value="イメージを投稿" onclick="getLocation();">
  <input type="hidden" id="latitude" name="latitude">
  <input type="hidden" id="longitude" name="longitude">
</form>

<br><br><form action="Main" method="post" id="locationForm">
<select name="selectText">
	<option value="元気です!">元気です！</option>
	<option value=null selected disabled></option>
	<option value="普通です。">普通</option>
	<option value="いまいちです。">いまいち</option>
	<option value="不調です。">不調</option>
	<option value="病院行ってきます。">病院行ってきます</option>
</select>
<input type="text" name="text">
<br><input type="submit" value="メッセージを投稿" onclick="getLocation()">
<input type="hidden" id="latitude" name="latitude">
<input type="hidden" id="longitude" name="longitude">
</form>
</div>
<% for (SelpMessage selpMessage : messageList) {%>
	<% if (selpMessage.getText() != null) { %>
		<p><%= selpMessage.getUserName() %> : <%= selpMessage.getText() %>
		<small>(<%= new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm").format(selpMessage.getPostDate()) %>)</small>
		</p>
		<small><%= selpMessage.getGeometry() %></small>
	<% } else { %>	
	<% } %>
<% } %>
<% for (SelpImg selpImg : selpImgList) {%>
	<% if (selpImg.getSelpImg() != null) { %>
		<p><%= selpImg.getUserName() %> : <img src="./images/<%= selpImg.getSelpImg() %>" width="100" height="100">
		メンタル<%= selpImg.getMentalValue() %>
		<small>(<%= new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm").format(selpImg.getPostDate()) %>)</small>
		</p>
		<small><%= selpImg.getGeometry() %></small>
	<% } else { %>
	<% } %>
<% } %>

</body>
</html>