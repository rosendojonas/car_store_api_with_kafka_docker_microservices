package com.jonasrosendo.portal.api.message

import com.jonasrosendo.portal.api.dto.CarDTO
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer
import org.springframework.stereotype.Component


@Component
@Configuration
class KafkaProducerConfig {

    @Value("\${spring.kafka.bootstrap-servers}")
    private lateinit var bootstrapServer: String

    @Bean
    fun userProducerFactory(): ProducerFactory<String, CarDTO> {
        val configProps: MutableMap<String, Any> = HashMap()
        configProps[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
        configProps[JsonSerializer.ADD_TYPE_INFO_HEADERS] = false
        configProps[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
        configProps[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java.name

        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun userKafkaTemplate(): KafkaTemplate<String, CarDTO> {
        return KafkaTemplate(userProducerFactory())
    }


}