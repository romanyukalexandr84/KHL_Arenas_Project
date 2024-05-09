package romanyukalexandr84.KHL_Arenas_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import romanyukalexandr84.KHL_Arenas_Project.Model.Activity;

//интерфейс репозиторий услуг - для операций с таблицей активности в базе данных
public interface ActivitiesRepo extends JpaRepository<Activity, Integer> {}