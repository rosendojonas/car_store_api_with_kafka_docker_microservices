package com.jonasrosendo.cars.analytics.entities

import jakarta.persistence.*

@Entity
@Table(name = "brand_analytics")
data class BrandAnalyticsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var brand: String? = null,
    var posts: Long? = null
)

