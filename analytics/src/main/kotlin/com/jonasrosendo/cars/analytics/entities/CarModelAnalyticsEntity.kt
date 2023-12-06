package com.jonasrosendo.cars.analytics.entities

import jakarta.persistence.*

@Entity
@Table(name = "car_model_analytics")
data class CarModelAnalyticsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var model: String? = null,
    var posts: Long? = null
)


