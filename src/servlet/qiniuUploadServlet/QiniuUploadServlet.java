package servlet.qiniuUploadServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.ReturnInfo;
import util.qiniuUtil.QiniuUtil;

/**
 * Servlet implementation class QiniuUploadServlet
 */
@WebServlet("/QiniuUploadServlet")
public class QiniuUploadServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QiniuUploadServlet() {
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
		
		//key是传到七牛云的文件名
		String key = request.getParameter("key");
		System.out.println("key="+key);
		Map<String,String> map = new HashMap<String,String>();
		String token = QiniuUtil.getToken(key);
		map.put("token", token);
		map.put("key",key);
		if(token!=null) {
			out.print(new Gson().toJson(new ReturnInfo<Map<String,String>>("获取token成功",true,map)));
		}else {
			out.print(new Gson().toJson(new ReturnInfo<Map<String,String>>("获取token失败",false,null)));
		}
	}
}
