package org.octogration.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class File {
    String filename;
    int additions;
    int deletions;
    @JsonProperty(value = "changes")
    int linesAffected;
    String status;
    @JsonProperty(value = "raw_url")
    String rawUrl;
    String patch;
}
