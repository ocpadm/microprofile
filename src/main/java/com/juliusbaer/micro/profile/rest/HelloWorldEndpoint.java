package com.juliusbaer.micro.profile.rest;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@ApplicationScoped
@Path("/hello")
@Api(value = "/hello", description = "JCT REST service end-points exposed to ARA") 
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
	@Path("/say")
	@ApiOperation(value = "All Profiles for Host", notes = "List all profiles configured on a specific Host")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Server error, check log files") })
	public Response doGet() {
		return Response.ok("Hello from WildFly Swarm!").build();
	}
}