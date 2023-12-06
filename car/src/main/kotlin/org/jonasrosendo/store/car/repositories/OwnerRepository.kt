package org.jonasrosendo.store.car.repositories

import org.jonasrosendo.store.car.entities.OwnerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OwnerRepository : JpaRepository<OwnerEntity, Long>