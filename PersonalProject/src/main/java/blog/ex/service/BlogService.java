package blog.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.ex.model.dao.BlogDao;
import blog.ex.model.entity.BlogEntity;

@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;
	
	//既存ブログ検証のメソッド
	public boolean validateBlog(String title) {
		BlogEntity blogEntity = blogDao.findByBlogTitle(title);
		if (blogEntity == null) {
			return false;
		} else {
			return true;
		}
	}
	
	//新規ブログ登録のメソッド
	public boolean createBlog(String title, String content, Short accountId) {
		if(blogDao.findByBlogTitle(title) == null) {
			blogDao.save(new BlogEntity(title, content, accountId));
			return true;
		} else {
			return false;
		}
	}
	
	//既存ブログを検索
	public BlogEntity searchBlog(Short blogId) {
		BlogEntity blogEntity = blogDao.findByBlogId(blogId);
		if(blogEntity == null) {
			return null;
		} else {
			return blogEntity;
		}
	}
	
	//ブログ編集メソッド
	public boolean editBlog(Short blogId, String title, String content) {
		BlogEntity blogEntity = blogDao.findByBlogId(blogId);
		blogEntity.setBlogId(blogId);
		blogEntity.setBlogTitle(title);
		blogEntity.setBlogContent(content);			
		blogDao.save(blogEntity);
		return true;
	}
	
	//ブログ削除メソッド
	public void deleteBlog(Short id) {
		blogDao.deleteById(id);
	}
	
	//一覧取得のメソッド
	public List<BlogEntity> selectFindAll() {
		return blogDao.findAll();
	}
}
