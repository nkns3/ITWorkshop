package model;
import java.io.Serializable;

//	コメントに関する情報を持つJavaBeans
public class SelpMessage implements Serializable {
	private String userName;	// ユーザー名
	private String text;		// コメント内容
	
	public SelpMessage() {}
	public SelpMessage(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}

	public String getUserName() { return userName; }
	public String getText() { return text; }
}
