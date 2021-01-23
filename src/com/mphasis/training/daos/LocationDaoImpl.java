package com.mphasis.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.training.pojos.Location;
import com.mphasis.training.util.DbUtil;

public class LocationDaoImpl implements LocationDao {

	Connection con = null;

	public LocationDaoImpl() {
		con = DbUtil.openConnection();
	}

	@Override
	public int addLocation(Location l) {
		int i = 0;

		try {
			String query = "insert into locations values(?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, l.getLcode());
			pst.setString(2, l.getLname());

			i = pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public int editLocation(int lcode, String lname) {
		int i = 0;

		try {
			String query = "update locations set lname=? where lcode=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, lname);
			pst.setInt(2, lcode);

			i = pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public int deleteLocation(int lcode) {
		int i = 0;

		try {
			String query = "delete from locations where lcode=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, lcode);

			i = pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public Location getLocationById(int lcode) throws SQLException {
		Location l = new Location();
		PreparedStatement pst = null;

		ResultSet rs = null;

		try {
			String query = "select * from locations where lcode=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, lcode);
			rs = pst.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			if (rs.next()) {
				l.setLcode(rs.getInt("lcode"));
				l.setLname(rs.getString("lname"));
			}

		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			rs.close();
			pst.close();
		}
		return l;
	}

	@Override
	public List<Location> getAllLocations() {
		List<Location> locations = new ArrayList<>();

		try {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from locations");

			while (rs.next()) {

				Location l = new Location();
				l.setLcode(rs.getInt("lcode"));
				l.setLname(rs.getString("lname"));

				locations.add(l);

			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return locations;
	}

}
