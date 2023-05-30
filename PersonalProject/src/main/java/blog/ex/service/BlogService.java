package blog.ex.service;

import java.time.LocalDate;
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
	/**
	 * @param title		ブログタイトル
	 * @return	検証結果
	 */
	public boolean validateBlog(String title) {
		BlogEntity blogEntity = blogDao.findByBlogTitle(title);
		if (blogEntity == null) {
			return false;
		} else {
			return true;
		}
	}
	
	//新規ブログ登録のメソッド
	/**
	 * @param title		ブログタイトル
	 * @param content	ブログ内容
	 * @param accountId	ユーザーアカウントID、外部キー
	 * @return	登録結果
	 */
	public boolean createBlog(String title, String content, Short accountId) {
		if(blogDao.findByBlogTitle(title) == null) {
			blogDao.save(new BlogEntity(title, content, accountId));
			return true;
		} else {
			return false;
		}
	}
	
	//既存ブログを検索
	/**
	 * @param blogId	ブログID
	 * @return	検索結果
	 */
	public BlogEntity searchBlog(Short blogId) {
		BlogEntity blogEntity = blogDao.findByBlogId(blogId);
		if(blogEntity == null) {
			return null;
		} else {
			return blogEntity;
		}
	}
	
	//ブログ編集メソッド
	/**
	 * @param blogId 	ブログID
	 * @param title		ブログタイトル
	 * @param content 	ブログ内容
	 * @return	編集結果
	 */
	public boolean editBlog(Short blogId, String title, String content) {
		LocalDate editDate = LocalDate.now();
		BlogEntity blogEntity = blogDao.findByBlogId(blogId);
		blogEntity.setBlogId(blogId);
		blogEntity.setBlogTitle(title);
		blogEntity.setBlogContent(content);	
		blogEntity.setEditDate(editDate);
		blogDao.save(blogEntity);
		return true;
	}
	
	//読者数カウント
	public void readCountBlog(Short blogId, int readCount) {
		BlogEntity blogEntity = blogDao.findByBlogId(blogId);
		blogEntity.setReadCount(readCount);
		blogDao.save(blogEntity);
	}
	
	//ブログ削除メソッド
	/**
	 * @param id	ブログID
	 */
	public void deleteBlog(Short id) {
		blogDao.deleteById(id);
	}
	
	//一覧取得のメソッド
	public List<BlogEntity> selectFindAll() {
		return blogDao.findAll();
	}
}
