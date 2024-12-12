package model;

import java.io.Serializable;

//コメントや投稿イラストに関する情報を持つJavaBeans
public class SelpImg implements Serializable {
	private String userName;	// ユーザー名
	private String selpImg;		// 画像URL
	
	public SelpImg() {}
	public SelpImg(String userName, String selpImg) {
		this.userName = userName;
		this.selpImg = selpImg;
	}

	public String getUserName() { return userName; }
	public String getSelpImg() { return selpImg; }
}
