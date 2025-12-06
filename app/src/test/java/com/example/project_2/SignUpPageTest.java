package com.example.project_2;

import static org.junit.Assert.*;
import android.content.Context;
import android.content.Intent;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.android.controller.ActivityController;
import java.util.Objects;

@RunWith(RobolectricTestRunner.class)
public class SignUpPageTest {

    private SignUpPage activity;

    @Before
    public void setUp() {
        ActivityController<SignUpPage> controller = Robolectric.buildActivity(SignUpPage.class);
        activity = controller.create().start().resume().get();
    }

    @Test
    public void activityShouldBeCreated() {
        assertNotNull("SignUpPage should be created successfully", activity);
    }

    @Test
    public void shouldSetBindingRootView() {
        assertNotNull("Binding should not be null", activity.binding);
        assertNotNull("Root view from binding should be set", activity.binding.getRoot());
    }

    @Test
    public void backButtonShouldLaunchMainActivity() {
        assertNotNull("Back button should be present", activity.binding.backButtonMainPage2);

        activity.binding.backButtonMainPage2.performClick();

        Intent expectedIntent = MainActivity.mainActivityIntentFactory(activity.getApplicationContext());
        Intent actualIntent = Shadows.shadowOf(activity).getNextStartedActivity();

        assertNotNull("Clicking back button should start an activity", actualIntent);
        assertEquals("Back button should launch MainActivity",
                expectedIntent.getComponent(), actualIntent.getComponent());
    }

    @Test
    public void signUpPageIntentFactoryShouldReturnValidIntent() {
        Context context = ApplicationProvider.getApplicationContext();
        Intent intent = SignUpPage.signUpPageIntentFactory(context);

        assertNotNull("Intent from factory should not be null", intent);
        assertEquals("Intent should point to SignUpPage",
                SignUpPage.class.getName(), Objects.requireNonNull(intent.getComponent()).getClassName());
    }
}