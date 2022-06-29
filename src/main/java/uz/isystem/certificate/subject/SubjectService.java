package uz.isystem.certificate.subject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.isystem.certificate.www_exceptions.ApiRequestException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    private final ModelMapper mapper;
    private final SubjectRepository subjectRepository;


    public SubjectService(ModelMapper mapper,
                          SubjectRepository subjectRepository) {
        this.mapper = mapper;
        this.subjectRepository = subjectRepository;
    }


    public SubjectDto create(SubjectDto subjectDto) {
        Subject subject = mapper.map(subjectDto, Subject.class);
        subject.setStatus(true);
        subject.setCreatedAt(LocalDateTime.now());
        subjectRepository.save(subject);
        subjectDto = mapper.map(subject, SubjectDto.class);
        return subjectDto;
    }


    public List<SubjectDto> getAll() {

        return subjectRepository.findAllByDeleted_dateIsNull()
                .stream()
                .map(subject -> mapper.map(subject, SubjectDto.class))
                .collect(Collectors.toList());
    }

    public SubjectDto getOne(Long id) {
       return mapper.map(getEntity(id), SubjectDto.class);
    }


    public SubjectDto update(Long id, SubjectDto subjectDto) {
        getEntity(id);
        Subject subject = mapper.map(subjectDto, Subject.class);
        subject.setId(id);
        subject.setUpdatedAt(LocalDateTime.now());
        subjectRepository.save(subject);
        return mapper.map(subject, SubjectDto.class);
    }

    public void delete(Long id) {
        Subject subject = getEntity(id);
        subject.setDeletedAt(LocalDateTime.now());
        subjectRepository.save(subject);
    }


    // |- Secondary functions -|

    public Subject getEntity(Long id) {

        Optional<Subject> optionalSubject = subjectRepository.findByIdAndDeleted_atIsNull(id);
        if (optionalSubject.isEmpty()){
            throw new ApiRequestException("Subject not found!");
        }
        return optionalSubject.get();
    }

}
