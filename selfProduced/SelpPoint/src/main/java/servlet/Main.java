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
	String text = request.getParameter("text");
	String sImgUrl = request.getParameter("selpImg");															/// selpImgを追加
	
	// 入力チェック
	if (((text != null) && (text.length() != 0)) || ((sImgUrl != null ) && (sImgUrl.length() != 0))) {			/// selpImgを追加
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
		
		// メッセージを作成してメッセージリストに追加
		SelpMessage selpMessage = new SelpMessage(loginUser.getName(), text);
		PostSMessageLogic postSMessageLogic = new PostSMessageLogic();
		postSMessageLogic.execute(selpMessage, messageList);
		
		// アプリケーションスコープにメッセージリストを保存
		application.setAttribute("messageList",  messageList);
		
																							/// イメージURLを作成してイメージリストに追加
		SelpImg selpImg = new SelpImg(loginUser.getName(), sImgUrl);
		PostSImgLogic postSImgLogic = new PostSImgLogic();
		postSImgLogic.execute(selpImg, selpImgList);
		
		application.setAttribute("selpImgList", selpImgList);
	}
	
	// メイン画像にフォワード
	RequestDispatcher dispatcher = 
			request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
	dispatcher.forward(request,  response);
	}
}
