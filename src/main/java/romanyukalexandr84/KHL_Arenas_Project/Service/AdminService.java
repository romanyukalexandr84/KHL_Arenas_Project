package romanyukalexandr84.KHL_Arenas_Project.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import romanyukalexandr84.KHL_Arenas_Project.Aspect.TrackUserAction;
import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;
import romanyukalexandr84.KHL_Arenas_Project.Repository.ArenasRepo;

import java.util.List;

//сервис администратора - методы бизнес-логики для администратора
@Service
@AllArgsConstructor
public class AdminService {
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