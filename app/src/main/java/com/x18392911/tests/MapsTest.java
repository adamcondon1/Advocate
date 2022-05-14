package com.x18392911.final.recommendations.tests;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.util.Patterns;

import org.junit.Test;

//espresso onclick test

public class MapsTest {


onView(withContentDescription("Google Map")).perform(click());

onView(withContentDescription("marker title. ")).perform(click());

private UiDevice uiDevice = UiDevice.getInstance(getInstrumentation());
private UiObject mMarker1 = uiDevice.findObject(new UiSelector().descriptionContains("The title of marker"));
try {
    mMarker1.click();
} catch (UiObjectNotFoundException e) {

    e.printStackTrace();
}
   
}