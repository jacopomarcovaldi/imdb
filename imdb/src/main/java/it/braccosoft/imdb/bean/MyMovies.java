package it.braccosoft.imdb.bean;

import java.util.Date;

public class MyMovies {
	
	/*
	 * 
	 * CREATE TABLE my_movies(id INT NOT NULL,title VARCHAR(1000),imdb_link VARCHAR(1000),cover_link VARCHAR(1000),date DATE,PRIMARY KEY ( id ) );
	 * 
	 * 
	 * */
	
	public static String TABLE_NAME = "my_movies";
	public static String ID_COLUMN = "id";
	public static String TITLE_COLUMN = "title";
	public static String IMDB_LINK_COLUMN = "imdb_link";
	public static String COVER_LINK_COLUMN = "cover_link";
	public static String DATE_COLUMN = "date";

	private int id;
	private String title;
	private String imdb_link;
	private String cover_link;
	private Date date;
	
	public MyMovies (int id,String title,String imdb_link,String cover_link,Date date)
	{
		this.id = id;
		this.title = title;
		this.imdb_link = imdb_link;
		this.cover_link = cover_link;
		this.date = date;
	}
	
	public MyMovies ()
	{}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImdb_link() {
		return imdb_link;
	}
	public void setImdb_link(String imdb_link) {
		this.imdb_link = imdb_link;
	}
	public String getCover_link() {
		return cover_link;
	}
	public void setCover_link(String cover_link) {
		this.cover_link = cover_link;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

	
}
