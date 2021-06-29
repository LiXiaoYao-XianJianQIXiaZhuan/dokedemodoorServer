package dao.microblogDao;

import java.util.ArrayList;

import pojo.microblog.Microblog;
import pojo.microblog.Upload_Microblog;

public interface IMicroblogDao {
	
	
	public ArrayList<Microblog> queryAllMicroblog();
	
	public Microblog queryMicroblogById(int id);
	
	public boolean addMicroblog(Microblog microblog);
	
	public boolean deleteMicroblogById(int id);
	
	public boolean updateMicroblogById(Upload_Microblog umb);
}
