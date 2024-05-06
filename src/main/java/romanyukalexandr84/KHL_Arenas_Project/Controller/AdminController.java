package romanyukalexandr84.KHL_Arenas_Project.Controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;
import romanyukalexandr84.KHL_Arenas_Project.Service.AdminService;

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







    //отдаем обновленную страницу администратора после добавления новой арены
    @PostMapping("/admin-profile")
    public String addArena(Arena arena, Model model) {
        adminService.createArena(arena);
        model.addAttribute("arenas", adminService.getAllArenas());
        return "redirect:/admin-profile";
    }

    //отдаем обновленную страницу администратора после удаления арены
    @GetMapping("arena-del/{id}")
    public String delArena(@PathVariable("id") Integer id) {
        adminService.delArena(id);
        return "redirect:/admin-profile";
    }

}