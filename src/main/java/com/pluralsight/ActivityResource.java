package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("activities")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ActivityResource {
    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    public Activity createActivity(Activity activity) {
        activityRepository.create(activity);
        return activity;
    }

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) {

        Activity activity = new Activity();
        activity.setDescription(formParams.getFirst("description"));
        activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));

        activityRepository.create(activity);
        return activity;
    }

    @GET
    public List<Activity> getAllActivities() {
        return activityRepository.findAllActivities();
    }

    @GET
    @Path("{activityId}")//webapi/activities/1111
    public Response getActivity(@PathParam("activityId") String activityId) {
        System.out.printf(" activiyID ");
        System.out.printf(activityId);
        if (activityId == null || activityId.length() < 3) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Activity activity = activityRepository.findActivity(activityId);

        if (activity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(activity).build();


    }


    @GET
    @Path("{activityId}/user")//webapi/activities/1111/user
    public User getActivityUser(@PathParam("name") String name) {
        return activityRepository.findActivity(name).getUser();
    }

}

