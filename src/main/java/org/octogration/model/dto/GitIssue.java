package org.octogration.model.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GitIssue {
    String id;
    String body;
    String title;
    String state;
    String number;
    List<GitIssueAssignee> assignees;
    List<Label> labels;
    @JsonProperty("created_at")
    String createdAt;
    @JsonProperty("updated_at")
    String updatedAt;
    @JsonProperty("closed_at")
    String closedAt;
}
