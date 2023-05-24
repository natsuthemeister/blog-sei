package blog.ex.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class AccountEntity {
	//関連DBの各々カラムに繋がる
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short accountId;
	
	@Column(name="account_username")
	private String accountUsername;
	
	@Column(name="account_email")
	private String accountEmail;
	
	@Column(name="account_password")
	private String accountPassword;

	public AccountEntity() {
		
	}
	//アカウントのエンティティーを生成するコンストラクタ
	public AccountEntity(String accountUsername, String accountEmail, String accountPassword) {
		this.accountUsername = accountUsername;
		this.accountEmail = accountEmail;
		this.accountPassword = accountPassword;
	}

	public Short getAccountId() {
		return accountId;
	}

	public void setAccountId(Short accountId) {
		this.accountId = accountId;
	}

	public String getAccountUsername() {
		return accountUsername;
	}

	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	
	
}
