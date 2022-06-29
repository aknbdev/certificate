package uz.isystem.certificate.certificate;
import lombok.Getter;
import lombok.Setter;
import uz.isystem.certificate.subject.Subject;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = ("certificates"))
public class Certificate {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = ("subject_id"), insertable = false, updatable = false)
    private Subject subject;

    @Column(name = ("subject_id"))
    private Long subjectId;

    @Column(name = ("token"))
    private String token;

    @Column(name = ("name"))
    private String name;

    @Column(name = ("surname"))
    private String surname;

    @Column(name = ("url"))
    private String url;

    @Column(name = ("path"))
    private String path;

    @Column(name = ("finished_date"))
    private LocalDate finishedDate;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}