package servlet.upvoteServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.ReturnInfo;
import pojo.starUpvote.StarUpvote;
import service.starUpvoteService.IStarUpvoteService;
import service.starUpvoteService.impl.StarUpvoteServiceImpl;

/**
 * Servlet implementation class AddTripServlet
 */
@WebServlet("/AddUpvoteStarServlet")
public class AddStarUpvoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStarUpvoteServlet() {
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
		
		String avatar = request.getParameter("avatar");
		String nickname = request.getParameter("nickname");
		String time = request.getParameter("time");
		String type = request.getParameter("type");
		String content = request.getParameter("content");
		int microblogid = Integer.parseInt(request.getParameter("microblogid"));
//		System.out.println(time + place + title);
		StarUpvote starUpvote = new StarUpvote(avatar,nickname,time,type,content,microblogid);
		IStarUpvoteService isus = new StarUpvoteServiceImpl();
		if(isus.addStarUpvote(starUpvote)) {
			out.print(new Gson().toJson(new ReturnInfo<StarUpvote>("添加成功",true,null)));
		}else {
			out.print(new Gson().toJson(new ReturnInfo<StarUpvote>("添加失败",false,null)));
		}
	}

}
