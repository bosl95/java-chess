package dto;

import domain.piece.Color;
import domain.score.Score;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StatusDto implements MenuDto {
    Map<String, Double> result = new HashMap<>();
    private double blackScore;
    private double whiteScore;

    public StatusDto(Map<Boolean, Score> pieces) {
        for (Boolean color : pieces.keySet()) {
            result.put(Color.findColorName(color), pieces.get(color).getValue());
        }
    }

    public StatusDto(double blackScore, double whiteScore) {
        this.blackScore = blackScore;
        this.whiteScore = whiteScore;
    }

    public double getBlackScore() {
        return blackScore;
    }

    public double getWhiteScore() {
        return whiteScore;
    }

    public Map<String, Double> getStatusResult() {
        return Collections.unmodifiableMap(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusDto statusDto = (StatusDto) o;
        return Objects.equals(result, statusDto.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public boolean isBoardDto() {
        return false;
    }
}
