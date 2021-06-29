package service.microblogService.impl;

import java.util.ArrayList;

import dao.microblogDao.IMicroblogDao;
import dao.microblogDao.impl.MicroblogDaoImpl;
import pojo.microblog.Microblog;
import pojo.microblog.Upload_Microblog;
import service.microblogService.IMicroblogService;

public class MicroblogServiceImpl implements IMicroblogService{
	IMicroblogDao imbd = new MicroblogDaoImpl();
	@Override
	public ArrayList<Microblog> queryAllMicroblog() {
		return imbd.queryAllMicroblog();
	}

	@Override
	public Microblog queryMicroblogById(int id) {
		return imbd.queryMicroblogById(id);
	}

	@Override
	public boolean addMicroblog(Microblog microblog) {
		// TODO 自动生成的方法存根
		return imbd.addMicroblog(microblog);
	}


	@Override
	public boolean deleteMicroblogById(int id) {
		return imbd.deleteMicroblogById(id);
	}

	@Override
	public boolean updateMicroblogById(Upload_Microblog umb) {
		return imbd.updateMicroblogById(umb);
	}
	
}
