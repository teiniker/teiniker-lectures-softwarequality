package org.se.lab;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArticleServiceTestWithSpyAndStub
{
	private ArticleTableStub stub;
	private ArticleTableSpy spy;
	private ArticleService service;
	
	@Before
	public void setup()
	{
		// service -> spy -> stub
		stub = new ArticleTableStub();
		spy = new ArticleTableSpy(stub);
		service = new ArticleService(spy);
	}
	
	@Test
	public void testAddArticle()
	{
		// setup
		Article book = new Article(1, "Effective Java", 3495);
		
		// exercise
		service.addArticle(book);
		
		// state verification
		Article a = stub.articles.get(0);
		Assert.assertEquals(1, a.getId());
		Assert.assertEquals("Effective Java", a.getDescription());
		Assert.assertEquals(3495, a.getPrice());
		
		// behavioral verification
		Assert.assertEquals(1, spy.logs.size());
		Assert.assertTrue(spy.logs.get(0).contains("ArticleTable.insert"));
		// TODO: validate parameter data
		Assert.assertTrue(spy.logs.get(0).contains("1,Effective Java,3495"));
	}
	
	@Test
	public void testNumberOfArticles()
	{
		// setup
		stub.articles = Arrays.asList(
				new Article(1, "Effective Java", 3495), 
				new Article(2, "Java Concurrency in Practice", 3895),
				new Article(3, "Clean Code: A Handbook of Agile Software Craftsmanship", 3095)
				);
		 		
		// exercise
		int number = service.numberOfArticles();
		
		// state verification
		Assert.assertEquals(3, number);		

		// behavioral verification
		Assert.assertEquals(1, spy.logs.size());
		Assert.assertTrue(spy.logs.get(0).contains("ArticleTable.findAll()"));

		// TODO: Verify return data
		Assert.assertTrue(spy.logs.get(0).contains("1,Effective Java,3495"));
		Assert.assertTrue(spy.logs.get(0).contains("2,Java Concurrency in Practice,3895"));
		Assert.assertTrue(spy.logs.get(0).contains("3,Clean Code: A Handbook of Agile Software Craftsmanship,3095"));
	}	
}
