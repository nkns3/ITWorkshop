package model;
import java.io.Serializable;

//	コメントや投稿イラストに関する情報を持つJavaBeans
public class SelpMessage implements Serializable {
	private String userName;	// ユーザー名
	private String text;		// コメント内容
	private String selpImg;		// 画像URL
	
	public SelpMessage() {}
	public SelpMessage(String userName, String text, String selpImg) {
		this.userName = userName;
		this.text = text;
		this.selpImg = selpImg;
	}
	public String getUserName() { return userName; }
	public String getText() { return text; }
	public String getselpImg() { return selpImg; }
}
