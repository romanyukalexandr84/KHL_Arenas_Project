package romanyukalexandr84.KHL_Arenas_Project.Service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;
import romanyukalexandr84.KHL_Arenas_Project.Model.Message;
import romanyukalexandr84.KHL_Arenas_Project.Repository.ArenasRepo;
import romanyukalexandr84.KHL_Arenas_Project.Repository.MessagesRepo;
import java.util.*;

//сервис пользователя - методы бизнес-логики для пользователя
@Service
@AllArgsConstructor
public class UserService {

    //в сервис внедряем зависимости - репозитории арен и сообщений
    private final ArenasRepo arenasRepo;
    private final MessagesRepo messagesRepo;

    //Просмотр всех арен
    public List<Arena> getAllArenas() {
        return arenasRepo.findAll(Sort.by(Sort.Order.asc("id")));
    }

    //Получение арены по id
    public Arena getArenaById(Integer id) {
        if (getAllArenas().stream().filter(e -> e.getId().equals(id)).toList().getFirst() != null) {
            return arenasRepo.findById(id).orElse(null);
        } else throw new NoSuchElementException();
    }

    //Получение названия клуба по id арены
    public String getClubNameByArenaId(Integer id) {
        return arenasRepo.findClubByArenaId(id);
    }

    //Получение названия города по id арены
    public String getCityNameByArenaId(Integer id) {
        return arenasRepo.findCityByArenaId(id);
    }

    //Получение списка дополнительных услуг по id арены
    public List<String> getActivitiesByArenaId(Integer id) {
        return Arrays.asList(arenasRepo.findActivityByArenaId(id).replaceAll(", ", "/").split("/"));
    }

    //Получение арен, отсортированных по вместимости
    public List<Arena> getArenasSortedByCapacity() {
        return arenasRepo.findAll(Sort.by(Sort.Order.desc("capacity")));
    }

    //Получение арен, отсортированных по новизне
    public List<Arena> getArenasSortedByEntryYear() {
        return arenasRepo.findAll(Sort.by(Sort.Order.desc("entryYear")));
    }

    //Получение арен, отсортированных по посещаемости
    public List<Arena> getArenasSortedByAttendance() {
        return arenasRepo.findAll(Sort.by(Sort.Order.desc("attendance")));
    }

    //Получение арен, отсортированных по заполняемости
    public List<Arena> getArenasSortedByFillPercentage() {
        return arenasRepo.findAll(Sort.by(Sort.Order.desc("fillPercentage")));
    }

    //Получение арен, отсортированных по доходности
    public List<Arena> getArenasSortedByRevenue() {
        return arenasRepo.findAll(Sort.by(Sort.Order.desc("revenue")));
    }

    //Отправка сообщения в техподдержку
    public void saveMessage(Message msg) {
        messagesRepo.save(msg);
    }
}