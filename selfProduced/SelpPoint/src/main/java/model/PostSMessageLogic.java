package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

//メッセージの投稿に関する処理を行うモデル
public class PostSMessageLogic {
	
	/////////////////////////////////////////////////////////時間の表示がうまくいかないメッセージに時刻を追加できない
	// Calendarクラスの オブジェクト の生成
    Calendar calendar = Calendar.getInstance();
    //日付のフォーマットを設定
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日 E曜日 HH時(hh時) mm分 ss秒 SSSミリ秒");
// // フォーマットを適用し現在時刻を表示
//    System.out.println(sdf.format(calendar.getTime())); 
    
	public void execute(SelpMessage selpmessage, List<SelpMessage> selpmessageList) {
		selpmessageList.add(0, selpmessage);	// 先頭に追加
		
	}
}