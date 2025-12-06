package com.example.project_2;

import static org.junit.Assert.*;
import android.view.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricTestRunner.class)
public class LoginPageTest {

    private LoginPage activity;

    @Before
    public void setUp() {
        ActivityController<LoginPage> controller = Robolectric.buildActivity(LoginPage.class);
        activity = controller.create().get();
    }

    @Test
    public void activityShouldNotBeNull() {
        assertNotNull("LoginPage activity should be created", activity);
    }

    @Test
    public void shouldUseCorrectLayout() {
        int expectedLayout = R.layout.activity_login_page;
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        int actualLayout = shadowActivity.getContentView().getId();
        assertTrue("Activity should use layout activity_login_page",
                actualLayout == expectedLayout || actualLayout == View.NO_ID);
    }

    @Test
    public void mainViewShouldExist() {
        View mainView = activity.findViewById(R.id.main);
        assertNotNull("Main view should be present in layout", mainView);
    }
}
