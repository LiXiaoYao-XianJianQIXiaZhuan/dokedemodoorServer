package service.newsService;

import java.util.ArrayList;

import pojo.news.News;

public interface INewsService {
	
	
	public ArrayList<News> queryAllNews();
	
	public boolean addNews(News information,String imagesUrl);
	
	public boolean updateNewsById(News information,String imageUrl);
	
	public News queryNewsById(int id);
	
	public boolean deleteNewsById(int id);
}
