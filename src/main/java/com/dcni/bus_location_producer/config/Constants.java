package com.dcni.bus_location_producer.config;

/**
 * Constantes de configuración para RabbitMQ.
 * 
 * @author GRUPO10
 */
public class Constants {

    public static final String QUEUE_NAME = "bus-location-queue";
    public static final String EXCHANGE_NAME = "bus-location-exchange";
    public static final String ROUTING_KEY = "bus-location-key";

    private Constants() {
    }
}
