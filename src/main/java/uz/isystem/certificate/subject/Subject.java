package uz.isystem.certificate.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = ("subjects"))
public class Subject {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = ("name"))
    private String name;

    @Column(name = ("status"))
    private Boolean status;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
