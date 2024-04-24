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
    val lotto = mutableListOf<Lotto>()
    val Num = mutableListOf<Int>()
    private var count = 0;

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
        var rd = Random();
        var b = 1;
        //lotto 6자리 추가
        while (b == 7){
            var a =rd.nextInt(45)
            //랜덤한 6숫자
            //TestDto에서 만든 lotto에 값넣고 체크하기
            if (a == a){
               //체크했으면 랜덤한 숫자 부여
                //회차별로 count증가
            }
        }
        return ResponseEntity.ok().body(tests)
    }
    @PostMapping("/lotto")
    fun postlottoDto(
        @RequestBody testDtoRequest: TestDtoRequest
    ): ResponseEntity<MutableList<Int>> {
        var rd = Random();
        var b = 1;
        //lotto 6자리 추가
        while (b == 7){
            var a =rd.nextInt(45)
            //랜덤한 6숫자
            //TestDto에서 만든 lotto에 값넣고 체크하기
            if (a == a){
                //체크했으면 랜덤한 숫자 부여
            }
        }
        return ResponseEntity.ok().body(null)
    }

    @PostMapping("/lotto/check")
    fun postlottcheckoDto(
        @RequestBody testDtoRequest: TestDtoRequest
    ): ResponseEntity<MutableList<Int>> {
        //가지고 온 숫자 비교해서 체크하기
        //회차별로 체크하기
        return ResponseEntity.ok().body(null)
    }
}


