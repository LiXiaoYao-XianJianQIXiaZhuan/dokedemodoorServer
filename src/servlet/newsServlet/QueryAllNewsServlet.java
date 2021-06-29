package servlet.newsServlet;

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
import pojo.news.News;
import service.newsService.INewsService;
import service.newsService.Impl.NewsServiceImpl;

/**
 * Servlet implementation class QueryAllNewsServlet
 */
@WebServlet("/QueryAllNewsServlet")
public class QueryAllNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllNewsServlet() {
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
		
		ArrayList<News> news = new ArrayList<News>();
		INewsService ins = new NewsServiceImpl();
		news = ins.queryAllNews();
		
		if(!news.isEmpty()) {
			out.print(new Gson().toJson(new ReturnListInfo<News>("获取资讯成功",true,news)));
		}else {
			out.print(new Gson().toJson(new ReturnListInfo<News>("获取资讯失败",false,null)));
		}
	}

}
