package com.jonasrosendo.portal.api.message

import com.jonasrosendo.portal.api.dto.CarDTO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component


@Component
class KafkaProducerMessage(
    private val kafkaTemplate: KafkaTemplate<String, CarDTO>
) {

    private val KAFKA_TOPIC = "car-post-topic"

    fun sendMessage(carDTO: CarDTO) {
        kafkaTemplate.send(KAFKA_TOPIC, carDTO)
    }

}
