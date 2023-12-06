package com.jonasrosendo.cars.analytics.repositories

import com.jonasrosendo.cars.analytics.entities.BrandAnalyticsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BrandAnalyticsRepository : JpaRepository<BrandAnalyticsEntity, Long> {
    fun findByBrand(brand: String?): List<BrandAnalyticsEntity>
}