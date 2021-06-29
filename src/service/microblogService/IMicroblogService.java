package service.microblogService;

import java.util.ArrayList;

import pojo.microblog.Microblog;
import pojo.microblog.Upload_Microblog;

public interface IMicroblogService {
	
	public ArrayList<Microblog> queryAllMicroblog();
	
	public Microblog queryMicroblogById(int id);
	
	public boolean addMicroblog(Microblog microblog);
	
	public boolean updateMicroblogById(Upload_Microblog umb);
	
	public boolean deleteMicroblogById(int id);
}
