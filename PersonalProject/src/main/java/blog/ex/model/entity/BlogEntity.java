package blog.ex.model.entity;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class BlogEntity {
	@Id
	@Column(name="blog_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short blogId;
	
	@Column(name="blog_title")
	private String blogTitle;
	
	@Column(name="blog_content")
	private String blogContent;
	
	//後ほどDBチェック
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="create_date")
	private LocalDate createDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="edit_date")
	private LocalDate editDate;
	
	@Column(name="read_count")
	private Short readCount;
	
	@Column(name="account_id")
	private Short accountId;

	public BlogEntity() {
		
	}

	public BlogEntity(String blogTitle, String blogContent) {
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
		this.readCount = 0;
	}

	public Short getBlogId() {
		return blogId;
	}

	public void setBlogId(Short blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getEditDate() {
		return editDate;
	}

	public void setEditDate(LocalDate editDate) {
		this.editDate = editDate;
	}

	public Short getReadCount() {
		return readCount;
	}

	public void setReadCount(Short readCount) {
		this.readCount = readCount;
	}

	public Short getAccountId() {
		return accountId;
	}

	public void setAccountId(Short accountId) {
		this.accountId = accountId;
	}
	
}
