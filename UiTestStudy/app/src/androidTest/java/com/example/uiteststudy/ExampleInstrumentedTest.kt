package com.example.uiteststudy

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

/**
 * Espresso 를 사용한 UI Test
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)
    private lateinit var mock: MockSample

    @Before
    fun before() {
        // setUp
    }

    @After
    fun after() {
        // fin
    }

    @Test
    fun mock_test() {
        mock = Mockito.mock(MockSample::class.java)

        Mockito.`when`(mock.getNumber()).thenReturn(222)
        Mockito.`when`(mock.getString()).thenReturn("100")

        // Truth 를 사용하는 부분에서 테스트가 실패하게 되면 실행 된 앱은 종료된다.
//        assertThat(mock.getNumber()).isEqualTo(22322)
        assertThat(mock.getNumber()).isEqualTo(222)
        Mockito.verify(mock, Mockito.times(1)).getNumber()
        Mockito.verify(mock, Mockito.never()).getString()

        Espresso.onView(withId(R.id.text1))
            .perform(ViewActions.typeText(mock.getNumber().toString()), ViewActions.closeSoftKeyboard())

        Mockito.`when`(mock.getNumber()).thenReturn(369369)
        // verify 로 검증이 가능한 횟수는 Mockito 를 제외한 곳에서 사용한 횟수는 count 하지 않는다.
        Mockito.verify(mock, Mockito.times(2)).getNumber()
        Espresso.onView(withId(R.id.text1))
            .perform(ViewActions.clearText(), ViewActions.typeText(mock.getNumber().toString()), ViewActions.closeSoftKeyboard())
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