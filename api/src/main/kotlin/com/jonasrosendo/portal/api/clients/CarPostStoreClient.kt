package com.jonasrosendo.portal.api.clients

import com.jonasrosendo.portal.api.dto.CarPostDTO
import com.jonasrosendo.portal.api.dto.OwnerPostDTO
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.util.*


@Component
class CarPostStoreClient(
    private val restTemplate: RestTemplate,
) {

    private val USER_STORE_SERVICE_URI = "http://localhost:8080/user"
    private val POSTS_STORE_SERVICE_URI = "http://localhost:8080/sales"

    fun getCarForSale(): List<CarPostDTO> {
        val responseEntity = restTemplate.getForEntity(
            "$POSTS_STORE_SERVICE_URI/cars",
            Array<CarPostDTO>::class.java
        )
        return responseEntity.body?.asList() ?: emptyList()
    }

    fun createNewUser(newUser: OwnerPostDTO) {
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO::class.java)
    }

    fun updateCarForSaleClient(carPostDTO: CarPostDTO, id: Long) {
        restTemplate.put("$POSTS_STORE_SERVICE_URI/car/$id", carPostDTO, CarPostDTO::class.java)
    }

    fun deleteCarForSaleClient(id: Long) {
        restTemplate.delete("$POSTS_STORE_SERVICE_URI/car/$id")
    }
}