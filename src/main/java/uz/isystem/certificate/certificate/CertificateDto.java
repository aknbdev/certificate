package uz.isystem.certificate.certificate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import uz.isystem.certificate.subject.SubjectDto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CertificateDto extends FilterDto{

    private Long id;
    private SubjectDto subject;
    @NotNull(message = "Subject id is mandatory")
    private Long subjectId;
    private String token;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Surname is mandatory")
    private String surname;
    private String url;
    private String path;
    private LocalDate finishedDate;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
