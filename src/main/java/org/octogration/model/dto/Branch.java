package org.octogration.model.dto;

import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Branch {
    String label;
    String ref;
    String sha;
}
