package org.octogration.model.dto;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GithubRateCommon {
    private int rateRemain;
    @JsonProperty("rate")
    private void unpackNested(Map<String, Object> rate) {
        try {
            this.rateRemain = (Integer)rate.get("remaining");
        } catch (Exception ex) {
            log.error("Could not parse rate remaining : " + rate);
        }
    }
}
