package trip.cafe.tripcafebackend.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import trip.cafe.tripcafebackend.domain.Address;
import trip.cafe.tripcafebackend.domain.Cafe;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CafeSaveRequestDTO {

    private String name;
    private String phoneNum;
    private String zipcode;
    private String street;
    private String detail;


    public Cafe toEntity() {
        return Cafe.builder()
                .name(name)
                .phoneNum(phoneNum)
                .address(new Address(zipcode, street, detail))
                .locationFirst(street.split(" ")[0])
                .locationSecond(street.split(" ")[1])
                .locationThird(street.split(" ")[2])
                .build();
    }
}
