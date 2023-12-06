package org.jonasrosendo.store.car.entities

import jakarta.persistence.*

@Entity
@Table(name = "owners")
data class OwnerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val type: String,
    val phone: String,
)