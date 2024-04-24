package com.daelim.springtest.main.resolver

import com.daelim.springtest.main.api.model.dto.TestDto
import graphql.kickstart.tools.GraphQLMutationResolver
import graphql.kickstart.tools.GraphQLQueryResolver
import net.datafaker.Faker
import org.springframework.stereotype.Component
import java.util.*

@Component
class PostResolver : GraphQLQueryResolver, GraphQLMutationResolver {
    private val tests = mutableListOf<TestDto>()

    val faker = Faker(Locale.KOREA)

    fun findAllTests(): List<TestDto> {
        return tests
    }

    fun findTestById(id: String): TestDto? {
        return tests.find { it.id == id }
    }
    fun findTestByEmail(email: String): TestDto? {
        return tests.find { it.email == email }
    }

    fun createTest(userId: String, userEamil : String, userPw : String): TestDto {
        val test = TestDto(
            id = userId,
            email = userEamil,
            password = userPw,
        )
        if (test.email == userEamil) {
            //findbtEmail만들어는데 안먹음
            tests.add(test)
        }
        return test
    }
}