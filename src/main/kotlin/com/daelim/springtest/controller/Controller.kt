package com.daelim.springtest.main.controller

import com.daelim.springtest.main.api.model.dto.Lotto
import com.daelim.springtest.main.api.model.dto.TestDto
import com.daelim.springtest.main.api.model.dto.TestDtoRequest
import io.swagger.v3.oas.annotations.Parameter
import jakarta.validation.Valid
import net.datafaker.Faker
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class Controller {
    private val tests = mutableListOf<TestDto>()
    private val lotto = mutableListOf<Lotto>()
    @PostMapping("/user/create")
    fun postCreateDto(
        @RequestBody testDtoRequest: TestDtoRequest
    ): ResponseEntity<TestDto> {
        val test = TestDto(
            id = testDtoRequest.id,
            email = testDtoRequest.eamil,
            password = testDtoRequest.password
        )
        tests.add(test)
        return ResponseEntity.ok().body(test)
    }

    @PostMapping("/user/login")
    fun postLoginDto(
        @RequestBody testDtoRequest: TestDtoRequest
    ): ResponseEntity<TestDto> {
        val test = TestDto(
            id = testDtoRequest.id,
            email = "",
            password = testDtoRequest.password
        )
        if (test.id == ""){
            //id와 비밀번호가 동일하지 않다면 로그인 안되게 할것
        }

        return ResponseEntity.ok().body(test)
    }

    @GetMapping("/lotto")
    fun getLottoTestDto(
    ): ResponseEntity<List<TestDto>> {

        //ㅑ
        return ResponseEntity.ok().body(tests)
    }

    @GetMapping("/test/{id}")
    fun getTestDto(
        @PathVariable("id") userId: String
    ): ResponseEntity<TestDto> {
        val response = tests.firstOrNull{it.id == userId}
        return ResponseEntity.ok().body(response)
    }
}