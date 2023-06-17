package malysheva.AN.contentcalendar.repository;

import malysheva.AN.contentcalendar.model.Content;
import malysheva.AN.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);

    @Query("""
            Select * from content 
            where status = :status
            """)

    List<Content> listByStatus(@Param("status") Status status);

}
