package romanyukalexandr84.KHL_Arenas_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;

//интерфейс репозиторий - для операций с таблицей арены в базе данных
public interface ArenasRepo extends JpaRepository<Arena, Integer> {

    @Query(value = "select clubs.name from clubs join arenas on arenas.club_id=clubs.id where arenas.id=:arenaId", nativeQuery = true)
    public String findClubByArenaId(Integer arenaId);

    @Query(value = "select distinct cities.name from cities join arenas on arenas.city_id=cities.id where arenas.id=:arenaId", nativeQuery = true)
    public String findCityByArenaId(Integer arenaId);

    @Query(value = "select activities.name from activities join arenas on arenas.activities_id=activities.id where arenas.id=:arenaId", nativeQuery = true)
    public String findActivityByArenaId(Integer arenaId);
}