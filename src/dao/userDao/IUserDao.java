package dao.userDao;

import pojo.user.User;

public interface IUserDao {
	public User queryUserByUserid(String userid);
	
	public boolean addUser(User user);
}
