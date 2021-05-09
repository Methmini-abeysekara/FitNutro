package com.example.fitnutro;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdddetailsTest {

    @Rule
    public ActivityTestRule<Adddetails> adddetailsActivityTestRule = new ActivityTestRule<Adddetails>(Adddetails.class);
    private Adddetails adddetailsActivity = null;

    @Before
    public void setUp() throws Exception {
        adddetailsActivity = adddetailsActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch(){
        View view = adddetailsActivity.findViewById(R.id.time7);
        Assert.assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
        adddetailsActivity = null ;

    }
}