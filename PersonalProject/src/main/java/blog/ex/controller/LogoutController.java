package blog.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {
	@Autowired
	HttpSession session;
	
	//ログアウト処理
	@GetMapping("/logout")
	public String accountLogout() {
		session.invalidate();
		return "redirect:/login";
	}
}
