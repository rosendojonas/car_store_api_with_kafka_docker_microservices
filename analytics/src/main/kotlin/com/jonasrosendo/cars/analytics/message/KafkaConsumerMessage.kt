package com.jonasrosendo.cars.analytics.message

import com.jonasrosendo.cars.analytics.dto.CarDTO
import com.jonasrosendo.cars.analytics.services.AnalyticsService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component


@Component
class KafkaConsumerMessage(
    private val service: AnalyticsService
) {

    private val LOG: Logger = LoggerFactory.getLogger(KafkaConsumerMessage::class.java)

    @KafkaListener(topics = ["car-post-topic"], groupId = "analytics-posts-group")
    fun listening(@Payload carDTO: CarDTO) {
        LOG.info("CAR STORE - Received Car Post information: {}", carDTO)
        service.saveAnalytics(carDTO)
    }
}
