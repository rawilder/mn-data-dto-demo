package dev.awilder
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull

@MicronautTest
class MnDataDtoDemoTest(
    private val application: EmbeddedApplication<*>,
    private val testEntityRepo: TestEntityRepo
): StringSpec({

    "test the server is running" {
        assert(application.isRunning)
    }

    "test repository dto projection regular method" {
        testEntityRepo.save(
            TestEntity(
                name = "test"
            )
        )
        testEntityRepo.findByName("test")?.id.shouldNotBeNull()
    }

    "test repository dto projection queried method" {
        testEntityRepo.save(
            TestEntity(
                name = "test"
            )
        )
        testEntityRepo.findByNameQueried("test")?.id.shouldNotBeNull()
    }
})
