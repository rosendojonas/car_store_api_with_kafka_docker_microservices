package com.jonasrosendo.portal.api.dto

import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonInclude
data class CarDTO(
    private var ownerId: Long? = null,
    private var ownerName: String? = null,
    private var ownerType: String? = null,
    private var model: String? = null,
    private var brand: String? = null,
    private var price: BigDecimal? = null,
    private var description: String? = null,
    private var engineVersion: String? = null,
    private var city: String? = null,
    private var createdDate: String? = null,
    private var phone: String? = null
)