package model;

import java.util.List;

//画像の投稿に関する処理を行うモデル
public class PostSImgLogic {
	public void execute(SelpImg selpmessage, List<SelpImg> selpImgList) {
		selpImgList.add(0, selpmessage);	// 先頭に追加
		
	}
}
