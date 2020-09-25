package com.test.room

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.accessibility.AccessibilityChecks
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.test.room.recycleview.TestUtils.withRecyclerView
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    companion object {
        @BeforeClass
        @JvmStatic
        fun enableAccessibilityChecks() {
            AccessibilityChecks.enable()
            AccessibilityChecks.enable()
                .setRunChecksFromRootView(true)
        }
    }

    @Test
    fun useAppContext() {
        onView(withId(R.id.button1))
            .check(matches(withText("From Room database")))

        onView(withId(R.id.button1))
            .perform(ViewActions.click())
        
        onView(withRecyclerView(R.id.articleRecycleView)
            .atPositionOnView(1, R.id.author))
            .check(matches(withText("Ananth")));
    }
}