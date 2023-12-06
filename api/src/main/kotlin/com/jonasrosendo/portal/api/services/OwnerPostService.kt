package com.jonasrosendo.portal.api.services

import com.jonasrosendo.portal.api.dto.OwnerDTO
import org.springframework.stereotype.Service

@Service
interface OwnerPostService {
    fun createOwner(ownerDTO: OwnerDTO)
}