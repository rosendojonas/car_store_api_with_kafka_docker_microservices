package com.jonasrosendo.portal.api.message

import com.jonasrosendo.portal.api.dto.CarPostDTO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component


@Component
class KafkaProducerMessage(
    private val kafkaTemplate: KafkaTemplate<String, CarPostDTO>
) {

    private val KAFKA_TOPIC = "car-post-topic"

    fun sendMessage(carPostDTO: CarPostDTO) {
        kafkaTemplate.send(KAFKA_TOPIC, carPostDTO)
    }

}
