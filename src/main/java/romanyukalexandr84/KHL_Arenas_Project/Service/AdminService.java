package romanyukalexandr84.KHL_Arenas_Project.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import romanyukalexandr84.KHL_Arenas_Project.Aspect.TrackUserAction;
import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;
import romanyukalexandr84.KHL_Arenas_Project.Model.Message;
import romanyukalexandr84.KHL_Arenas_Project.Repository.ArenasRepo;
import romanyukalexandr84.KHL_Arenas_Project.Repository.MessagesRepo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

//сервис администратора - методы бизнес-логики для администратора
@Service
@AllArgsConstructor
public class AdminService {
    //в сервис внедряем зависимости - репозитории арен и сообщений
    private final ArenasRepo arenasRepo;
    private final MessagesRepo messagesRepo;

    //Просмотр всех сообщений от пользователей
    @TrackUserAction
    public List<Message> getAllMessages() {
        return messagesRepo.findAll();
    }

    //Просмотр лога приложения
    @TrackUserAction
    public List<String> getLog() throws IOException {
        File file = new File("src/main/java/romanyukalexandr84/KHL_Arenas_Project/Log/app-log.log");
        return readFile(file);
    }

    //Метод чтения файла (для лога)
    public static List<String> readFile(File file) {
        List<String> lst = new ArrayList<>();
        try (FileReader fr = new FileReader(file); BufferedReader bf = new BufferedReader(fr)) {
            String line;
            while ((line = bf.readLine()) != null) {
                lst.add(line);
            }
        } catch (IOException e) {
            lst.add("Файл не существует");
            return lst;
        }
        return lst;
    }









    //Просмотр всех арен
    @TrackUserAction
    public List<Arena> getAllArenas() {
        return arenasRepo.findAll();
    }

    //Получение арены по id
    @TrackUserAction
    public Arena getArenaById(Integer id) {
        return arenasRepo.findById(id).orElse(null);
    }

    //Добавление арены
    @TrackUserAction
    public Arena createArena(Arena arena) {
        return arenasRepo.save(arena);
    }

    //Удаление арены
    @TrackUserAction
    public void delArena(Integer id) {
        arenasRepo.deleteById(id);
    }
}