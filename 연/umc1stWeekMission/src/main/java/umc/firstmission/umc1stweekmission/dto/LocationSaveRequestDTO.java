package umc.firstmission.umc1stweekmission.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.firstmission.umc1stweekmission.domain.Location;
import umc.firstmission.umc1stweekmission.domain.Recommend;
import umc.firstmission.umc1stweekmission.repository.LocationRepository;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LocationSaveRequestDTO {
    private LocationRepository locationRepository;

    private String name;  //이름
    private String address;  //주소
    private String season;  //성수기

    //Recommend id
    private Recommend recommend;
    public void setRecommend(Recommend recommend) {
        this.recommend = recommend;
    }


    public Location toEntity() {
        return Location.builder()
                .name(name)
                .address(address)
                .season(season)
                .recommend(recommend)
                .build();
    }

}
