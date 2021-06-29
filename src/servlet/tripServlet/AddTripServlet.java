package servlet.tripServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pojo.ReturnInfo;
import pojo.trip.Trip;
import service.tripService.ITripService;
import service.tripService.impl.TripServiceImpl;

/**
 * Servlet implementation class AddTripServlet
 */
@WebServlet("/AddTripServlet")
public class AddTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTripServlet() {
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
		String time = request.getParameter("time");
		String place = request.getParameter("place");
		String title = request.getParameter("title");
//		System.out.println(time + place + title);
		Trip trip = new Trip(time,place,title);
		ITripService its = new TripServiceImpl();
		if(its.addTrip(trip)) {
			out.print(new Gson().toJson(new ReturnInfo<Trip>("添加成功",true,null)));
		}else {
			out.print(new Gson().toJson(new ReturnInfo<Trip>("添加失败",false,null)));
		}
	}

}
