package service.userService;

import pojo.user.User;

public interface IUserService {
	
	public User userLogin(String openid,String avatar,String nickname,int gender);
}
