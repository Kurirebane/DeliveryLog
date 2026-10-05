package ee.deliverylog.controller;

import ee.deliverylog.dto.RouteRequestDto;
import ee.deliverylog.entity.Route;
import ee.deliverylog.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @PostMapping
    public Route startRoute(@RequestBody RouteRequestDto request) {
        return routeService.startRoute(request);
    }
}