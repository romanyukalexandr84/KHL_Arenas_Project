package romanyukalexandr84.KHL_Arenas_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import romanyukalexandr84.KHL_Arenas_Project.Model.City;

//интерфейс репозиторий городов - для операций с таблицей города в базе данных
public interface CitiesRepo extends JpaRepository<City, Integer> {}
