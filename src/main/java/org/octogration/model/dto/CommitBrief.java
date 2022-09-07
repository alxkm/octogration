package org.octogration.model.dto;

import java.util.Optional;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommitBrief {
    Committer author;
    Committer committer;
    String message;

    public Committer getAuthorCommitter() {
        return author != null ? author : committer;
    }

    public Optional<String> getEmail() {
        Committer obj = getAuthorCommitter();
        return obj == null ? Optional.empty() : Optional.ofNullable(obj.getEmail());
    }
}
