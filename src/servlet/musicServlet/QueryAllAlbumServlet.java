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
import pojo.music.Album;
import service.musicService.IMusicService;
import service.musicService.impl.MusicServiceImpl;

/**
 * Servlet implementation class QueryAllAlbumServlet
 */
@WebServlet("/QueryAllAlbumServlet")
public class QueryAllAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllAlbumServlet() {
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
		
		ArrayList<Album> albums = new ArrayList<Album>();
		IMusicService ims = new MusicServiceImpl();
		albums = ims.queryAllAlbum();
		
		if(albums!=null) {
			out.print(new Gson().toJson(new ReturnListInfo<Album>("获取专辑成功",true,albums)));
		}else {
			out.print(new Gson().toJson(new ReturnListInfo<Album>("获取专辑失败",false,null)));
		}
	}

}
