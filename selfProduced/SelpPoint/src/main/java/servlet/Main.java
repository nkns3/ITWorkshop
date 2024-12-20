package servlet;
// コメントに関するリクエストを処理するコントローラ

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.PostSImgLogic;
import model.PostSMessageLogic;
import model.SelpImg;
import model.SelpMessage;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
	
		// メッセージリストをアプリケーションスコープから取得
	ServletContext application = this.getServletContext();
	List<SelpMessage> messageList =
	(List<SelpMessage>)application.getAttribute("messageList");
	///イメージリストをアプリケーションスコープから取得
	List<SelpImg> selpImgList =
	(List<SelpImg>)application.getAttribute("selpImgList");
	// 取得できなかった場合は、メッセージリストを新規作成して
	// アプリケーションスコープに保存
	if (messageList == null) {
		messageList = new ArrayList<>();
		application.setAttribute("messageList", messageList);
	}
	if (selpImgList == null) {
		selpImgList = new ArrayList<>();
		application.setAttribute("selpImgList", selpImgList);
	}

	
	// ログインしているか確認するため
	// セッションスコープからユーザー情報を取得
	HttpSession session = request.getSession();
	User loginUser = (User)session.getAttribute("loginUser");
	
	if (loginUser == null) {	// ログインしていない場合
		// リダイレクト
		response.sendRedirect("index.jsp");
	} else {	// ログイン済みの場合
		// フォワード
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request,  response);
	}
	
	}
	
	protected void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
	// リクエストパラメータの取得
	request.setCharacterEncoding("UTF-8");
	String sImgUrl = request.getParameter("selpImg");
	String mentalValue = request.getParameter("mentalValue"); 
	String selectText = request.getParameter("selectText");
	String text = request.getParameter("text");
	
	// 位置情報の取得
    String latitude = request.getParameter("latitude");
    String longitude = request.getParameter("longitude");
    String geometry = null;
    
    if (latitude == "" || longitude == "") {
    	geometry = "位置情報を取得できませんでした";
    }else {
    	geometry = "( 現在置:緯度=" + latitude + " 経度=" + longitude +" )";
    }
    
// // 位置情報が送信されていない場合のデバッグメッセージ
//    if (latitude == null || longitude == null) {
//        System.out.println("位置情報が取得できませんでした。");
//    } else {
//        System.out.println("位置情報: 緯度 = " + latitude + ", 経度 = " + longitude);
//    }
      // 位置情報をJSPに渡す
//    request.setAttribute("latitude", latitude);
//    request.setAttribute("longitude", longitude);

    
    
	// 入力チェック
	if ((((text != null) && (text.length() != 0)) || ((selectText != null) && (selectText.length() != 0))) || ((sImgUrl != null ) && (sImgUrl.length() != 0))) {
		// アプリケーションスコープに保存されたメッセージリストを取得
		ServletContext application = this.getServletContext();
		List<SelpMessage> messageList = 
		(List<SelpMessage>)application.getAttribute("messageList");
		// アプリケーションスコープに保存されたイメージリストを取得		
		List<SelpImg> selpImgList = 
				(List<SelpImg>)application.getAttribute("selpImgList");
		
		// セッションスコープに保存されたユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		// 画像が送信された場合
        if (sImgUrl != null && !sImgUrl.isEmpty()) {
            // 画像の情報を作成して、リストに追加
            SelpImg selpImg = new SelpImg(loginUser.getName(), sImgUrl, mentalValue, geometry);
            PostSImgLogic postSImgLogic = new PostSImgLogic();
            postSImgLogic.execute(selpImg, selpImgList);

            // イメージリストをアプリケーションスコープに保存
            application.setAttribute("selpImgList", selpImgList);
        } else {
        }
        
        // メッセージが送信された場合
        if ((selectText != null && !selectText.isEmpty()) || (text != null && !text.isEmpty())) {
            // メッセージを作成してメッセージリストに追加
            String messageText = selectText + text; // セレクトボックスとテキストをつなげる
            SelpMessage selpMessage = new SelpMessage(loginUser.getName(), messageText, geometry);
            PostSMessageLogic postSMessageLogic = new PostSMessageLogic();
            postSMessageLogic.execute(selpMessage, messageList);

            // メッセージリストをアプリケーションスコープに保存
            application.setAttribute("messageList", messageList);
        } else {
        }
        
    } else {
    }

	// メイン画像にフォワード
	RequestDispatcher dispatcher = 
			request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
	dispatcher.forward(request,  response);
	}
}
