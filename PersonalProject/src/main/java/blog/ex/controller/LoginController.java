package blog.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.ex.model.entity.AccountEntity;
import blog.ex.service.AccountService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	HttpSession session;
	
	//ログイン画面表示
	@GetMapping("/login")
	public String getLoginPage() {
		return "login.html";
	}
	
	//ログイン処理
	@PostMapping("/login/process")
	public String login(@RequestParam String username, 
			@RequestParam String password, Model model) {
		AccountEntity accountEntity = accountService.validateAccount(username, password);
		if(accountEntity == null) {
			return "login.html";
		} else {
			session.setAttribute("username", accountEntity);
			return "redirect:/blogs";
		}
	}
}
