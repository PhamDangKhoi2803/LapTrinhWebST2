package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login", "/dang-nhap" })
public class LoginControllers extends HttpServlet {

	private static final long serialVersionUID = -566012342;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Nhận dữ liệu từ request URL
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");
		// Hiển thị dữ liệu ra web bằng đối tượng
		/*
		 * PrintWriter PrintWriter out = resp.getWriter();
		 * out.println("<b>Username</b>: " + Username + "<br/><b>Password</b>: "+
		 * Password);
		 */
		RequestDispatcher rd = req.getRequestDispatcher("/views/index.html");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doGet(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		// nhan du lieu tu request url
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean isRememberMe = false;
		String remember = req.getParameter("remember");

		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		IUserService service = new UserServiceImpl();
		UserModel user = service.login(username, password);
		
		if(user!=null){
			 HttpSession session = req.getSession(true);
			 session.setAttribute("account", user);
			 if(isRememberMe){
			 saveRemeberMe(resp, username);
			 }
			 resp.sendRedirect(req.getContextPath()+"/waiting");
			 }else{
			 alertMsg =
			"Tài khoản hoặc mật khẩu không đúng";
			 req.setAttribute("alert", alertMsg);
			 req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			 }
		/*
		 * RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
		 * rd.forward(req, resp);
		 */
	}
}
