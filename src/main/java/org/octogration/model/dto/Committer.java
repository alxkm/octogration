package org.octogration.model.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Committer {
    String name;
    String email;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    LocalDateTime date;
}
