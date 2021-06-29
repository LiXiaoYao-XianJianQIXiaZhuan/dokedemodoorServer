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
 * Servlet implementation class QueryTripByIdServlet
 */
@WebServlet("/QueryTripByIdServlet")
public class QueryTripByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTripByIdServlet() {
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
		Trip trip = new Trip();
		ITripService its = new TripServiceImpl();
		trip = its.queryTripById(id);
		
		if(trip!=null) {
				out.print(new Gson().toJson(new ReturnInfo<Trip>("查询成功",true,trip)));
			}else {
				out.print(new Gson().toJson(new ReturnInfo<Trip>("查询失败",false,null)));
			}
		}
	}
