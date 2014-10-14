package test.com.pluralsight.client;

import com.pluralsight.client.ActivityClient;
import com.pluralsight.model.Activity;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class ActivityClientTest extends TestCase {

    @Test
    public void testCreate() {
        ActivityClient client = new ActivityClient();
        Activity activity = new Activity();
        activity.setDescription("swimming");
        activity.setDuration(300);

    }

    @Test
    public void testGet() {
        ActivityClient client = new ActivityClient();
        Activity activity = client.get("555");

        System.out.println(activity);
        assertNotNull(activity);
    }

    @Test
    public void testGetList() {
        ActivityClient client = new ActivityClient();

        List<Activity> activities = client.get();
        assertNotNull(activities);

    }

    @Test(expected = RuntimeException.class)
    public void testGetWithBadRequest() {
        ActivityClient client = new ActivityClient();

        client.get("1");
        System.out.println(client);
//        assertNotNull(client);
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithNotFound() {
        ActivityClient client = new ActivityClient();

        client.get("777");
        System.out.println(client);
//        assertNotNull(client);
    }

}


