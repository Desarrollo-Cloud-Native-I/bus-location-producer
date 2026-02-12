package com.dcni.bus_location_producer.controller;

import com.dcni.bus_location_producer.model.BusLocation;
import com.dcni.bus_location_producer.service.BusLocationProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para recibir y publicar ubicaciones de buses.
 * 
 * @author GRUPO10
 */
@RestController
@RequestMapping("/api/bus-location")
public class BusLocationController {

    private final BusLocationProducer busLocationProducer;

    public BusLocationController(BusLocationProducer busLocationProducer) {
        this.busLocationProducer = busLocationProducer;
    }

    @PostMapping
    public ResponseEntity<String> sendBusLocation(@RequestBody BusLocation busLocation) {
        try {
            busLocationProducer.sendBusLocation(busLocation);
            return ResponseEntity.ok("Mensaje enviado a RabbitMQ exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al enviar mensaje: " + e.getMessage());
        }
    }
}
