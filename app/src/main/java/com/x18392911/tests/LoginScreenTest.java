package com.x18392911.final.recommendations.tests;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import android.util.Patterns;

import org.junit.Test;

public class LoginScreenTest {

    @Test
        public void password_checker_nulls(){
        assertTrue("hello@live.com".contains("@"));
        assertFalse("hello.com".contains("@"));
        assert (Patterns.EMAIL_ADDRESS.matcher("name@email.com").matches());
    }

    @Test
        public void password_length(){

        String password = "12345678";
        String password1 = "adam";
        String password2 = "a6575737"; //test to show the length of a string

        assertTrue(password.length()>6);
        assert(password1.length()>6);
        assertEquals(password2.length(), 8);
    }

    @Test
    public void password_right(){
        String password4 = "tessstt";
        String password5 = "testterr";

        assertEquals(password4, password4);
        assertFalse(password4!=password4);
        assertTrue(password5==password5);
    }
}