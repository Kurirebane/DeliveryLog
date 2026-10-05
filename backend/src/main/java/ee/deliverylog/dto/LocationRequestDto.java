package ee.deliverylog.dto;

import jakarta.validation.constraints.NotBlank;

public class LocationRequestDto {

    @NotBlank
    private String name;

    private Long parentLocationId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentLocationId() {
        return parentLocationId;
    }

    public void setParentLocationId(Long parentLocationId) {
        this.parentLocationId = parentLocationId;
    }
}