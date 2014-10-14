package com.pluralsight.repository;

import com.pluralsight.model.Activity;

import java.util.List;

/**
 * Created by stephen on 9/27/2014.
 */
public interface ActivityRepository {
    List<Activity> findAllActivities();

    Activity findActivity(String activityId);

    void create(Activity activity);

}
