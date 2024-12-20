<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>SelpPoint</title>
<meta name="description" content="心が弱り、迷いがある方向けのWebアプリ">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- リセットCSS -->
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
<!-- オリジナルCSS -->
<link rel="stylesheet" href="css/style.css">

</head>

<!-- // トップ画面としてのindex -->
<!-- // このファイルはブラウザから直接リクエストするため、webapp直下に保存 -->

<body>
<header class="page-header">
<h1 class="align-center">
<!-- https://icon-rainbow.comより「丸枠付きのPC電源のアイコン素材 1」 -->
<!-- <img class"logo" src="images/丸枠付きのPC電源のアイコン素材1(12px).svg" width=30px alt="SelpPoint" > -->
セルプポイント</h1>
</header>
<!-- ログイン用のフォーム -->
<div class="login-box">
<form class="input-box" action="Login" method="post" >
ユーザー名：<input type="text" name="name" value="UserA"><br>
パスワード：<input type="password" name="pass" value="1234"><br>
<br>
  <label for="image_top"><img src="./images/stamp_sukkiri-24.png" width="150" height="150"></label>
  <br><input id="image_top" type="submit" value="ログイン" >
</form>
  
</div>
</body>
</html>