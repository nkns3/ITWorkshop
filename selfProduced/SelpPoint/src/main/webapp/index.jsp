<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- // トップ画面としてのindex -->
<!-- // このファイルはブラウザから直接リクエストするため、webapp直下に保存 -->
<html>
<head>
<meta charset="UTF-8">
<title>SelpPoint</title>
</head>
<body>
<h1>セルプポイント</h1>

<!-- ログイン用のフォーム -->
<form action="Login" method="post">
ユーザー名：<input type="text" name="name" value="UserA"><br>
パスワード：<input type="password" name="pass" value="1234"><br>
<input type="submit" value="ログイン">
</form>

</body>
</html>