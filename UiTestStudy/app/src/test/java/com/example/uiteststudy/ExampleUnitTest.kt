package com.example.uiteststudy

import org.junit.Test
import org.junit.Before
import com.google.common.truth.Truth.assertThat

/**
 * Truth 를 사용한 예제 작성 중 입니다.
 */
class ExampleUnitTest {
    private lateinit var calCul: Calculator

    @Before
    fun before() {
        calCul = Calculator()
    }

    @Test
    fun plus_test() {
        val result = calCul.plusNum(10,20)
        assertThat(result).isEqualTo(40)
    }

    @Test
    fun multi_test() {
        val result = calCul.multiNum(10, 10)
        assertThat(result).isEqualTo(100)
        assertThat(result + 10).isEqualTo(110)
        assertThat(result).isNotNull()
        plus_test()
    }

    fun sample(): Int {
        return 10
    }
}