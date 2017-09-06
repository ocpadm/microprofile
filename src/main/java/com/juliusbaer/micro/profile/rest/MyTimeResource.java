package com.juliusbaer.micro.profile.rest;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/time")
@Api(value = "/time", description = "JCT generic REST service end-points")
public class MyTimeResource {


    @Inject
    LocalDateTime dateTime;

    @GET
    @Path("/datetimejson")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Return CLI script for specific JCT profile",
                  notes = "Generate and return JBoss CLI script for specific profile ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Server error, check log files")})
    public JsonObject getDateTimeJson() {

        return Json.createObjectBuilder()
                   .add("date",
                        Json.createObjectBuilder().add("dayOfWeek", dateTime.getDayOfWeek().name())
                            .add("dayOfMonth", dateTime.getDayOfMonth()).add("month", dateTime.getMonth().name())
                            .add("monthNumber", dateTime.getMonthValue()).add("year", dateTime.getYear()))
                   .add("time",
                        Json.createObjectBuilder().add("hour", dateTime.getHour()).add("minutes", dateTime.getMinute())
                            .add("seconds", dateTime.getSecond()).add("nanoseconds", dateTime.getNano())).build();
    }
}
