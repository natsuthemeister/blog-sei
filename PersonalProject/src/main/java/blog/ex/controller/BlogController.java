package blog.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.ex.model.entity.AccountEntity;
import blog.ex.model.entity.BlogEntity;
import blog.ex.service.BlogService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	HttpSession session;
	
	//ブログ一覧表示
	@GetMapping("/blogs")
	public String getBlogsPage(Model model) {
		List<BlogEntity> blogPosts = blogService.selectFindAll();
		AccountEntity accountEntity = (AccountEntity) session.getAttribute("username");
		String username = accountEntity.getAccountUsername();
		model.addAttribute("blogPosts", blogPosts);
		model.addAttribute("username", username);
		return "blogs.html";
	}
	
	//ブログ新規登録画面の表示
	@GetMapping("/new/blog")
	public String getNewBlogPage() {
		return "new_blog.html";
	}
	
	//新規ブログ登録
	@PostMapping("/new/blog")
	public String create(@RequestParam String title, 
			@RequestParam String content, Model model) {
		AccountEntity accountEntity = (AccountEntity) session.getAttribute("username");
		Short accountId = accountEntity.getAccountId();
		if(blogService.createBlog(title, content, accountId)) {
			model.addAttribute("title", title);
			model.addAttribute("content", content);
			return "blog_post.html";
		} else {
			return "new_blog.html";
		}
	}
	
	//特定ブログ画面の表示
	@GetMapping("/blog/post/{blogId}")
	public String getBlogPostPage(@PathVariable("blogId") Short blogId, Model model) {
		BlogEntity blogEntity = blogService.searchBlog(blogId);
		if(blogEntity != null) {
			model.addAttribute("blogId", blogEntity);
			return "blog_post.html";
		} else {
			return "blogs.html";
		}
	}
	
	//ブログ編集ページ取得
	@GetMapping("/edit")
	public String getEditBlogPage() {
		return "edit_blog.html";
	}
	
	//編集処理
	@PostMapping("/edit/blog")
	public String edit(@RequestParam Short blogId, 
			@RequestParam String title, @RequestParam String content) {
		blogService.editBlog(blogId, title, content);
		return "blogs.html";
	}
	
	//削除処理
	@PostMapping("/delete")
	public String delete(@RequestParam("delete") Short blogId) {
		blogService.deleteBlog(blogId);
		return "redirect:/blogs";
	}
}
