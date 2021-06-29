package servlet.tripServlet;

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
import pojo.trip.Trip;
import service.tripService.ITripService;
import service.tripService.impl.TripServiceImpl;

/**
 * Servlet implementation class QueryAllTripServlet
 */
@WebServlet("/QueryAllTripServlet")
public class QueryAllTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllTripServlet() {
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
		
		ArrayList<Trip> trips = new ArrayList<Trip>();
		ITripService its = new TripServiceImpl();
		trips = its.queryAllTrip();
		
		if(!trips.isEmpty()) {
			out.print(new Gson().toJson(new ReturnListInfo<Trip>("获取所有行程成功",true,trips)));
		}else {
			out.print(new Gson().toJson(new ReturnListInfo<Trip>("获取所有行程失败",false,null)));
		}
	}

}
