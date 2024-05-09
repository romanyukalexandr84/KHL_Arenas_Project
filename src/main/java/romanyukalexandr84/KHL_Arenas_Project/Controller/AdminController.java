package romanyukalexandr84.KHL_Arenas_Project.Controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;
import romanyukalexandr84.KHL_Arenas_Project.Service.AdminService;
import java.io.IOException;

//класс контролер администратора - обрабатывает входящие запросы на сервер от админа
@org.springframework.stereotype.Controller
@AllArgsConstructor
public class AdminController {

    //в контролер внедряем зависимость - сервис администратора
    private final AdminService adminService;

    //отдаем страницу администратора
    @GetMapping("/admin-profile")
    public String getViewAsAdmin() {
        return "admin-profile";
    }

    //отдаем страницу с сообщениями от пользователей
    @GetMapping("/admin-profile/allmessages")
    public String getMessagesPage(Model model) {
        model.addAttribute("messages", adminService.getAllMessages());
        return "allmessages";
    }

    //отдаем страницу с логом приложения
    @GetMapping("/admin-profile/logpage")
    public String getLog(Model model) throws IOException {
        model.addAttribute("log", adminService.getLog());
        return "logpage";
    }

    //отдаем страницу для добавления новой арены
    @GetMapping("/admin-profile/adding")
    public String addArena(Model model) {
        model.addAttribute("arenas", adminService.getAllArenas());
        return "adding";
    }

    //отдаем обновленную страницу после добавления новой арены
    @PostMapping("/admin-profile/adding")
    public String createArena(Arena arena) {
        adminService.createArena(arena);
        return "redirect:/admin-profile/adding";
    }

    //отдаем страницу для удаления арены
    @GetMapping("/admin-profile/deleting")
    public String delArena(Model model) {
        model.addAttribute("arenas", adminService.getAllArenas());
        return "deleting";
    }

    //отдаем обновленную страницу после удаления арены
    @PostMapping("/admin-profile/deleting")
    public String dropArena(Integer arenaId) {
        adminService.delArena(arenaId);
        return "redirect:/admin-profile/deleting";
    }

    //отдаем страницу для изменения данных
    @GetMapping("/admin-profile/changing")
    public String changeArena(Model model) {
        model.addAttribute("arenas", adminService.getAllArenas());
        return "changing";
    }

    //отдаем страницу с конкретной ареной для изменения
    @GetMapping("/admin-profile/changing/{arenaId}")
    public String updateArena(Model model, @PathVariable Integer arenaId) {
        model.addAttribute("arena", adminService.getArenaById(arenaId));
        return "updating";
    }

    //отдаем страницу после изменения данных
    @PostMapping("/admin-profile/changing")
    public String setNewDataOfArena(Arena arena) {
        adminService.updateArena(arena);
        return "redirect:/admin-profile/changing";
    }
}