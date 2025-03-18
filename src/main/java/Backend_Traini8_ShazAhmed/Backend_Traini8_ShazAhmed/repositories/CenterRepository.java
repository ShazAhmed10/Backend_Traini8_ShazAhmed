package Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.repositories;

import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.models.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CenterRepository extends JpaRepository<Center,Long> {
    //method to find a Center by its name
    @Query(value = "SELECT * FROM center AS c WHERE c.center_name = :name LIMIT 1", nativeQuery = true)
    public Optional<Center> findByCenterName(@Param("name") String name);

    //method to find all Centers in the DB
    //or to find those Centers that match the filter parameters
    @Query(value = "SELECT DISTINCT c.* FROM center AS c " +
            "INNER JOIN center_courses_offered AS cc ON c.id = cc.center_id " +
            "INNER JOIN course AS co ON cc.courses_offered_id = co.id " +
            "INNER JOIN address AS a ON c.address_id = a.id " +
            "WHERE (:name IS NULL OR c.center_name LIKE %:name%) " +
            "AND (:size IS NULL OR c.student_capacity >= :size)" +
            "AND (:courses IS NULL OR FIND_IN_SET(co.name, :courses) > 0)" +
            "AND (:state IS NULL OR a.state = :state)", nativeQuery = true)
    public Optional<List<Center>> findByFilters(@Param("name") String centerName,
                                                @Param("size") Long studentCapacity,
                                                @Param("courses") String courses,
                                                @Param("state") String state);
}
