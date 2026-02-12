package com.dcni.bus_location_producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo que representa la ubicación de un bus.
 * 
 * @author GRUPO10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusLocation {

    private String busId;
    private Double latitude;
    private Double longitude;
    private Double velocity;
}
