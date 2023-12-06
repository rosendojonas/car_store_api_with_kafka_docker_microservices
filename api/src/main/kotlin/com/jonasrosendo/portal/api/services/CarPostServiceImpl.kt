package com.jonasrosendo.portal.api.services

import com.jonasrosendo.portal.api.clients.CarPostStoreClient
import com.jonasrosendo.portal.api.dto.CarPostDTO
import org.springframework.stereotype.Service

@Service
class CarPostServiceImpl(
    private val carPostStoreClient: CarPostStoreClient
) : CarPostService {

    override fun findCarsForSale(): List<CarPostDTO> {
        return carPostStoreClient.getCarForSale()
    }

    override fun changeCarForSale(id: Long, carPostDTO: CarPostDTO) {
        carPostStoreClient.updateCarForSaleClient(carPostDTO, id)
    }

    override fun removeCarForSale(id: Long) {
        carPostStoreClient.deleteCarForSaleClient(id)
    }
}