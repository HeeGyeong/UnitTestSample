package com.example.uiteststudy

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.never
import org.mockito.Mockito.timeout
import org.mockito.Mockito.times

class MockSampleTest {

    private lateinit var mock: MockSample

    @Before
    fun before() {
        mock = Mockito.mock(MockSample::class.java)
        // when 함수를 사용하여 Mock 객체의 행동 설정. Test Stub.
        Mockito.`when`(mock.getNumber()).thenReturn(222)
        Mockito.`when`(mock.getString()).thenReturn("100")
        //Mockito.`when`(mock.getList()).
    }

    @Test
    fun mockito_test() {
        // Mock 객체에 넣은 값을 확인.
        assertThat(mock.getNumber()).isEqualTo(222)
        assertThat(mock.getString()).contains("100")
    }

    @Test
    fun mockito_answer_test() {
        answer()

        assertThat(mock.getNumber()).isEqualTo(369)
        assertThat(mock.getList()).hasSize(1)
    }

    @Test
    fun verify_test() {
        mock.getString()
        mock.getList()

        Mockito.verify(mock).getList() // 호출이 되었는가
        Mockito.verify(mock, times(1)).getString() // 1회 호출 되었는가
        Mockito.verify(mock, never()).getNumber() // 호출을 하지 않았는가

        mock.getString()
        Mockito.verify(mock, times(2)).getString() // 2회 호출 되었는가
        //Mockito.verify(mock, Mockito.)
    }

    private fun answer() {
        Mockito.`when`(mock.getList()).thenAnswer {
            // it == mock.getList()
            println("print Message")
            println("it.method ? ${it.method.name}")
            println("it.mock ? ${it.mock}")

            return@thenAnswer listOf("mock")
        }

        Mockito.`when`(mock.getNumber()).thenAnswer {
            println("mock.getNumber ? ${it.arguments.size}")

            return@thenAnswer 369
        }

    }
}