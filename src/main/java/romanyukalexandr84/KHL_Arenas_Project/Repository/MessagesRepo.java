package romanyukalexandr84.KHL_Arenas_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import romanyukalexandr84.KHL_Arenas_Project.Model.Message;

public interface MessagesRepo extends JpaRepository<Message, Integer> {}