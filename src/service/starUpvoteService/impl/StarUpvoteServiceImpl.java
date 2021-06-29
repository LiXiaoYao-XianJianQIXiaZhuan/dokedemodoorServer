package service.starUpvoteService.impl;

import java.util.ArrayList;

import dao.starUpvoteDao.IStarUpvoteDao;
import dao.starUpvoteDao.impl.StarUpvoteDaoImpl;
import pojo.starUpvote.StarUpvote;
import service.starUpvoteService.IStarUpvoteService;

public class StarUpvoteServiceImpl implements IStarUpvoteService{
	IStarUpvoteDao isud = new StarUpvoteDaoImpl();
	@Override
	public ArrayList<StarUpvote> queryAllStarUpvote() {
		return isud.queryAllStarUpvote();
	}
	@Override
	public boolean addStarUpvote(StarUpvote starUpvote) {
		return isud.addStarUpvote(starUpvote);
	}
	@Override
	public boolean updateStarUpvote(StarUpvote starUpvote) {
		return isud.updateStarUpvote(starUpvote);
	}
	@Override
	public boolean deleteStarUpvoteByid(int id) {
		return isud.deleteStarUpvoteByid(id);
	}
	@Override
	public StarUpvote queryStarUpvoteByMicroblogid(int id,String type) {
		return isud.queryStarUpvoteByMicroblogid(id,type);
	}
	
	
	
	
}
