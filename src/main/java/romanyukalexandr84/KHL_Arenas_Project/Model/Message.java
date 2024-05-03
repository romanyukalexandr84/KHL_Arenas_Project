package romanyukalexandr84.KHL_Arenas_Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//класс сообщение - модель
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "from_user", nullable = false)
    private String fromUser;

    @Column(nullable = false)
    private String body;
}