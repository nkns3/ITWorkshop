// ユーザーの位置情報を取得する関数
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            // 位置情報をフォームの隠しフィールドに設定
            document.getElementById("latitude").value = position.coords.latitude;
            document.getElementById("longitude").value = position.coords.longitude;
            // フォームの送信を実行
          	document.getElementById("locationForm").submit();//////////////////javascriptでフォームが二回押されている
//			document.getElementById("locationForm2").submit();
        }, function(error) {
            console.log("位置情報の取得に失敗しました: " + error.message);
            alert("位置情報を取得できませんでした");
        });
    } else {
        alert("このブラウザは位置情報に対応していません");
    }
}


// 位置情報取得に成功した場合の処理
function showPosition(position) {
    // 緯度と経度を取得
    var latitude = position.coords.latitude;
    var longitude = position.coords.longitude;

//// 逆ジオコーディングAPIを使って住所を取得(失敗：経度と緯度情報は渡しているはずなのに住所が返ってこない。ブラウザ上ではうまくいく)
//    var url = `https://mreversegeocoder.gsi.go.jp/reverse-geocoder/LonLatToAddress?lat=${latitude}&lon=${longitude}`;
//
//    fetch(url)
//        .then(response => response.json())
//        .then(data => {
//            if (data.results && data.results.length > 0) {
//                document.getElementById("address").textContent = data.results[0].address || "住所が見つかりません";
//            } else {
//                alert("住所が見つかりませんでした");
//            }
//        })
//        .catch(error => {
//            alert("ジオコーディングに失敗しました: " + error);
//            system.println(url + ":" + address);
//        });
}

// 位置情報取得に失敗した場合の処理
function showError(error) {
    switch (error.code) {
        case error.PERMISSION_DENIED:
            alert("ユーザーが位置情報の取得を拒否しました");
            break;
        case error.POSITION_UNAVAILABLE:
            alert("位置情報が利用できません");
            break;
        case error.TIMEOUT:
            alert("位置情報の取得がタイムアウトしました");
            break;
        case error.UNKNOWN_ERROR:
            alert("不明なエラーが発生しました");
            break;
    }
}
