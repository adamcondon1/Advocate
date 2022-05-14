package com.x18392911.final.recommendations.tests;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class EspressoUITest3{

@Test
fun buttonTestLiveData() {
    onView(withId(R.id.popular)).perform(click())
    onView(withId(R.id.upcoming)).perform(click())
    onView(withId(R.id.toprated)).perform(click())
    onView(withId(R.id.pay)).perform(click())
}
}