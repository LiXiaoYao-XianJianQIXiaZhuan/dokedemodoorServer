package dao.starUpvoteDao;

import java.util.ArrayList;

import pojo.starUpvote.StarUpvote;

public interface IStarUpvoteDao {
	public ArrayList<StarUpvote> queryAllStarUpvote();
	
	public boolean addStarUpvote(StarUpvote starUpvote);
	
	public boolean updateStarUpvote(StarUpvote starUpvote);
	
	public boolean deleteStarUpvoteByid(int id);
	
	public StarUpvote queryStarUpvoteByMicroblogid(int id,String type);
}
