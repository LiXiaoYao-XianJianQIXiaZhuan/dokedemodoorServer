package servlet.microblogServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.ReturnInfo;
import pojo.microblog.Microblog;
import service.microblogService.IMicroblogService;
import service.microblogService.impl.MicroblogServiceImpl;

/**
 * Servlet implementation class QueryMicroblogByBlogidServlet
 */
@WebServlet("/QueryMicroblogByIdServlet")
public class QueryMicroblogByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryMicroblogByIdServlet() {
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
		
		Microblog microblog = new Microblog();
		IMicroblogService ims = new MicroblogServiceImpl();
		microblog = ims.queryMicroblogById(id);
		
		if(microblog!=null) {
			out.print(new Gson().toJson(new ReturnInfo<Microblog>("成功找到此条微博",true,microblog)));
		}else {
			out.print(new Gson().toJson(new ReturnInfo<Microblog>("成功找到此条微博",false,null)));
		}
	}

}
