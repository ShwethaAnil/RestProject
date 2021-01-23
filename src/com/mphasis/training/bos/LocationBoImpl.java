package com.mphasis.training.bos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.daos.LocationDao;
import com.mphasis.training.daos.LocationDaoImpl;
import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Location;

public class LocationBoImpl implements LocationBo {

	LocationDao locationDao = null;

	public LocationBoImpl() {
		locationDao = new LocationDaoImpl();
	}

	@Override
	public void addLocation(Location l) throws BuisnessException {

		if ((l.getLcode() + "").matches("^[1-9][0-9]{2}[0-9]*")) {
			int i = locationDao.addLocation(l);

			if (i > 0) {
				System.out.println(i + " row added.");
			} else
				System.out.println("no row added.");

		} else
			throw new BuisnessException("Lcode wrong format.");

	}

	@Override
	public void editLocation(int lcode, String lname) throws BuisnessException {

		if ((lcode + "").matches("^[1-9][0-9]{2}[0-9]*")) {
			int i = locationDao.editLocation(lcode, lname);
			if (i > 0) {
				System.out.println(i + " row updated.");
			} else
				System.out.println("no row updated.");
		} else {
			throw new BuisnessException("lcode wrong format.");
		}

	}

	@Override
	public void deleteLocation(int lcode) throws BuisnessException {

		if ((lcode + "").matches("^[1-9][0-9]{2}[0-9]*")) {
			int i = locationDao.deleteLocation(lcode);

			if (i > 0) {
				System.out.println(i + " deleted.");
			} else
				System.out.println("no row deleted.");

		} else {
			throw new BuisnessException("lcode wrong format.");
		}

	}

	@Override
	public List<Location> getAllLocations() throws BuisnessException {
		List<Location> locations = locationDao.getAllLocations();
		if (locations.isEmpty()) {
			throw new BuisnessException("No Locations in the list");
		}
		return locations;
	}

	@Override
	public Location getLocationById(int lcode) throws BuisnessException, SQLException {
		Location l;

		if ((lcode + "").matches("^[1-9][0-9]{2}[0-9]*")) {
			l = locationDao.getLocationById(lcode);
		} else
			throw new BuisnessException("lcode wrong format.");

		if (l == null) {
			throw new BuisnessException("location code doesnt exist.");
		}
		return l;
	}

}
