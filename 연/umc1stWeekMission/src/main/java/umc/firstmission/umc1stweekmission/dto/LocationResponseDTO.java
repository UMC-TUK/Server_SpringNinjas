package umc.firstmission.umc1stweekmission.dto;

import lombok.Getter;
import umc.firstmission.umc1stweekmission.domain.Location;

@Getter
public class LocationResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String season;

    public LocationResponseDTO(Location entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.season = entity.getSeason();
    }
}
