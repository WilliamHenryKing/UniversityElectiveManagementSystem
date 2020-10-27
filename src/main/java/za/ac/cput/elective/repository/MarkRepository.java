package za.ac.cput.elective.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.elective.entity.Mark;


import java.util.Set;

@Repository
public interface MarkRepository extends JpaRepository<Mark, String>
{

}
