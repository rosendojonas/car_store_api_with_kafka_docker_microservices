package org.jonasrosendo.store.car.dto

import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonInclude
data class CarDTO(
    var id: Long? = null,
    var ownerId: Long,
    var ownerName: String? = null,
    var ownerType: String? = null,
    var model: String? = null,
    var brand: String? = null,
    var price: BigDecimal,
    var description: String? = null,
    var engineVersion: String? = null,
    var city: String? = null,
    var createdDate: String,
    var phone: String? = null
)