package service.newsService.Impl;

import java.util.ArrayList;

import dao.newsDao.INewsDao;
import dao.newsDao.impl.NewsDaoImpl;
import pojo.news.News;
import service.newsService.INewsService;

public class NewsServiceImpl implements INewsService {
	
	INewsDao ind = new NewsDaoImpl();
	
	@Override
	public ArrayList<News> queryAllNews() {
		return ind.queryAllNews();
	}

	@Override
	public boolean addNews(News information,String imageUrl) {
		return ind.addNews(information,imageUrl);
	}

	@Override
	public boolean updateNewsById(News information, String imageUrl) {
		return ind.updateNewsById(information, imageUrl);
	}

	@Override
	public News queryNewsById(int id) {
		return ind.queryNewsById(id);
	}

	@Override
	public boolean deleteNewsById(int id) {
		return ind.deleteNewsById(id);
	}

}
