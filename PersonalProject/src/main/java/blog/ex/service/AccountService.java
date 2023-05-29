package blog.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.ex.model.dao.AccountDao;
import blog.ex.model.entity.AccountEntity;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountDao;
	
	//ログイン時アカウントチェックのメソッド
	public AccountEntity validateAccount(String username, String password) {
		AccountEntity accountEntity = accountDao.findByAccountUsernameAndAccountPassword(username, password);
		if (accountEntity == null) {
			return null;
		} else {
			return accountEntity;
		}
	}
	
	//新規アカウント登録処理のメソッド
	public boolean createAccount(String username, String email, String password) {
		if(accountDao.findByAccountEmail(email) == null || accountDao.findByAccountUsername(username) == null) {
			accountDao.save(new AccountEntity(username, email, password));
			return true;
		} else {
			return false;
		}
	}
	
	//一覧取得のメソッド
	public List<AccountEntity> selectFindAll() {
		return accountDao.findAll();
	}
}
