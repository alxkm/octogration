package org.octogration.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GitCollaboratorView {
    String id;
    String login;
    @JsonProperty("avatar_url")
    String avatarUrl;
}
