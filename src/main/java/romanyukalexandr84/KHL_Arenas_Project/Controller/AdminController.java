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
    public String getViewAsAdmin(Model model) {
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









    //отдаем обновленную страницу администратора после удаления арены
    @GetMapping("arena-del/{id}")
    public String delArena(@PathVariable("id") Integer id) {
        adminService.delArena(id);
        return "redirect:/admin-profile";
    }

}