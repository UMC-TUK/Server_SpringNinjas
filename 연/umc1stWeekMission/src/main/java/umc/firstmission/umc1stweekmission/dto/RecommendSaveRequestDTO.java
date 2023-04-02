package umc.firstmission.umc1stweekmission.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.firstmission.umc1stweekmission.domain.Location;
import umc.firstmission.umc1stweekmission.domain.Recommend;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RecommendSaveRequestDTO {

    private String name;
    private String date;

    public Recommend toEntity() {
        return Recommend.builder()
                .name(name)
                .date(date)
                .build();
    }
}
