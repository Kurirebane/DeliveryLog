package ee.deliverylog.service;

import ee.deliverylog.dto.RouteRequestDto;
import ee.deliverylog.entity.Location;
import ee.deliverylog.entity.Round;
import ee.deliverylog.entity.Route;
import ee.deliverylog.repository.LocationRepository;
import ee.deliverylog.repository.RoundRepository;
import ee.deliverylog.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final RoundRepository roundRepository;
    private final LocationRepository locationRepository;

    public RouteService(
            RouteRepository routeRepository,
            RoundRepository roundRepository,
            LocationRepository locationRepository) {

        this.routeRepository = routeRepository;
        this.roundRepository = roundRepository;
        this.locationRepository = locationRepository;
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Route startRoute(RouteRequestDto request) {

        Round round = roundRepository.findById(request.getRoundId())
                .orElseThrow(() -> new RuntimeException("Round not found"));

        Location pickupLocation = locationRepository
                .findById(request.getPickupLocationId())
                .orElseThrow(() -> new RuntimeException("Pickup location not found"));

        Route route = new Route();
        route.setRound(round);
        route.setPickupLocation(pickupLocation);
        route.setStartedAt(LocalDateTime.now());

        return routeRepository.save(route);
    }
}