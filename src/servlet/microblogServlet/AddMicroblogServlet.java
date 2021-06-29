package servlet.microblogServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

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
 * Servlet implementation class AddMicroblogServlet
 */
@WebServlet("/AddMicroblogServlet")
public class AddMicroblogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMicroblogServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");

		PrintWriter out = response.getWriter();

		String avatar = request.getParameter("avatar");
		String content = request.getParameter("content");
		String video = request.getParameter("video");
		String images = request.getParameter("images");
		String[] simages = images.split(",");
		ArrayList<String> alimages = new ArrayList<String>();
		Collections.addAll(alimages, simages);
		String nickname = request.getParameter("nickname");
		String time = request.getParameter("time");
		String type = request.getParameter("type");

		Microblog microblog = new Microblog(avatar, nickname, time, content, video, alimages, type);
		IMicroblogService ims = new MicroblogServiceImpl();
		if (ims.addMicroblog(microblog)) {
			out.print(new Gson().toJson(new ReturnInfo<Microblog>("添加成功", true, null)));
		} else {
			out.print(new Gson().toJson(new ReturnInfo<Microblog>("添加失败", false, null)));
		}
	}

}
