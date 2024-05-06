package romanyukalexandr84.KHL_Arenas_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import romanyukalexandr84.KHL_Arenas_Project.Model.Message;

//интерфейс репозиторий - для операций с таблицей сообщения в базе данных
public interface MessagesRepo extends JpaRepository<Message, Integer> {}