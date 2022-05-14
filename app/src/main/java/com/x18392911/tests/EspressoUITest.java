package com.x18392911.final.recommendations.tests;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class EspressoUITest{

@Test
fun buttonTestRegister() {
    onView(withId(R.id.login)).perform(typeText("User"))
    onView(withId(R.id.register)).perform(click())
    onView(withText("User!")).check(matches(isDisplayed()))
}

}