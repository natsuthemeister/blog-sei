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
	
	//ユーザー名検証
	public boolean usernameExists(String username) {
		if(accountDao.findByAccountUsername(username) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	//メール検証
	public boolean emailExists(String email) {
		if(accountDao.findByAccountEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	//ログイン時アカウントチェックのメソッド
	/**
	 * @param username	ユーザー名
	 * @param password	パスワード
	 * @return			(見つかる場合)指定のアカウントエンティティー
	 */
	public AccountEntity validateAccount(String username, String password) {
		AccountEntity accountEntity = accountDao.findByAccountUsernameAndAccountPassword(username, password);
		if (accountEntity == null) {
			return null;
		} else {
			return accountEntity;
		}
	}
	
	//新規アカウント登録処理のメソッド
	/**
	 * @param username	ユーザー名
	 * @param email		Eメール
	 * @param password	パスワード
	 * @return			登録結果
	 */
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
