package umc.firstmission.umc1stweekmission.dto;

import lombok.Getter;
import umc.firstmission.umc1stweekmission.domain.Recommend;

import javax.xml.stream.Location;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class RecommendResponseDTO {

    private Long id;
    private String name;
    private String date;

    public RecommendResponseDTO(Recommend entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.date = entity.getDate();
    }
}
