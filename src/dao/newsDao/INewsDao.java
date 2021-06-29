package dao.newsDao;

import java.util.ArrayList;

import pojo.news.News;

public interface INewsDao {
	
	public ArrayList<News> queryAllNews();
	
	public boolean addNews(News information,String imageUrl);
	
	public boolean updateNewsById(News information,String imageUrl);
	
	public News queryNewsById(int id);
	
	public boolean deleteNewsById(int id);
}
