package model;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
// ログインに関するリクエストを処理するコントローラ
public class Login  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
	// リクエストパラメータの取得
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	// Userインスタンス (ユーザー情報) の生成
	User user = new User(name, pass);
	// ログイン処理
	LoginLogic loginLogic = new LoginLogic();
	boolean isLogin = loginLogic.execute(user);
	
	// ログイン成功時の処理
	if (isLogin) {
		// ユーザー情報をセッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", user);
	}
	// ログイン結果画面にフォワード
		// ディスパッチ（dispatch）とは、発送(する)、派遣(する)などの意味を持つ英単語で、
		//  ITの分野では同種の複数の対象から一つを選び出したり、
		// データの送信、資源の割り当て、機能の呼び出しなどを表すことが多い。
	RequestDispatcher dispatcher = 
		request.getRequestDispatcher(
		"WEB-INF/jsp/loginResult.jsp");
	dispatcher.forward(request,  response);
	}
}
