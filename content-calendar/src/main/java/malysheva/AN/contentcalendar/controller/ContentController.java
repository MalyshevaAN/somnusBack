package malysheva.AN.contentcalendar.controller;


import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import malysheva.AN.contentcalendar.model.Content;
import malysheva.AN.contentcalendar.model.Status;
import malysheva.AN.contentcalendar.model.Type;
import malysheva.AN.contentcalendar.repository.ContentCollectionRepository;
import malysheva.AN.contentcalendar.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentRepository repo;

    @Autowired
    public ContentController(ContentRepository contentRepository){
        this.repo = contentRepository;
    }

    // make a request and find all content in system


    @GetMapping("")
    public List<Content> findAll() {
        return repo.findAll();
    }

    // Create Read Update Delete

    @GetMapping("/{id}")
    public Content findbyId(@PathVariable Integer id){
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repo.save(content);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Content content, @PathVariable Integer id){
        if (!repo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repo.save(content);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Integer id){
        repo.deleteById(id);
    }


    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return repo.findAllByTitleContains(keyword);
    }

    @GetMapping("filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status){
        return  repo.listByStatus(status);
    }

}
