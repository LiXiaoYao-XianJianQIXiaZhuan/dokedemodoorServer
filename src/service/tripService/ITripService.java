package service.tripService;

import java.util.ArrayList;

import pojo.trip.Trip;

public interface ITripService {
	
	public boolean addTrip(Trip trip);
	
	public ArrayList<Trip> queryAllTrip();
	
	public boolean updateTripById(Trip trip);
	
	public Trip queryTripById(int id);
	
	public boolean deleteTripById(int id);
}
