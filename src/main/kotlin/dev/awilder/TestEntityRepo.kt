package dev.awilder

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import javax.persistence.Entity
import javax.persistence.Id

@Repository
interface TestEntityRepo : CrudRepository<TestEntity, Long> {

    fun findByName(name: String): TestEntity?

    // cannot duplicate method name
//    fun findByName(name: String): TestEntityDto?

    // this can't be implemented
//    fun findSubsetDtoById(id: Long): TestEntityDto

    // this fails, see MnDataDtoDemoTest -> "test repository dto"
    @Query("FROM TestEntity t WHERE t.name = :name")
    fun findByNameQueried(name: String): TestEntityDto?
}
