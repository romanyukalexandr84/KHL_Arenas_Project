package romanyukalexandr84.KHL_Arenas_Project.Service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import romanyukalexandr84.KHL_Arenas_Project.Aspect.TrackUserAction;
import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;
import romanyukalexandr84.KHL_Arenas_Project.Repository.ArenasRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//сервис пользователя - методы бизнес-логики для пользователя
@Service
@AllArgsConstructor
public class UserService {
    private final ArenasRepo arenasRepo;

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



}