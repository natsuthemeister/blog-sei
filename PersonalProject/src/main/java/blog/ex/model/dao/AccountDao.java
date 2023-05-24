package blog.ex.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.ex.model.entity.AccountEntity;

@Repository
public interface AccountDao extends JpaRepository<AccountEntity, Short> {
	//saveメソッド
	//AccountEntityを引数として受け取ってAccountEntityを保存し、保存したAccountEntityを返す
	AccountEntity save(AccountEntity accountEntity);
	
	//String型の引数として受け取って、その引数と一致するusernameを持つAccountEntityを返す
	AccountEntity findByAccountUsername(String username);
	
	//一致するemailを持つAccountEntityを返す
	AccountEntity findByAccountEmail(String email);
	
	//一致するusernameとpasswordを持つAccountEntityを返す
	AccountEntity findByAccountUsernameAndAccountPassword(String username, String password);
	
	//一覧表示
	List<AccountEntity> findAll();
}
