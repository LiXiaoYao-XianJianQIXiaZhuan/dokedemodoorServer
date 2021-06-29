package servlet.upvoteServlet;

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
import pojo.starUpvote.StarUpvote;
import service.starUpvoteService.IStarUpvoteService;
import service.starUpvoteService.impl.StarUpvoteServiceImpl;

/**
 * Servlet implementation class QueryAllTripServlet
 */
@WebServlet("/QueryAllUpvoteStarServlet")
public class QueryAllStarUpvoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllStarUpvoteServlet() {
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
		
		ArrayList<StarUpvote> starupvotes = new ArrayList<StarUpvote>();
		IStarUpvoteService isus = new StarUpvoteServiceImpl();
		starupvotes = isus.queryAllStarUpvote();
		
		if(!starupvotes.isEmpty()) {
			out.print(new Gson().toJson(new ReturnListInfo<StarUpvote>("获取明星点赞转发表成功",true,starupvotes)));
		}else {
			out.print(new Gson().toJson(new ReturnListInfo<StarUpvote>("获取明星点赞转发表失败",false,null)));
		}
	}

}
