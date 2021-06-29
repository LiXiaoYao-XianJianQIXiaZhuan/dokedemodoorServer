package textMicroblog.textMicroblogDao;

import java.util.ArrayList;

import org.junit.Test;

import dao.microblogDao.IMicroblogDao;
import dao.microblogDao.impl.MicroblogDaoImpl;
import pojo.microblog.Microblog;

public class TestMicroblogDao {
	IMicroblogDao md = new MicroblogDaoImpl();
	
	@Test
	public void testQueryAllMicroblogDao() {
		
		ArrayList<Microblog> microblogs = new ArrayList<Microblog>();
		microblogs = md.queryAllMicroblog();
		if(microblogs !=null) {
			System.out.println("获取成功：" + microblogs);
		}else {
			System.out.println("没有获取到microblogs");
		}
	}
}
