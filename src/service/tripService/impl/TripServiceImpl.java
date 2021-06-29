package service.tripService.impl;

import java.util.ArrayList;

import dao.tripDao.ITripDao;
import dao.tripDao.impl.TripDaoImpl;
import pojo.trip.Trip;
import service.tripService.ITripService;

public class TripServiceImpl implements ITripService{
	ITripDao tripDao = new TripDaoImpl();
	
	@Override
	public boolean addTrip(Trip trip) {
		return tripDao.addTrip(trip);
	}

	@Override
	public ArrayList<Trip> queryAllTrip() {
		return tripDao.queryAllTrip();
	}

	@Override
	public boolean updateTripById(Trip trip) {
		return tripDao.updateTripById(trip);
	}

	@Override
	public Trip queryTripById(int id) {
		return tripDao.queryTripById(id);
	}

	@Override
	public boolean deleteTripById(int id) {
		// TODO 自动生成的方法存根
		return tripDao.deleteTripById(id);
	}
	
	
}
