package com.microservices.ch3
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

// 널이 아닌 값만 직렬화할 것임을 나타낸다.
// 전역적으로 널 객체를 직렬화하지 않도록 하기 위해선 application.yaml 에 다음 문장을 추가한다.
// spring.jackson.default-property-inclusion: NON_NULL
@JsonInclude(Include.NON_NULL)
data class Customer (var id: Int = 0, var name: String = "", var telephone: Telephone? = null) {
    data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
}