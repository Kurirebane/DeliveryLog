package ee.deliverylog.controller;

import ee.deliverylog.entity.Round;
import ee.deliverylog.entity.RoundType;
import ee.deliverylog.service.RoundService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rounds")
public class RoundController {

    private final RoundService roundService;

    public RoundController(RoundService roundService) {
        this.roundService = roundService;
    }

    @GetMapping
    public List<Round> getAllRounds() {
        return roundService.getAllRounds();
    }

    @PostMapping
    public Round startRound(@RequestParam RoundType type) {
        return roundService.startRound(type);
    }

    @PutMapping("/{id}/finish")
    public Round finishRound(@PathVariable Long id) {
        return roundService.finishRound(id);
    }
}