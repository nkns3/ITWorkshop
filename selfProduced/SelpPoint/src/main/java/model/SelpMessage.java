package model;
import java.io.Serializable;
import java.util.Date;

//	コメントに関する情報を持つJavaBeans
public class SelpMessage implements Serializable {
	private String userName;	// ユーザー名
	private String text;		// コメント内容
	private Date postDate;		/// 投稿日時
	
	public SelpMessage() {}
	public SelpMessage(String userName, String text) {
		this.userName = userName;
		this.text = text;
		this.postDate = new Date();	///現在日時を設定
	}

	public String getUserName() { return userName; }
	public String getText() { return text; }
	public Date getPostDate() { return postDate; }	/// postDateのゲッターを追加
}
