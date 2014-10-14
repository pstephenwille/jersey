package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephen on 9/27/2014  .
 */
public class ActivityRepositoryStub implements ActivityRepository {

    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity1 = new Activity();
        activity1.setDescription("swimming");
        activity1.setDuration(55);

        activities.add(activity1);
        
        Activity activity2 = new Activity();
        activity2.setDescription("cycling");
        activity2.setDuration(120);

        activities.add(activity2);

        return activities;
    }

//    public Activity findActivity(String activityId) {
//
//        if(activityId.equals("777")) return  null;
//
//        Activity activity1 = new Activity();
//        activity1.setId("444");
//        activity1.setDescription("swimming");
//        activity1.setDuration(55);
//
//        return activity1;
//    }

    public Activity findActivity(String activityId) {
        if (activityId.equals("777")) {
            System.out.printf("xxxxxxx");
            return null;
        }

        Activity activity1 = new Activity();
        activity1.setId("444");
        activity1.setDescription("swimming");
        activity1.setDuration(55);

        User user = new User();
        user.setId("555");
        user.setName("stv");
        activity1.setUser(user);

        return activity1;
    }


    public void create(Activity activity) {
        //persist data
    }
}
