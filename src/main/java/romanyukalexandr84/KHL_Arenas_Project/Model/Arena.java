package romanyukalexandr84.KHL_Arenas_Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//класс арена - модель
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "arenas")
public class Arena {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "club_id", nullable = false)
    private Integer clubId;

    @Column(name = "city_id", nullable = false)
    private Integer cityId;

    @Column(nullable = false)
    private Integer capacity;

    @Column(name = "entry_year", nullable = false)
    private Integer entryYear;

    @Column(name = "gallery_url", nullable = false)
    private String galleryURL;

    @Column(name = "tickets_url", nullable = false)
    private String ticketsURL;

    @Column(nullable = false)
    private Integer attendance;

    @Column(name = "fill_percentage", nullable = false)
    private Integer fillPercentage;

    @Column(nullable = false)
    private String prices;

    @Column(nullable = false)
    private Integer revenue;

    @Column(name = "activities_id", nullable = false)
    private Integer activitiesId;
}