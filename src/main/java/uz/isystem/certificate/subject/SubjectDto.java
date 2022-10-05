package uz.isystem.certificate.subject;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {

    private Long id;
    @NotBlank(message = "Name is mandatory!")
    private String name;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
