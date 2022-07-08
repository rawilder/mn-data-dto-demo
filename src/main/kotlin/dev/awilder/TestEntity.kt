package dev.awilder

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class TestEntity(
    @Id
    var id: Long = 0,
    var name: String
)
