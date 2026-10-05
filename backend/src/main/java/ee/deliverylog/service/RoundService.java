package ee.deliverylog.service;

import ee.deliverylog.entity.Round;
import ee.deliverylog.entity.RoundType;
import ee.deliverylog.repository.RoundRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoundService {

    private final RoundRepository roundRepository;

    public RoundService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    public List<Round> getAllRounds() {
        return roundRepository.findAll();
    }

    public Round startRound(RoundType type) {
        Round round = new Round();

        round.setType(type);
        round.setStartedAt(LocalDateTime.now());

        return roundRepository.save(round);
    }

    public Round finishRound(Long id) {

        Round round = roundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Round not found"));

        if (round.getFinishedAt() != null) {
            throw new RuntimeException("Round is already finished");
        }

        round.setFinishedAt(LocalDateTime.now());


        return roundRepository.save(round);
    }

}