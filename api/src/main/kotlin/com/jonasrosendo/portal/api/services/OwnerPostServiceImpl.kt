package com.jonasrosendo.portal.api.services

import com.jonasrosendo.portal.api.clients.CarPostStoreClient
import com.jonasrosendo.portal.api.dto.OwnerPostDTO
import org.springframework.stereotype.Service

@Service
class OwnerPostServiceImpl(
    private val carPostStoreClient: CarPostStoreClient
) : OwnerPostService{
    override fun createOwner(ownerPostDTO: OwnerPostDTO) {
        carPostStoreClient.createNewUser(ownerPostDTO)
    }
}