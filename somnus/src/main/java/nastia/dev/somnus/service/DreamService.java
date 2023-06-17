package nastia.dev.somnus.service;


import nastia.dev.somnus.model.Dream;
import nastia.dev.somnus.model.User;
import nastia.dev.somnus.repository.DreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DreamService {

    @Autowired
    DreamRepository dreamRepository;

    @Autowired
    UserService userService;

    public Dream addDream(Dream dream){

        return dreamRepository.save(dream);
    }

    public List<Dream> getAllDreams(){
        return dreamRepository.findAll();
    }

    public Dream addAuthorToDream(Long dreamId, Long authorId){
        User user = userService.getUserById(authorId);
        Dream dream = dreamRepository.findById(dreamId).get();
        dream.setAuthor(user);
        userService.addUserDream(user, dream);
        return dreamRepository.save(dream);
    }

    public Dream getDreamById(long dreaId){
        return dreamRepository.findById(dreaId).get();
    }
}
