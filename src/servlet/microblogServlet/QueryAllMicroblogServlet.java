package servlet.microblogServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.ReturnListInfo;
import pojo.microblog.Microblog;
import service.microblogService.IMicroblogService;
import service.microblogService.impl.MicroblogServiceImpl;

/**
 * Servlet implementation class QueryAllMicrobloServlet
 */
@WebServlet("/QueryAllMicroblogServlet")
public class QueryAllMicroblogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllMicroblogServlet() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		
		ArrayList<Microblog> microblogs = new ArrayList<Microblog>();
		IMicroblogService ims = new MicroblogServiceImpl();
		microblogs = ims.queryAllMicroblog();
		
		if(microblogs !=null) {
			out.print(new Gson().toJson(new ReturnListInfo<Microblog>("获取微博信息成功",true,microblogs)));
		}else {
			out.print(new Gson().toJson(new ReturnListInfo<Microblog>("获取微博信息失败",false,null)));
		}
	}

}
