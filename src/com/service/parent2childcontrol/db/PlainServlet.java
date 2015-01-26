package com.service.parent2childcontrol.db;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.service.parent2childcontrol.pojo.ChildDevice;

@Path("/main")
public class PlainServlet {
	private static final long serialVersionUID = 1L;
	private static final String gcmAPIKey = "AIzaSyDa9zfG9mOMMB-eoJBLdg24Y46_lkuLs0o";
    
    public PlainServlet() 
    {
        super();
    }
    
    @GET
    @Path("/childdevice")
    @Produces(MediaType.APPLICATION_JSON)
    public ChildDevice getChildDevice()
    {
    
    	ChildDevice cd = new ChildDevice();
    	
    	cd.setData("data");
    	cd.setGcmId("Gcm Id");
    	cd.setPhoneNumber("phone Number");
    	cd.setRequestId("request Id");
    	cd.setResponseId("Response ID");
    	cd.setServiceId("serviceId");
    	
    	return cd;
    }
    
    @POST
    @Path("/putchilddevice")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ChildDevice putChildDevice(ChildDevice cd)
    {
    	return cd;
    }
}