package romanyukalexandr84.KHL_Arenas_Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//класс активности - модель
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activities")
public class Activity {
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;
}