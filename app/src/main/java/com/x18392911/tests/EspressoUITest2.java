package com.x18392911.final.recommendations.tests;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class EspressoUITest2{

@Test
fun () buttonTestMainActivity{
    onView(withId(R.id.profile)).perform(click())
    onView(withId(R.id.movies)).perform(click())
    onView(withId(R.id.recommendations)).perform(click())
    onView(withId(R.id.maps)).perform(click())
    onView(withId(R.id.livedata)).perform(click())
    onView(withId(R.id.freerecommendations)).perform(click())
}
}