package blog.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.ex.model.dao.BlogDao;
import blog.ex.model.entity.BlogEntity;

@Service
public class BlogService {
	@Autowired
	BlogDao blogDao;
	
	public boolean validateBlog(String title) {
		BlogEntity blogEntity = blogDao.findByBlogTitle(title);
		if (blogEntity == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean createBlog(String title, String content) {
		if(blogDao.findByBlogTitle(title) == null) {
			blogDao.save(new BlogEntity(title, content));
			return true;
		} else {
			return false;
		}
	}
	//改修必要
	public boolean editBlog(BlogEntity blogEntity, String title, String content) {
		if(blogEntity == null) {
			return false;
		} else {
			blogEntity.setBlogTitle(title);
			blogEntity.setBlogContent(content);
			return true;
		}
	}
	//改修必要
	public boolean deleteBlog(BlogEntity blogEntity) {
		if(blogEntity == null) {
			return false;
		} else {
			
			return true;
		}
	}
	
	public List<BlogEntity> selectFindAll() {
		return blogDao.findAll();
	}
}
