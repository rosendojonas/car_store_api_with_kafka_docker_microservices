package com.jonasrosendo.portal.api.services

import com.jonasrosendo.portal.api.dto.OwnerPostDTO
import org.springframework.stereotype.Service

@Service
interface OwnerPostService {
    fun createOwner(ownerPostDTO: OwnerPostDTO)
}