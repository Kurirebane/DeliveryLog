package ee.deliverylog.service;

import ee.deliverylog.dto.DeliveryStopRequestDto;
import ee.deliverylog.entity.DeliveryStop;
import ee.deliverylog.entity.Location;
import ee.deliverylog.entity.Route;
import ee.deliverylog.repository.DeliveryStopRepository;
import ee.deliverylog.repository.LocationRepository;
import ee.deliverylog.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeliveryStopService {

    private final DeliveryStopRepository deliveryStopRepository;
    private final RouteRepository routeRepository;
    private final LocationRepository locationRepository;

    public DeliveryStopService(
            DeliveryStopRepository deliveryStopRepository,
            RouteRepository routeRepository,
            LocationRepository locationRepository) {

        this.deliveryStopRepository = deliveryStopRepository;
        this.routeRepository = routeRepository;
        this.locationRepository = locationRepository;
    }

    public List<DeliveryStop> getAllDeliveryStops() {
        return deliveryStopRepository.findAll();
    }

    public DeliveryStop confirmStop(DeliveryStopRequestDto request) {

        Route route = routeRepository.findById(request.getRouteId())
                .orElseThrow(() -> new RuntimeException("Route not found"));

        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found"));

        DeliveryStop deliveryStop = new DeliveryStop();

        deliveryStop.setRoute(route);
        deliveryStop.setLocation(location);
        deliveryStop.setConfirmedAt(LocalDateTime.now());

        return deliveryStopRepository.save(deliveryStop);
    }
}