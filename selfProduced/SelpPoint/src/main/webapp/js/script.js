
function LoadProc() {
  var now = new Date();
  var DateValue = now.getDate();
  var MonthValue = now.getMonth()+1;
  var HourValue = now.getHours();
  var MinValue = now.getMinutes();
  var SecValue = now.getSeconds();

  var target = document.getElementById("DateTimeDisp");
  target.innerHTML = MonthValue + "月" + DateValue + "日 (" + HourValue + ":" + MinValue + ":" + SecValue + ")";
 } 
 // <div id="DateTimeDisp"></div> で表示はされるが一つのみ
 
// 元のソース
//function LoadProc() {
//  var now = new Date();
//  var YearValue = now.getFullYear();
//  var MonthValue = now.getMonth()+1;
//  var DateValue = now.getDate();
//  var HourValue = now.getHours();
//  var MinValue = now.getMinutes();
//  var SecValue = now.getSeconds();
//
//  var target = document.getElementById("DateTimeDisp");
//  target.innerHTML = YearValue + "年" + MonthValue + "月" + DateValue + "日" + HourValue + ":" + MinValue + ":" + SecValue;
//}
