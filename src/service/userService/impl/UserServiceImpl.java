package service.userService.impl;

import dao.userDao.IUserDao;
import dao.userDao.impl.UserDaoImpl;
import pojo.user.User;
import service.userService.IUserService;

public class UserServiceImpl implements IUserService{

	@Override
	public User userLogin(String openid,String avatar, String nickname,int gender) {
		IUserDao iud = new UserDaoImpl();
		User user = new User();
		user = iud.queryUserByUserid(openid);
		if(user==null) {
			System.out.println("我在这里，我为空");
			user = new User(openid,avatar,nickname,gender,0,0,0,0);
			iud.addUser(user);
//			id的获取非必须，必需品为openid，登录功能获取昵称，头像，昵称等信息为主
			return user;
		}else {
			System.out.println("我在这里，我不为空");
			return user;
		}
	}

}
