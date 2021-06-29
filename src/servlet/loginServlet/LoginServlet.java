package servlet.loginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.ReturnInfo;
import pojo.login.Wxapp;
import pojo.user.User;
import service.userService.IUserService;
import service.userService.impl.UserServiceImpl;
import util.httpUtil.HttpUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String code = request.getParameter("code");
		String avatar = request.getParameter("avatar");
		String nickname = request.getParameter("nickname");
		int gender = Integer.parseInt(request.getParameter("gender"));
		//获取appid和appSecret
		Wxapp wapp = new Wxapp();
		//微信请求openid和session_key的链接
		String url ="https://api.weixin.qq.com/sns/jscode2session?appid="+wapp.getAppid()+"&secret="+wapp.getAppSecret()+"&js_code="+code+"&grant_type=authorization_code";
		//发送网络请求，请求openid和session_key
		HttpUtil httpUtil = new HttpUtil();
		Map<String,String> map = new HashMap<String,String>();
		String jsonStr = httpUtil.doGet(url, map);
		//将json转换为对象
		map = new Gson().fromJson(jsonStr,Map.class);
		//转换好以后获取openid、token
		String openid = map.get("openid");
		
		IUserService ius = new UserServiceImpl();
		User user = ius.userLogin(openid,avatar,nickname,gender);
		
		if(user!=null){
			out.print(new Gson().toJson(new ReturnInfo<User>("登录成功",true,user)));
		}else {
			out.print(new Gson().toJson(new ReturnInfo<User>("我也不知道为啥能失败",false,null)));
		}
	}

}
