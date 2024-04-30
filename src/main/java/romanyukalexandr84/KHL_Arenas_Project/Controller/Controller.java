package romanyukalexandr84.KHL_Arenas_Project.Controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;
import romanyukalexandr84.KHL_Arenas_Project.Service.AdminService;
import romanyukalexandr84.KHL_Arenas_Project.Service.UserService;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {
    //в контролер внедряем зависимости - сервисы пользователя и администратора
    private final UserService userService;
    private final AdminService adminService;

    //по умолчанию отдаем приветственную страницу
    @GetMapping("/")
    public String getViewAsGuest() {
        return "welcome";
    }

    //отдаем страницу авторизации
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //отдаем страницу пользователя
    @GetMapping("/user-profile")
    public String getViewAsCommonUser(Model model) {
        model.addAttribute("arenas", userService.getAllArenas());
        return "user-profile";
    }

    //отдаем страницу администратора
    @GetMapping("/admin-profile")
    public String getViewAsAdmin(Model model) {
        model.addAttribute("books", adminService.getAllArenas());
        return "admin-profile";
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