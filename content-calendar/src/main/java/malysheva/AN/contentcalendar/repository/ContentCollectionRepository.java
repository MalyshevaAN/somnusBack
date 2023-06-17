package malysheva.AN.contentcalendar.repository;

import jakarta.annotation.PostConstruct;
import malysheva.AN.contentcalendar.model.Content;
import malysheva.AN.contentcalendar.model.Status;
import malysheva.AN.contentcalendar.model.Type;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return this.contentList;
    }


    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(i -> i.id().equals(id)).findFirst();
    }

    public void save(Content content){
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existsById(Integer id){
        return contentList.stream().filter(i -> i.id().equals(id)).count() == 1;
    }

    public void deleteById(Integer id){
        contentList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init(){
        Content c = new Content(1,
                "My first post",
                "Hello World",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "gglkjfglj");

        contentList.add(c);
    }
}
