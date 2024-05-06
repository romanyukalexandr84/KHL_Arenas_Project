package romanyukalexandr84.KHL_Arenas_Project.Service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import romanyukalexandr84.KHL_Arenas_Project.Aspect.TrackUserAction;
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
    @TrackUserAction
    public List<Arena> getAllArenas() {
        return arenasRepo.findAll();
    }

    //Получение арены по id
    @TrackUserAction
    public Arena getArenaById(Integer id) {
        return arenasRepo.findById(id).orElse(null);
    }

    //Получение названия клуба по id арены
    @TrackUserAction
    public String getClubNameByArenaId(Integer id) {
        return arenasRepo.findClubByArenaId(id);
    }

    //Получение названия города по id арены
    @TrackUserAction
    public String getCityNameByArenaId(Integer id) {
        return arenasRepo.findCityByArenaId(id);
    }

    //Получение списка дополнительных услуг по id арены
    @TrackUserAction
    public List<String> getActivitiesByArenaId(Integer id) {
        return Arrays.asList(arenasRepo.findActivityByArenaId(id).replaceAll(", ", "/").split("/"));
    }

    //Получение арен, отсортированных по вместимости
    @TrackUserAction
    public List<Arena> getArenasSortedByCapacity() {
        return arenasRepo.findAll(Sort.by(Sort.Order.desc("capacity")));
    }

    //Получение арен, отсортированных по новизне
    @TrackUserAction
    public List<Arena> getArenasSortedByEntryYear() {
        return arenasRepo.findAll(Sort.by(Sort.Order.desc("entryYear")));
    }

    //Получение арен, отсортированных по посещаемости
    @TrackUserAction
    public List<Arena> getArenasSortedByAttendance() {
        return arenasRepo.findAll(Sort.by(Sort.Order.desc("attendance")));
    }

    //Получение арен, отсортированных по заполняемости
    @TrackUserAction
    public List<Arena> getArenasSortedByFillPercentage() {
        return arenasRepo.findAll(Sort.by(Sort.Order.desc("fillPercentage")));
    }

    //Получение арен, отсортированных по доходности
    @TrackUserAction
    public List<Arena> getArenasSortedByRevenue() {
        return arenasRepo.findAll(Sort.by(Sort.Order.desc("revenue")));
    }

    //Отправка сообщения в техподдержку
    @TrackUserAction
    public void saveMessage(Message msg) {
        messagesRepo.save(msg);
    }

}