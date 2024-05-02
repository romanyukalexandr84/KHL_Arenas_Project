package romanyukalexandr84.KHL_Arenas_Project.Controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import romanyukalexandr84.KHL_Arenas_Project.Service.UserService;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class UserController {
    //в контролер внедряем зависимость - сервис пользователя
    private final UserService userService;

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
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "user-profile";
    }

    //отдаем карточку арены по id
    @GetMapping("/arena/{id}")
    public String getSingleArena(Model model, @PathVariable Integer id) {
        model.addAttribute("arena", userService.getArenaById(id));
        model.addAttribute("club", userService.getClubNameByArenaId(id));
        model.addAttribute("city", userService.getCityNameByArenaId(id));
        model.addAttribute("activities", userService.getActivitiesByArenaId(id));
        return "arena";
    }

    //отдаем галерею арены по id
    @GetMapping("/arena/{id}/gallery")
    public String getArenaGallery(Model model, @PathVariable Integer id) {
        model.addAttribute("arena", userService.getArenaById(id));
        return "gallery";
    }

    //отдаем страницу пользователя c отсортированными по вместимости аренами
    @GetMapping("/user-profile/sortedbycapacity")
    public String getViewAsCommonUserSortedByCapacity(Model model) {
        model.addAttribute("arenas", userService.getArenasSortedByCapacity());
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("sortingrule", "capacity");
        return "user-profile";
    }

    //отдаем страницу пользователя c отсортированными по новизне аренами
    @GetMapping("/user-profile/sortedbyentryyear")
    public String getViewAsCommonUserSortedByEntryYear(Model model) {
        model.addAttribute("arenas", userService.getArenasSortedByEntryYear());
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("sortingrule", "entryyear");
        return "user-profile";
    }

    //отдаем страницу пользователя c отсортированными по посещаемости аренами
    @GetMapping("/user-profile/sortedbyattendance")
    public String getViewAsCommonUserSortedByAttendance(Model model) {
        model.addAttribute("arenas", userService.getArenasSortedByAttendance());
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("sortingrule", "attendance");
        return "user-profile";
    }

    //отдаем страницу пользователя c отсортированными по заполняемости аренами
    @GetMapping("/user-profile/sortedbyfillpercentage")
    public String getViewAsCommonUserSortedByFillPercentage(Model model) {
        model.addAttribute("arenas", userService.getArenasSortedByFillPercentage());
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("sortingrule", "fillpercentage");
        return "user-profile";
    }

    //отдаем страницу пользователя c отсортированными по доходности аренами
    @GetMapping("/user-profile/sortedbyrevenue")
    public String getViewAsCommonUserSortedByRevenue(Model model) {
        model.addAttribute("arenas", userService.getArenasSortedByRevenue());
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("sortingrule", "revenue");
        return "user-profile";
    }


}