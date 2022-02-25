package com.example.uiteststudy


/*
    Instrumented Test 시 Method 가 open 이 아니면 다음과 같은 오류가 발생.
    Kotlin 의 경우 static 이 default 값이기 때문에 발생하는 이슈로 보임.

    org.mockito.exceptions.base.MockitoException:
    Cannot mock/spy class com.example.uiteststudy.MockSample
    Mockito cannot mock/spy because :
     - final class
        at com.example.uiteststudy.ExampleInstrumentedTest.mock_sample_test(ExampleInstrumentedTest.kt:64)
 */
open class MockSample {
    /*
    Instrumented Test 시 Method 가 open 이 아니면 다음과 같은 오류가 발생.
    Kotlin 의 경우 static 이 default 값이기 때문에 발생하는 이슈로 보임.

    org.mockito.exceptions.misusing.MissingMethodInvocationException:
    when() requires an argument which has to be 'a method call on a mock'.
    For example:
        when(mock.getArticles()).thenReturn(articles);

    Also, this error might show up because:
    1. you stub either of: final/private/equals()/hashCode() methods.
       Those methods *cannot* be stubbed/verified.
       Mocking methods declared on non-public parent classes is not supported.
    2. inside when() you don't call method on mock but on some other object.
     */
    open fun getNumber(): Int {
        return 1
    }

    open fun getString(): String {
        return "get String"
    }

    open fun getList(): List<String> {
        return listOf("123")
    }
}