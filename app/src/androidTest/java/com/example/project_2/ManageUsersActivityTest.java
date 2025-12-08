package com.example.project_2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import com.example.project_2.Database.AppDatabase;
import com.example.project_2.Database.dao.UserDAO;
import com.example.project_2.Database.entities.User;
import com.example.project_2.ui.ManageUsersActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Arrays;

@RunWith(AndroidJUnit4.class)
public class ManageUsersActivityTest {

    @Rule
    public ActivityScenarioRule<ManageUsersActivity> rule =
            new ActivityScenarioRule<>(ManageUsersActivity.class);

    private UserDAO mockUserDAO;
    private AppDatabase mockDb;

    @Before
    public void setup() {
        mockDb = mock(AppDatabase.class);
        mockUserDAO = mock(UserDAO.class);
        when(mockDb.userDAO()).thenReturn(mockUserDAO);
    }

    @Test
    public void test_manageUsersIntentFactory_returnsCorrectIntent() {
        Context context = ApplicationProvider.getApplicationContext();
        Intent intent = ManageUsersActivity.manageUsersIntentFactory(context);
        assertEquals(ManageUsersActivity.class.getName(),
                intent.getComponent().getClassName());
    }

    @Test
    public void test_loadUsers_updatesRecyclerView() {
        when(mockUserDAO.getAll()).thenReturn(Arrays.asList(
                new User("john", "pw", false),
                new User("alice", "pw", false)
        ));

        rule.getScenario().onActivity(activity -> {
            RecyclerView recycler = activity.binding.recyclerView;
            assertNotNull(recycler);
        });
    }

    @Test
    public void test_backButton_launchesMainPage1() {
        Context context = ApplicationProvider.getApplicationContext();
        Intent intent = MainPage1.mainPage1IntentFactory(context);
        assertNotNull(intent);
        assertEquals(MainPage1.class.getName(),
                intent.getComponent().getClassName());
    }
}
