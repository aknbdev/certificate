package uz.isystem.certificate.subject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    // |- create function -|
    @PostMapping
    public ResponseEntity<?> create(@RequestBody SubjectDto subjectDto){
        return ResponseEntity.ok(subjectService.create(subjectDto));
    }

    // |- Get all function -|
    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(subjectService.getAll());
    }

    // |- Get One function -|
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Long id){
        return ResponseEntity.ok(subjectService.getOne(id));
    }

    // |- Update function -|
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,
                                    @RequestBody SubjectDto subjectDto){
        return ResponseEntity.ok(subjectService.update(id, subjectDto));
    }

    // |- Delete function -|
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        subjectService.delete(id);
        return ResponseEntity.ok("Ok, deleted!");
    }
}
