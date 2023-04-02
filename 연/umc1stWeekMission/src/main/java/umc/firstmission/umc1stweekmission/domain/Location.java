package umc.firstmission.umc1stweekmission.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    private String name;
    private String address;
    private String season;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "recommend_id")
    private Recommend recommend;

    @Builder
    public Location(Long id, String name, String address, String season, Recommend recommend) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.season = season;
        this.recommend = recommend;
    }
}
