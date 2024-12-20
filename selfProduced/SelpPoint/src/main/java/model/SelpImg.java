package model;

import java.io.Serializable;
import java.util.Date;

//コメントや投稿イラストに関する情報を持つJavaBeans
public class SelpImg implements Serializable {
	private String userName;	// ユーザー名
	private String selpImg;		// 画像URL
	private Date postDate;		/// 投稿日時
	private String mentalValue;			/// メンタル数値
	private String geometry;	/// 発信位置

	
	public SelpImg() {}
	public SelpImg(String userName, String selpImg, String mentalValue, String geometry) {
		this.userName = userName;
		this.selpImg = selpImg;
		this.geometry = geometry;
		this.postDate = new Date();	/// 現在日時を設定
		this.mentalValue = mentalValue;
	}

	public String getUserName() { return userName; }
	public String getSelpImg() { return selpImg; }
	public String getGeometry() { return geometry; }
	public Date getPostDate() { return postDate; }	/// postDateのゲッター
	public String getMentalValue() { return mentalValue; }		/// mentalのゲッター
}
