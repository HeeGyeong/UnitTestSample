package com.example.uiteststudy

import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class TestSampleTest {

    private lateinit var mock: TestSample
    private lateinit var spyMock: TestSample

    @Before
    fun before() {
        print("==== Test Start ====\n")
        mock = Mockito.mock(TestSample::class.java)
        spyMock = Mockito.spy(Mockito.mock(TestSample::class.java))
    }

    @After
    fun after() {
        print("==== Test Fin ====\n")
    }

    @Test
    fun `basic Mock test`() {
        // Given
        Mockito.`when`(mock.getParamNumber(123)).thenReturn(124)
        Mockito.`when`(mock.getNumber()).thenReturn(100)
        Mockito.`when`(mock.getString()).thenReturn("Test")
        // 기존 함수 결과와 다른 결과 값을 return해도 상관 없다. return값을 지정
        Mockito.`when`(mock.getParamNumber2(1)).thenReturn(300)

        // When

        // Then
        assertThat(mock.getParamNumber(123)).isEqualTo(124)
        assertThat(mock.getNumber()).isEqualTo(100)
        assertThat(mock.getString()).isEqualTo("Test")
        assertThat(mock.getParamNumber2(1)).isEqualTo(300)
        print("==== Fin Basic Mock Test ====\n")
    }

    @Test
    fun `Spy Mock test`() {
        //Given
        val number1 = spyMock.getParamNumber(123)
        var number2 = spyMock.getParamNumber(100)
        assertThat(number1).isEqualTo(124)
        assertThat(number2).isEqualTo(101)

        //When
        number2 += number1

        //Then
        assertThat(number2).isEqualTo(225)

        print("==== Fin Spy Mock Test ====\n")
    }
}