package org.jonasrosendo.store.car.dto

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class CarDTO(
    var id: Long? = null,
    @JsonAlias("owner_id")
    var ownerId: Long,
    @JsonAlias("owner_name")
    var ownerName: String? = null,
    @JsonAlias("owner_type")
    var ownerType: String? = null,
    var model: String? = null,
    var brand: String? = null,
    var price: BigDecimal? = null,
    var description: String? = null,
    @JsonAlias("engine_version")
    var engineVersion: String? = null,
    var city: String? = null,
    @JsonAlias("created_date")
    var createdDate: String? = null,
    var phone: String? = null,
)