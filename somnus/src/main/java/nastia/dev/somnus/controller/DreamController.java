package nastia.dev.somnus.controller;


import nastia.dev.somnus.model.Dream;
import nastia.dev.somnus.service.DreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dream")
public class DreamController {

    @Autowired
    DreamService dreamService;

    @PostMapping("/add")
    public Dream addDream(@RequestBody Dream dream){
        return dreamService.addDream(dream);

    }

    @GetMapping("/all")
    public List<Dream> getAllDreams(){
        return dreamService.getAllDreams();
    }

    @PutMapping("/{dreamId}/author/{authorId}")
    public Dream dreamAddAuthor(@PathVariable Long dreamId, @PathVariable Long authorId){
        return dreamService.addAuthorToDream(dreamId, authorId);
    }
}

