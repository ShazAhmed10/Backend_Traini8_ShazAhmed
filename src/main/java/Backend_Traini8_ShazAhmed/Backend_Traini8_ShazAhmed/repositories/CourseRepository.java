package Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.repositories;

import Backend_Traini8_ShazAhmed.Backend_Traini8_ShazAhmed.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    //method to find a Course by its name
    @Query(value = "SELECT * FROM course AS c WHERE c.name = :name LIMIT 1", nativeQuery = true)
    public Optional<Course> findByName(@Param("name") String name);
}
