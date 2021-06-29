package dao.tripDao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.tripDao.ITripDao;
import pojo.trip.Trip;
import util.publicDBUtil.DBUtil;
import util.tripDBUtil.TripDBUtil;

public class TripDaoImpl implements ITripDao{
	
	public boolean addTrip(Trip trip) {
		String sql = "insert into trip(time,place,title) values(?,?,?)";
		Object[] params = {trip.getTime(),trip.getPlace(),trip.getTitle()};
		int id = TripDBUtil.executeUpdateGet(sql, params);
		if(id>-1) {
			trip.setId(id);
			System.out.println("Dao层添加数据成功");
			return true;
		}else {
			System.out.println("Dao层添加数据失败");
			return false;
		}
	}

	@Override
	public ArrayList<Trip> queryAllTrip() {
		Trip trip = null;
		ArrayList<Trip> trips = new ArrayList<Trip>();
		ResultSet rs = null;
		try {
			String sql = "select * from trip order by time desc limit 0,1000";
			rs = TripDBUtil.executeQuery(sql, null);
			while(rs.next()) {
				int id = rs.getInt("id");
				String time = rs.getString("time");
				String place = rs.getString("place");
				String title = rs.getString("title");
				trip = new Trip(id,time,place,title);
				trips.add(trip);
			}
			return trips;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("dao层获取数据失败了");
			return null;
		}finally {
			try {
				TripDBUtil.closeAll(rs, TripDBUtil.pstmt, TripDBUtil.connection);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean updateTripById(Trip trip) {
		String sql = "update trip set time=?,place=?,title=? where id=?";
		Object[] params = {trip.getTime(),trip.getPlace(),trip.getTitle(),trip.getId()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public Trip queryTripById(int id) {
		String sql = "select * from trip where id=?";
		Object[] params = {id};
		ResultSet rs = TripDBUtil.executeQuery(sql, params);
		Trip trip = null;
		try {
			if(rs.next()) {
				int tripid = rs.getInt("id");
				String time = rs.getString("time");
				String place = rs.getString("place");
				String title = rs.getString("title");
				trip = new Trip(tripid,time,place,title);
			}
			return trip;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}finally {
			try {
				TripDBUtil.closeAll(rs, TripDBUtil.pstmt, TripDBUtil.connection);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean deleteTripById(int id) {
		String sql = "delete from trip where id=? ";
		Object[] params = {id};
		return TripDBUtil.executeUpdate(sql, params);
	}

}
