package org.jonasrosendo.store.car.message

import org.jonasrosendo.store.car.dto.CarDTO
import org.jonasrosendo.store.car.services.CarService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Component
class KafkaConsumerMessage(
    private val carPostService: CarService
) {

    private val LOG: Logger = LoggerFactory.getLogger(KafkaConsumerMessage::class.java)

    @KafkaListener(topics = ["car-post-topic"], groupId = "store-posts-group")
    fun listening(carDTO: CarDTO) {
        LOG.info("CAR STORE - Received Car Post information: {}", carDTO)
        carPostService.createNewCar(carDTO)
    }
}
