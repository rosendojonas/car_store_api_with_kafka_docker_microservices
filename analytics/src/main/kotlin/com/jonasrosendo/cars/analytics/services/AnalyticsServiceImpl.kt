package com.jonasrosendo.cars.analytics.services

import com.jonasrosendo.cars.analytics.dto.CarDTO
import com.jonasrosendo.cars.analytics.entities.BrandAnalyticsEntity
import com.jonasrosendo.cars.analytics.entities.CarModelAnalyticsEntity
import com.jonasrosendo.cars.analytics.entities.CarModelPriceAnalyticsEntity
import com.jonasrosendo.cars.analytics.repositories.BrandAnalyticsRepository
import com.jonasrosendo.cars.analytics.repositories.CarModelAnalyticsRepository
import com.jonasrosendo.cars.analytics.repositories.CarModelPriceAnalyticsRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal


@Service
class AnalyticsServiceImpl(
    private val brandAnalyticsRepository: BrandAnalyticsRepository,
    private val carModelAnalyticsRepository: CarModelAnalyticsRepository,
    private val carModelPriceAnalyticsRepository: CarModelPriceAnalyticsRepository,
) : AnalyticsService {

    override fun saveAnalytics(carDTO: CarDTO) {
        saveBrandAnalytics(carDTO.brand)
        saveCarModelAnalytics(carDTO.model)
        saveCarModelPriceAnalytics(carDTO.model, carDTO.price)
    }

    private fun saveBrandAnalytics(brand: String?) {

        val brandAnalyticsEntities: List<BrandAnalyticsEntity> = brandAnalyticsRepository.findByBrand(brand)

        if (brandAnalyticsEntities.isNotEmpty()) {
            brandAnalyticsEntities.forEach {
                it.posts = it.posts?.plus(1)
                brandAnalyticsRepository.save(it)
            }
        } else {
            val brandAnalyticsEntity = BrandAnalyticsEntity(brand = brand, posts = 1L)
            brandAnalyticsRepository.save(brandAnalyticsEntity)
        }
    }

    private fun saveCarModelAnalytics(model: String?) {
        val carModelAnalyticsEntities: List<CarModelAnalyticsEntity> = carModelAnalyticsRepository.findByModel(model)

        if (carModelAnalyticsEntities.isNotEmpty()) {
            carModelAnalyticsEntities.forEach {
                it.posts = it.posts?.plus(1)
                carModelAnalyticsRepository.save(it)
            }
        } else {
            val carModelAnalyticsEntity = CarModelAnalyticsEntity(model = model, posts = 1L)
            carModelAnalyticsRepository.save(carModelAnalyticsEntity)
        }
    }

    private fun saveCarModelPriceAnalytics(carModel: String?, price: BigDecimal?) {
        val carModelPriceAnalyticsEntity = CarModelPriceAnalyticsEntity()
        carModelPriceAnalyticsEntity.model = carModel
        carModelPriceAnalyticsEntity.price = price
        carModelPriceAnalyticsRepository.save(carModelPriceAnalyticsEntity)
    }


}