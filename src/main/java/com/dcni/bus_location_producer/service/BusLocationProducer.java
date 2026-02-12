package com.dcni.bus_location_producer.service;

import com.dcni.bus_location_producer.config.Constants;
import com.dcni.bus_location_producer.model.BusLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * Servicio para enviar ubicaciones de buses a RabbitMQ.
 * 
 * @author GRUPO10
 */
@Service
public class BusLocationProducer {

    private static final Logger logger = LoggerFactory.getLogger(BusLocationProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public BusLocationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendBusLocation(BusLocation busLocation) {
        logger.info("Enviando mensaje a RabbitMQ: {}", busLocation);
        rabbitTemplate.convertAndSend(Constants.EXCHANGE_NAME, Constants.ROUTING_KEY, busLocation);
        logger.info("Mensaje enviado exitosamente");
    }
}
