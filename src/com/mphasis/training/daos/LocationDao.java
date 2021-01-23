package com.mphasis.training.daos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.pojos.Location;
import com.mphasis.training.util.DbUtil;

public interface LocationDao {

	public int addLocation(Location l);

	public int editLocation(int lcode, String lname);

	public int deleteLocation(int lcode);

	public Location getLocationById(int lcode) throws SQLException;

	public List<Location> getAllLocations();

}