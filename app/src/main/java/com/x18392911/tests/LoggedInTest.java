package com.x18392911.final.recommendations.tests;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

import android.app.Activity;
import android.app.Instrumentation;

import com.x18392911.final.recommendations.LoggedIn;
import com.x18392911.final.recommendations.LoginScreen;
import com.x18392911.final.recommendations.Profile;
import com.x18392911.final.recommendations.R;
import com.x18392911.final.recommendations.Register;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

class LoggedInTestButton {
    @Rule
   // public ActivityTestRule<LoggedIn> mActivityTestRule = new ActivityTestRule<LoggedIn>(LoggedIn.class);


    private LoggedIn mActivity = null;
    private LoggedIn email = null;
    private LoggedIn password = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Register.class.getName(),null, false);
    Instrumentation.ActivityMonitor monitor1 = getInstrumentation().addMonitor(LoginScreen.class.getName(),null, false);
    Instrumentation.ActivityMonitor monitor2 = getInstrumentation().addMonitor(Profile.class.getName(),null, false);

    @Before
    public void setUp() throws Exception {
    //    mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchOfSignUp(){
        assertNotNull(mActivity.findViewById(R.id.RegisterBtn));

    //   R.id.RegisterBtn.perform(click());
        Activity signup = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        assertNotNull(signup);

    }

    @Test
    public void testLaunchOfMap(){
        assertNotNull(mActivity.findViewById(R.id.LoginBtn));

        Activity goToMap = getInstrumentation().waitForMonitorWithTimeout(monitor1, 5000);
        assertNotNull(goToMap);
    }
    @Test
    public void signInButton(){
        assertNotNull(mActivity.findViewById(R.id.LoginBtn));
;       Activity signIn = getInstrumentation().waitForMonitorWithTimeout(monitor2, 20000);
        assertNotNull(signIn);

    }
    
    @After
    public void tearDown() throws Exception {

        mActivity = null;
    }
}