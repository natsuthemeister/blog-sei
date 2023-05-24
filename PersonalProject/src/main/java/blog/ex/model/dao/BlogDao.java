package blog.ex.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.ex.model.entity.BlogEntity;

@Repository
public interface BlogDao extends JpaRepository<BlogEntity, Short> {
	//saveメソッド
		//AccountEntityを引数として受け取ってAccountEntityを保存し、保存したAccountEntityを返す
		BlogEntity save(BlogEntity blogEntity);
		
		//String型の引数として受け取って、その引数と一致するusernameを持つAdminEntityを返す
		BlogEntity findByBlogTitle(String title);
		
		//一覧表示
		List<BlogEntity> findAll();
}
