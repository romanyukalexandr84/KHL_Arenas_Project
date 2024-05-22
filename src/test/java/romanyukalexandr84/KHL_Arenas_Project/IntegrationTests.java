package romanyukalexandr84.KHL_Arenas_Project;

import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;
import romanyukalexandr84.KHL_Arenas_Project.Repository.ArenasRepo;
import romanyukalexandr84.KHL_Arenas_Project.Service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


//класс для интеграционных тестов, тестируем взаимодействие реального сервиса и реального репозитория
@SpringBootTest
class IntegrationTests {

    @Autowired
    private ArenasRepo realArenasRepository;

    @Autowired
    private AdminService realService;

    //тестовая арена - исключительно для тестирования
    private static Arena specialArenaForTesting;

    //блок предусловия, где создаем тестовую арену, вызываем перед каждым тестом
    @BeforeEach
    public void setTestsParameters() {
        specialArenaForTesting = new Arena();
        specialArenaForTesting.setName("Тест-арена");
        specialArenaForTesting.setClubId(5);
        specialArenaForTesting.setCityId(5);
        specialArenaForTesting.setCapacity(9000);
        specialArenaForTesting.setEntryYear(2010);
        specialArenaForTesting.setTicketsURL("https://tickets.hawk.ru/tickets");
        specialArenaForTesting.setAttendance(8000);
        specialArenaForTesting.setPrices("500-1500");
        specialArenaForTesting.setActivitiesId(5);
    }


    //тестируем, что при сохранении арены напрямую через репозиторий сервис также как
    //и ранее будет работать корректно и выдавать корректные данные
    @Test
    @WithMockUser(roles = "ADMIN")
    public void integrationTest() {

        //блок действия (вызова метода)
        realArenasRepository.add(specialArenaForTesting.getName(), specialArenaForTesting.getClubId(),
                specialArenaForTesting.getCityId(), specialArenaForTesting.getCapacity(),
                specialArenaForTesting.getEntryYear(), specialArenaForTesting.getTicketsURL(),
                specialArenaForTesting.getAttendance(), specialArenaForTesting.getPrices(),
                specialArenaForTesting.getActivitiesId());
        List<Arena> testArenas = realService.getAllArenas();

        //блок проверки действия
        assertFalse(testArenas.isEmpty());
        assertEquals(specialArenaForTesting.getName(), testArenas.getLast().getName());
    }
}