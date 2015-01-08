/**
 * 
 */
package com.example.mongoexample.dao;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.mongoexample.entity.BlogPost;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * 
 *
 */
public class MongoDAO {

	private DBCollection collection;

	public MongoDAO() throws UnknownHostException {
		MongoClient mon = new MongoClient("localhost", 27017);
		DB db = mon.getDB("blogpost");
		collection = db.getCollection("blogpost");
		

	}

	public void addBlogPost(BlogPost post) {
		// TODO: Add Code
		String atr = post.getAuthor();
		String title = post.getTitle();
		Date dt = post.getPublishDate();
		String con = post.getContent();
		BasicDBObject val = new BasicDBObject("author", atr)
				.append("title", title).append("date", dt)
				.append("content", con);
		collection.insert(val);
		
	}

	public void updateContent(String titleOfBlogPost, String newContent) {

		BasicDBObject query = new BasicDBObject("title", titleOfBlogPost);
		BasicDBObject update = new BasicDBObject("$set", new BasicDBObject(
				"content", newContent));
		
		// TODO: Add Code
	}

	public void removeBlogPost(String title) {
		// TODO: Add Code
		// deletion from the blogpost
		BasicDBObject item = new BasicDBObject("title", title);
		collection.remove(item);
	}

	public List<BlogPost> getAllBlogPosts() {
		List<BlogPost> blogPosts = new ArrayList<BlogPost>();
		// TODO: Add Code
		DBObject getrow;
		DBCursor blog = collection.find();
		while (blog.hasNext()) {

			getrow = blog.next();
			BlogPost p = new BlogPost();
			p.setAuthor((String) getrow.get("author"));
			p.setTitle((String) getrow.get("title"));
			p.setPublishDate((Date) getrow.get("date"));
			p.setContent((String) getrow.get("content"));
			blogPosts.add(p);
		}

		// convert dbobject to blogpost

		// call blogspot print

		return blogPosts;
	}

	public List<BlogPost> getBlogPostsByAuthor(String author)
			throws ParseException {
		List<BlogPost> blogPosts = new ArrayList<BlogPost>();
		// TODO: Add Code
		DBObject getrow;
		DBCursor blog = collection.find(new BasicDBObject("author", author));
		while (blog.hasNext()) {

			getrow = blog.next();
			BlogPost p = new BlogPost();
			p.setAuthor((String) getrow.get("author"));
			p.setTitle((String) getrow.get("title"));
			p.setPublishDate((Date) getrow.get("date"));
			p.setContent((String) getrow.get("content"));
			blogPosts.add(p);
		}
		return blogPosts;
	}

	public static void main(String[] args) throws UnknownHostException,
			ParseException {
		//crud operations ready
	}
}
