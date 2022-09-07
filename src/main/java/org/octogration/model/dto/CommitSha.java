package org.octogration.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommitSha {
    String sha;
    String message;
    LocalDateTime date;
    List<CommitParent> parents;
    @JsonProperty("commit")
    @SuppressWarnings("unchecked")
    private void unpackNested(Map<String, Object> commit) {
        try {
            var authorMap = (Map<String, String>) commit.get("author");
            String dateStr = authorMap.get("date").replace("Z", "");
            this.date = LocalDateTime.parse(dateStr);
            this.message = (String) commit.get("message");
        } catch (Exception ex) {
            log.error("Could not parse date for commit with sha: " + this.sha);
        }
    }
}
