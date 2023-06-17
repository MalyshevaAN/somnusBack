package malysheva.AN.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;


public record Content(
        @Id
        Integer id,
        @NotBlank
        String title,
        @NotBlank
        String desc,
        Status status,
        Type contentType,
        @PastOrPresent
        LocalDateTime dateCreated,
        @PastOrPresent
        LocalDateTime dateUpdated,
        String url
) {
}
