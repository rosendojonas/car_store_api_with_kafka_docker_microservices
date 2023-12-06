package com.jonasrosendo.portal.api.clients

import com.jonasrosendo.portal.api.dto.CarDTO
import com.jonasrosendo.portal.api.dto.OwnerDTO
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.util.*


@Component
class CarPostStoreClient(
    private val restTemplate: RestTemplate,
) {

    private val OWNERS_STORE_SERVICE_URI = "http://localhost:8080/owners"
    private val POSTS_STORE_SERVICE_URI = "http://localhost:8080/sales"

    fun getCarForSale(): List<CarDTO> {
        val responseEntity = restTemplate.getForEntity(
            "$POSTS_STORE_SERVICE_URI/cars",
            Array<CarDTO>::class.java
        )
        return responseEntity.body?.asList() ?: emptyList()
    }

    fun createNewUser(newUser: OwnerDTO) {
        restTemplate.postForEntity(OWNERS_STORE_SERVICE_URI, newUser, OwnerDTO::class.java)
    }

    fun updateCarForSaleClient(carDTO: CarDTO, id: Long) {
        restTemplate.put("$POSTS_STORE_SERVICE_URI/car/$id", carDTO, CarDTO::class.java)
    }

    fun deleteCarForSaleClient(id: Long) {
        restTemplate.delete("$POSTS_STORE_SERVICE_URI/car/$id")
    }
}