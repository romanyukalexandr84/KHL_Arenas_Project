package romanyukalexandr84.KHL_Arenas_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import romanyukalexandr84.KHL_Arenas_Project.Model.Club;

//интерфейс репозиторий клубов - для операций с таблицей клубы в базе данных
public interface ClubsRepo extends JpaRepository<Club, Integer> {}