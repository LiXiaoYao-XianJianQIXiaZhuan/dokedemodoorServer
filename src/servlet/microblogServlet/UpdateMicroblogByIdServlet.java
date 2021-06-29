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
import pojo.microblog.Upload_Microblog;
import pojo.trip.Trip;
import service.microblogService.IMicroblogService;
import service.microblogService.impl.MicroblogServiceImpl;

/**
 * Servlet implementation class UpdateMicroblogByIdServlet
 */
@WebServlet("/UpdateMicroblogByIdServlet")
public class UpdateMicroblogByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMicroblogByIdServlet() {
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
		String avatar = request.getParameter("avatar");
		String nickname = request.getParameter("nickname");
		String content = request.getParameter("content");
		String time = request.getParameter("time");
		String video = request.getParameter("video");
		String images = request.getParameter("images");
		String type = request.getParameter("type");
		
		Upload_Microblog umb = new Upload_Microblog(id,avatar,nickname,time,content,video,images, type);
		IMicroblogService ims = new MicroblogServiceImpl();
		if(ims.updateMicroblogById(umb)) {
			out.print(new Gson().toJson(new ReturnInfo<Trip>("修改成功",true,null)));
		}else {
			out.print(new Gson().toJson(new ReturnInfo<Trip>("修改失败",false,null)));
		}
		
	}

}
