package umc.firstmission.umc1stweekmission.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "recommend")
@NoArgsConstructor
@Entity
public class Recommend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recommend_id")
    private Long id;

    private String name;  //회원 이름
    private String date;  //출발 날짜

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Location> locations = new ArrayList<>();

    @Builder
    public Recommend(Long id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }
}
