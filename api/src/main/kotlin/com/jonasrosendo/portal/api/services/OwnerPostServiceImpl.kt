package com.jonasrosendo.portal.api.services

import com.jonasrosendo.portal.api.clients.CarPostStoreClient
import com.jonasrosendo.portal.api.dto.OwnerDTO
import org.springframework.stereotype.Service

@Service
class OwnerPostServiceImpl(
    private val carPostStoreClient: CarPostStoreClient
) : OwnerPostService{
    override fun createOwner(ownerDTO: OwnerDTO) {
        carPostStoreClient.createNewUser(ownerDTO)
    }
}