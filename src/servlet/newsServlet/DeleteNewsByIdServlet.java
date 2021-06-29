package servlet.newsServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.ReturnInfo;
import pojo.news.News;
import service.newsService.INewsService;
import service.newsService.Impl.NewsServiceImpl;

/**
 * Servlet implementation class DeleteNewsByIdServlet
 */
@WebServlet("/DeleteNewsByIdServlet")
public class DeleteNewsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewsByIdServlet() {
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
		INewsService ins = new NewsServiceImpl();
		if(ins.deleteNewsById(id)) {
			out.print(new Gson().toJson(new ReturnInfo<News>("删除资讯成功",true,null)));
		}else {
			out.print(new Gson().toJson(new ReturnInfo<News>("删除资讯失败",false,null)));
		}
	}

}
