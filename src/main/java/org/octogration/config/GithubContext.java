package org.octogration.config;

import java.util.Base64;
import java.util.Map;
import org.octogration.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GithubContext {
    private String owner;
    private String repository;
    private String ownerRepo;

    private String login;
    private String password;
    private String token;
    private boolean isApp;

    public GithubContext(String owner, String repository) {
        this.owner = owner;
        this.repository = repository;
        this.ownerRepo = owner + "/" + repository;
    }

    public static Map<String, String> getHeaders(String token) {
        return Map.of("Authorization", "Bearer " + token,
                      "Accept", "application/vnd.github.machine-man-preview+json");
    }

    public String getOwnerRepository() {
        if (this.ownerRepo == null) {
            this.ownerRepo = owner + "/" + repository;
        }
        return this.ownerRepo;
    }

    public Map<String, String> getHeaders() {
        if (StringUtils.isEmpty(token)) {
            if (StringUtils.isEmpty(password) || StringUtils.isEmpty(login)) {
                throw new IllegalArgumentException("Both token and login/password for request are empty");
            }
            byte[] loginPasswordBytes = String.join(":", login, password).getBytes();
            return Map.of("Authorization", "Basic " + Base64.getEncoder().encodeToString(loginPasswordBytes));
        }
        if (isApp) {
            return Map.of("Authorization", "token " + token);
        }
        return Map.of("Authorization", "Bearer " + token,
                      "Accept", "application/vnd.github.machine-man-preview+json");
    }
}
