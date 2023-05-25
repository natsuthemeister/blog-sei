package blog.ex.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.ex.model.entity.BlogEntity;

@Repository
public interface BlogDao extends JpaRepository<BlogEntity, Short> {
	//saveメソッド
	//BlogEntityを引数として受け取ってBlogEntityを保存し、保存したBlogEntityを返す
	BlogEntity save(BlogEntity blogEntity);
	
	//Short型の引数を受け取って、一致するidを持つBlogEntityを返す
	BlogEntity findByBlogId(Short id);
		
	//String型の引数として受け取って、一致するtitleを持つBlogEntityを返す
	BlogEntity findByBlogTitle(String title);
		
	//一覧表示		
	List<BlogEntity> findAll();
	
	//ブログ削除
	void deleteById(Short id);
}
