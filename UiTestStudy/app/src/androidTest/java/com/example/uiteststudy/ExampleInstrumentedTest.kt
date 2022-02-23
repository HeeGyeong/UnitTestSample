package com.example.uiteststudy

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Espresso 를 사용한 UI Test
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun before() {
        // setUp
    }

    @After
    fun after() {
        // fin
    }

    @Test
    fun test_ui_test_sample() {
        Espresso.onView(withId(R.id.text1))
            .perform(ViewActions.typeText("input text 1"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.text2))
            .perform(ViewActions.typeText("input text 2"), ViewActions.closeSoftKeyboard())
        // perform 내부에 같은 아이템으로 순차적 이벤트를 추가할 수 있다.
        Espresso.onView(withId(R.id.text2))
            .perform(ViewActions.clearText(), ViewActions.typeText("change text 2222"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.text3))
            .perform(ViewActions.typeText("input text 3"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.toast))
            .perform(ViewActions.click())
        Espresso.onView(withId(R.id.clear))
            .perform(ViewActions.click())
    }

    @Test
    fun one_test_sample() {
        Espresso.onView(withId(R.id.text1))
            .perform(ViewActions.typeText("input text 1"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.clear))
            .perform(ViewActions.click())
    }

    @Test
    fun combine_test() {
        test_ui_test_sample()
        one_test_sample()
    }
}