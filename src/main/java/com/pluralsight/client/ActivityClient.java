package com.pluralsight.client;

import com.pluralsight.model.Activity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ActivityClient {
    public Client client;

    public ActivityClient() {
        client = ClientBuilder.newClient();
    }


//    webapi/activities/woot
    public Activity get(String id) {

        WebTarget target = client.target("http://localhost:8080/webapi/");

        Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get();
//        String response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(String.class);
//        System.out.printf(response);

        if (response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ": server errr");
        }
        return response.readEntity(Activity.class);
    }


    public List<Activity> get() {
        WebTarget target = client.target("http://localhost:8080/webapi/");

        List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Activity>>(){});

        return response;
    }


}
