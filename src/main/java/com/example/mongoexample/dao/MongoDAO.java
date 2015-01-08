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
		// System.out.print(collection.findOne());

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
		System.out.print("\nit has worked\n");
		// System.out.println("cursor.find=" + collection.find());
		System.out.println("no of items=" + collection.getCount());
	}

	public void updateContent(String titleOfBlogPost, String newContent) {

		BasicDBObject query = new BasicDBObject("title", titleOfBlogPost);
		BasicDBObject update = new BasicDBObject("$set", new BasicDBObject(
				"content", newContent));
		collection.findAndModify(query, update);
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
		// TODO: Add Test Cases
		// test for calling constructors
		MongoDAO dao = new MongoDAO();

		/*
		 * making a date
		 */
		// java.util.Date myDate = new java.util.Date("10/10/2009");
		// BlogPost test1 = new BlogPost("mohan", "humhum", myDate,
		// "please work");
		// dao.addBlogPost(test1);
		// dao.removeBlogPost("humhum");
		// dao.getBlogPostsByAuthor("mohan");
		// System.out.println("the get all posts functions");
		// List<BlogPost> testget = dao.getAllBlogPosts();
		//
		// for (BlogPost myobj : testget) {
		// System.out.println("author  " + myobj.getAuthor());
		// System.out.println("title  " + myobj.getTitle());
		// System.out.println("publishdate  " + myobj.getPublishDate());
		// System.out.println("content  " + myobj.getContent());
		// System.out.print("\n\n");
		// }
		// System.out.println("end of the get all posts functions ");
		//
		//

		// BlogPost p = new BlogPost("Samarth", "Title", new Date(),
		// "I love LOTR");
		// dao.addBlogPost(p);

		dao.updateContent("Title", "This is new content");
		System.out.println(dao.getAllBlogPosts());
	}
}
