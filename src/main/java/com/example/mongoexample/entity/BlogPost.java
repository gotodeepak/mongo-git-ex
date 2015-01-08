/**
 * 
 */
package com.example.mongoexample.entity;

import java.util.Date;

//import java.sql.Date;

/**
 * @author Samarth Bhargav
 *
 */
public class BlogPost {
	private String author;
	private String title;
	private String content;
	private Date publishDate;

	/*
	 * 
	 * construcotr to pass test data
	 */

	public BlogPost(String author1, String title1, Date dt, String content1) {
		this.author = author1;
		this.title = title1;
		this.publishDate = dt;
		this.content = content1;
	}

	public BlogPost() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the publishDate
	 */
	public Date getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate
	 *            the publishDate to set
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "BlogPost [author=" + author + ", title=" + title + ", content="
				+ content + ", publishDate=" + publishDate + "]";
	}

}
