package romanyukalexandr84.KHL_Arenas_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import romanyukalexandr84.KHL_Arenas_Project.Model.Arena;

//интерфейс репозиторий арен - для операций с таблицей арены в базе данных
public interface ArenasRepo extends JpaRepository<Arena, Integer> {

    //добавляем собственные методы расширяющие базовый функционал Jpa-репозитория

    @Query(value = "select clubs.name from clubs join arenas on arenas.club_id=clubs.id where arenas.id=:arenaId", nativeQuery = true)
    String findClubByArenaId(Integer arenaId);

    @Query(value = "select distinct cities.name from cities join arenas on arenas.city_id=cities.id where arenas.id=:arenaId", nativeQuery = true)
    String findCityByArenaId(Integer arenaId);

    @Query(value = "select activities.name from activities join arenas on arenas.activities_id=activities.id where arenas.id=:arenaId", nativeQuery = true)
    String findActivityByArenaId(Integer arenaId);

    @Query(value = "insert into arenas (name, club_id, city_id, capacity, entry_year, tickets_url, attendance, prices, activities_id) values (:name, :clubId, :cityId, :capacity, :entryYear, :ticketsUrl, :attendance, :prices, :activitiesId)", nativeQuery = true)
    @Modifying
    @Transactional
    void add(String name, Integer clubId, Integer cityId, Integer capacity, Integer entryYear,
             String ticketsUrl, Integer attendance, String prices, Integer activitiesId);

    @Query(value = "update arenas set name=:name, club_id =:clubId, city_id=:cityId, capacity=:capacity, entry_year=:entryYear, tickets_url=:ticketsUrl, attendance=:attendance, prices=:prices, activities_id=:activitiesId where id=:id", nativeQuery = true)
    @Modifying
    @Transactional
    void update(Integer id, String name, Integer clubId, Integer cityId, Integer capacity, Integer entryYear,
             String ticketsUrl, Integer attendance, String prices, Integer activitiesId);
}