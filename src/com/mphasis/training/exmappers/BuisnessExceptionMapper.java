package com.mphasis.training.exmappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.mphasis.training.exceptions.BuisnessException;

public class BuisnessExceptionMapper implements ExceptionMapper<BuisnessException>  {

	@Override
	public Response toResponse(BuisnessException ex) {
		// TODO Auto-generated method stub
		ErrorMessage message=new ErrorMessage(ex.getMessage(), 406, "Related with Buisnesslogic");
		return Response.status(Status.NOT_ACCEPTABLE).entity(message).build();
	}
}
