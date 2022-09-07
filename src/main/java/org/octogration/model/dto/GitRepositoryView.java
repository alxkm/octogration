package org.octogration.model.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GitRepositoryView {
    String id;
    String credentialsId;
    String name;
    Owner owner;
    String fullName;
    List<GitBranchView> branches;
}