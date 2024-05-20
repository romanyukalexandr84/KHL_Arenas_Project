package romanyukalexandr84.KHL_Arenas_Project;

import org.junit.jupiter.api.Test;
import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;
import romanyukalexandr84.KHL_Arenas_Project.Repository.ArenasRepo;
import romanyukalexandr84.KHL_Arenas_Project.Repository.MessagesRepo;
import romanyukalexandr84.KHL_Arenas_Project.Service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


//класс для юнит-тестов методов сервиса, тестируем реальный сервис в который внедряем моки репозиториев
@ExtendWith(MockitoExtension.class)
class UnitTests {

    @InjectMocks
    private AdminService realService;

    @Mock
    private ArenasRepo virtualArenasRepository;

    @Mock
    private MessagesRepo virtualMessagesRepository;

    //тестовая арена - исключительно для тестирования
    private static Arena specialArenaForTesting;


    //блок предусловия, где создаем тестовую арену, вызываем перед тестом
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


    //тестируем, что при вызове метода сервиса репозиторий действительно сохранит тестовую арену
    @Test
    public void savingTest() {
        //блок действия (вызова метода)
        realService.createArena(specialArenaForTesting);

        //блок проверки действия
        verify(virtualArenasRepository).add(specialArenaForTesting.getName(), specialArenaForTesting.getClubId(),
                specialArenaForTesting.getCityId(), specialArenaForTesting.getCapacity(),
                specialArenaForTesting.getEntryYear(), specialArenaForTesting.getTicketsURL(),
                specialArenaForTesting.getAttendance(), specialArenaForTesting.getPrices(),
                specialArenaForTesting.getActivitiesId());
    }


    //тестируем, что при попытке получить несуществующую арену через метод сервиса
    //выполнение кода никогда не дойдет до репозитория, а будет брошено исключение
    @Test
    public void unrealArenaTest() {
        //блок действия (вызова метода)
        assertThrows(NoSuchElementException.class, () -> {
            realService.getArenaById(specialArenaForTesting.getId());
        });

        //блок проверки действия
        verify(virtualArenasRepository, never()).findById(anyInt());
    }


    //тестируем, что получим одинаковое количество сообщений при обращении
    //к моку репозитория и к реальному сервису
    @Test
    public void checkSizeTest() {
        //блок предусловия
        List<String> testMessages = new ArrayList<>();

        //блок действия (вызова метода)
        virtualMessagesRepository.findAll().forEach(elem -> testMessages.add(String.valueOf(elem)));

        //блок проверки действия
        assertEquals(realService.getAllMessages().size(), testMessages.size());
    }
}