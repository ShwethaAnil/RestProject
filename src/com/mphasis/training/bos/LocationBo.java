package com.mphasis.training.bos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Location;

public interface LocationBo {

	public void addLocation(Location l) throws BuisnessException;

	public void editLocation(int lcode, String ljname) throws BuisnessException;

	public void deleteLocation(int lcode) throws BuisnessException;

	public List<Location> getAllLocations() throws BuisnessException;

	public Location getLocationById(int lcode) throws BuisnessException, SQLException;
}
