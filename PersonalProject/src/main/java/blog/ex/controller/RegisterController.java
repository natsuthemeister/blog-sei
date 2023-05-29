package blog.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.ex.service.AccountService;

@Controller
public class RegisterController {
	@Autowired
	private AccountService accountService;
	
	//登録画面の表示
	@GetMapping("/register")
	public String getRegisterPage() {
		return "register.html";
	}
	
	//登録処理
	//2回入力したパスワードは一致しない場合、登録画面のまま
	//登録が成功したらログイン画面に遷移
	//登録に失敗した場合、登録画面のまま
	@PostMapping("/register/process")
	public String register(@RequestParam String username, 
			@RequestParam String email, @RequestParam String password, 
			@RequestParam String repeatPassword, Model model) {
		
	    if (!password.equals(repeatPassword)) {
	        model.addAttribute("error", true);
	        model.addAttribute("errorMessage", "パスワードは一致していません。");
	        return "register.html";
	    }
	    
		if(accountService.createAccount(username, email, password)) {
			return "redirect:/login";
		} else {
			model.addAttribute("error", true);
			return "register.html";
		}
	}
}
