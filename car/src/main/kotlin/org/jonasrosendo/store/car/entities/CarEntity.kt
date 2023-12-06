package org.jonasrosendo.store.car.entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "cars")
data class CarEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val model: String,
    val brand: String,
    val price: BigDecimal,
    val description: String,
    @Column(name = "engine_version")
    val engineVersion: String,
    val city: String,
    @Column(name = "created_date")
    val createdDate: String,
    val phone: String,

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false, referencedColumnName = "id")
    val ownerEntity: OwnerEntity
)