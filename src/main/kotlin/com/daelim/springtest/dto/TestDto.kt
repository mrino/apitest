package com.daelim.springtest.main.api.model.dto

data class TestDto(
    val id: String,
    val email: String,
    val password : String
)

data class TestDtoRequest(
    val id: String,
    val eamil: String,
    val password: String
)
