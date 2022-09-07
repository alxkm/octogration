package org.octogration.model.dto;

import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Commit {
    String sha;
    Author author;
    Author committer;
    List<File> files;
    @JsonProperty(value = "commit")
    CommitBrief commitBrief;
    CommitStats stats;

    public Author getAuthor() {
        return author != null ? author : committer;
    }

    public Optional<String> getAuthorLogin() {
        Author commitAuthor = getAuthor();
        return commitAuthor != null ? Optional.ofNullable(commitAuthor.getLogin()) : commitBrief.getEmail();
    }
}
