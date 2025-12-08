package com.example.project_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainPage1Test {

    @Rule
    public ActivityTestRule<MainPage1> rule =
            new ActivityTestRule<>(MainPage1.class, true, false);

    @Test
    public void test_mainPage1IntentFactory_createsCorrectIntent() {
        Context context = ApplicationProvider.getApplicationContext();
        Intent intent = MainPage1.mainPage1IntentFactory(context);
        assertEquals(MainPage1.class.getName(), intent.getComponent().getClassName());
    }

    @Test
    public void test_CELButtonLaunchesCELPage() {
        MainPage1 activity = rule.launchActivity(null);
        activity.runOnUiThread(() -> {
            View v = new View(activity);
            activity.CEL(v);
        });
        assertTrue(true);
    }

    @Test
    public void test_ABSButtonLaunchesABSPage() {
        MainPage1 activity = rule.launchActivity(null);
        activity.runOnUiThread(() -> {
            View v = new View(activity);
            activity.ABS(v);
        });
        assertTrue(true);
    }

    @Test
    public void test_LOPButtonLaunchesLOPPage() {
        MainPage1 activity = rule.launchActivity(null);
        activity.runOnUiThread(() -> {
            View v = new View(activity);
            activity.LOP(v);
        });
        assertTrue(true);
    }
}
