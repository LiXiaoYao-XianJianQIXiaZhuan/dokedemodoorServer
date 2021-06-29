package servlet.musicServlet;

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
import pojo.music.Music;
import service.musicService.IMusicService;
import service.musicService.impl.MusicServiceImpl;

/**
 * Servlet implementation class QueryAllMusicServlet
 */
@WebServlet("/QueryAllMusicServlet")
public class QueryAllMusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllMusicServlet() {
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
		PrintWriter out = response.getWriter();
		
		ArrayList<Music> musics = new ArrayList<Music>();
		IMusicService ims = new MusicServiceImpl();
		musics = ims.queryAllMusic();
		
		if(!musics.isEmpty()) {
			out.print(new Gson().toJson(new ReturnListInfo<Music>("获取音乐成功",true,musics)));
		}else {
			out.print(new Gson().toJson(new ReturnListInfo<Music>("获取音乐失败",false,null)));
		}
	}

}
