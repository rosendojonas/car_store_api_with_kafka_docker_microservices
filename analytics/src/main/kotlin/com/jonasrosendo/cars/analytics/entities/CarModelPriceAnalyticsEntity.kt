package com.jonasrosendo.cars.analytics.entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "car_model_price")
data class CarModelPriceAnalyticsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var model: String? = null,
    var price: BigDecimal? = null
)

