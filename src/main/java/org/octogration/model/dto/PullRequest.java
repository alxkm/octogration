package org.octogration.model.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PullRequest {
    String id;
    String url;
    String number;
    String state;
    String title;
    User user;
    @JsonProperty(value = "created_at")
    String createdAt;
    @JsonProperty(value = "updated_at")
    String updatedAt;
    @JsonProperty(value = "closed_at")
    String closedAt;
    @JsonProperty(value = "merged_at")
    String mergedAt;
    @JsonProperty(value = "merge_commit_sha")
    String mergedCommitSha;
    User assignee;
    List<User> assignees;
    @JsonProperty(value = "requested_reviewers")
    List<User> requestedReviewers;
    @JsonProperty(value = "merged_by")
    User merger;
    @JsonProperty(value = "base")
    Branch toBranch;
    @JsonProperty(value = "head")
    Branch fromBranch;
}
