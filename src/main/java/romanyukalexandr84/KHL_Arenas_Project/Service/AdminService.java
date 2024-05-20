package romanyukalexandr84.KHL_Arenas_Project.Service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;
import romanyukalexandr84.KHL_Arenas_Project.Model.Message;
import romanyukalexandr84.KHL_Arenas_Project.Repository.ArenasRepo;
import romanyukalexandr84.KHL_Arenas_Project.Repository.MessagesRepo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//сервис администратора - методы бизнес-логики для администратора
@Service
@AllArgsConstructor
public class AdminService {

    //в сервис внедряем зависимости - репозитории арен и сообщений
    private final ArenasRepo arenasRepo;
    private final MessagesRepo messagesRepo;

    //Просмотр всех сообщений от пользователей
    public List<Message> getAllMessages() {
        return messagesRepo.findAll().reversed();
    }

    //Просмотр лога приложения
    public List<String> getLog() throws IOException {
        File file = new File("src/main/java/romanyukalexandr84/KHL_Arenas_Project/Log/app-log.log");
        return readFile(file).reversed();
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
    public List<Arena> getAllArenas() {
        return arenasRepo.findAll(Sort.by(Sort.Order.asc("id")));
    }

    //Добавление арены
    public void createArena(Arena arena) {
        arenasRepo.add(arena.getName(), arena.getClubId(), arena.getCityId(), arena.getCapacity(),
                arena.getEntryYear(), arena.getTicketsURL(), arena.getAttendance(), arena.getPrices(), arena.getActivitiesId());
    }

    //Удаление арены
    public void delArena(Integer id) {
        arenasRepo.deleteById(id);
    }

    //Получение арены по id
    public Arena getArenaById(Integer id) {
        if (getAllArenas().stream().filter(e -> e.getId().equals(id)).toList().getFirst() != null) {
            return arenasRepo.findById(id).orElse(null);
        } else throw new NoSuchElementException();
    }

    //Изменение данных арены
    public void updateArena(Arena arena) {
        arenasRepo.update(arena.getId(), arena.getName(), arena.getClubId(), arena.getCityId(), arena.getCapacity(),
                arena.getEntryYear(), arena.getTicketsURL(), arena.getAttendance(), arena.getPrices(), arena.getActivitiesId());
    }
}