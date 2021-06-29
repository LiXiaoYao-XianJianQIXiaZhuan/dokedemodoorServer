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
 * Servlet implementation class UpdateNesServlet
 */
@WebServlet("/UpdateNewsByIdServlet")
public class UpdateNewsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNewsByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		int type = Integer.parseInt(request.getParameter("type"));
		String title = request.getParameter("title");
		String time = request.getParameter("time");
		String content = request.getParameter("content");
		String imageUrl = request.getParameter("imageUrl");
		String videoUrl = request.getParameter("videoUrl");
		
		News information = new News(id,type,title,time,content,videoUrl);
		INewsService ins = new NewsServiceImpl();
		if(ins.updateNewsById(information, imageUrl)) {
			out.print(new Gson().toJson(new ReturnInfo<News>("修改成功", true, null)));
		} else {
			out.print(new Gson().toJson(new ReturnInfo<News>("修改失败", false, null)));
		}
	}

}
