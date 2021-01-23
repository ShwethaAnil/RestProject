package com.mphasis.training.exmappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.mphasis.training.exceptions.DataNotPresentException;

@Provider
public class DataNotPresentExceptionMapper implements ExceptionMapper<DataNotPresentException> {

	@Override
	public Response toResponse(DataNotPresentException ex) {
		ErrorMessage message=new ErrorMessage(ex.getMessage(), 404, "http://www.google.com");
		return Response.status(Status.NOT_FOUND).entity(message).build();
	}

}
