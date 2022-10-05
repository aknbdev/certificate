package uz.isystem.certificate.subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query(value = "SELECT * FROM subjects WHERE deleted_at IS NULL", nativeQuery = true)
    List<Subject> findAllByDeleted_dateIsNull();

    @Query(value = "SELECT * FROM subjects WHERE id = :id AND deleted_at IS NULL", nativeQuery = true)
    Optional<Subject> findByIdAndDeleted_atIsNull(Long id);
}
