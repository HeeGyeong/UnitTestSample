package com.example.uiteststudy

import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Truth 를 사용한 Unit Test
 */
class ExampleUnitTest {
    private lateinit var calCul: Calculator

    @Before
    fun before() {
        calCul = Calculator()
    }

    @After
    fun after() {

    }

    @Test
    fun plus_test() {
        val result = calCul.plusNum(10, 20)
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun multi_test() {
        val result = calCul.multiNum(10, 10)
        assertThat(result).isEqualTo(100)
        assertThat(result + sample()).isEqualTo(110)
        assertThat(result).isNotNull()
        plus_test()
    }

    private fun sample(): Int {
        return 10
    }

    @Test
    fun truth_type_test() {
        assertThat(true).isTrue()
        assertThat(10.1f).isGreaterThan(10)
        assertThat(listOf("1","2")).contains(listOf("1","2"))
        assertThat("string").hasLength(6)
    }

    @Test
    fun junit_test() {
        val result = 10
        Assert.assertEquals(result, 10)
        Assert.assertNull(null)
    }
}