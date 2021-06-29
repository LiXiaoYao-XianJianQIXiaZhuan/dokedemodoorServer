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
 * Servlet implementation class QueryStarUpvoteByMicroblogidServlet
 */
@WebServlet("/QueryStarUpvoteByMicroblogidServlet")
public class QueryStarUpvoteByMicroblogidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStarUpvoteByMicroblogidServlet() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		IStarUpvoteService isus = new StarUpvoteServiceImpl();
		StarUpvote starupvote = isus.queryStarUpvoteByMicroblogid(id,type);
		if(starupvote!=null) {
			out.print(new Gson().toJson(new ReturnInfo<StarUpvote>("查询成功",true,starupvote)));
		}else {
			out.print(new Gson().toJson(new ReturnInfo<StarUpvote>("查询失败",false,null)));
		}
	}
}

