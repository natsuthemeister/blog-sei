package blog.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.ex.model.dao.AccountDao;
import blog.ex.model.entity.AccountEntity;

@Service
public class AccountService {
	@Autowired
	AccountDao accountDao;
	
	//ログインチェック用のメソッド
	public boolean validateAccount(String username, String password) {
		AccountEntity accountEntity = accountDao.findByAccountUsernameAndAccountPassword(username, password);
		if (accountEntity == null) {
			return false;
		} else {
			return true;
		}
	}
	
	//登録処理チェック用のメソッド
	public boolean createAccount(String username, String email, String password) {
		if(accountDao.findByAccountEmail(email) == null || accountDao.findByAccountUsername(username) == null) {
			accountDao.save(new AccountEntity(username, email, password));
			return true;
		} else {
			return false;
		}
	}
	
	public List<AccountEntity> selectFindAll() {
		return accountDao.findAll();
	}
}
