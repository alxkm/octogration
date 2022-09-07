package org.octogration.config;

import org.github.integration.rest.client.GithubAppClient;
import org.github.integration.rest.client.GithubClient;
import org.github.integration.rest.client.GithubIssuesClient;
import feign.Feign;
import feign.gson.GsonDecoder;

public class GithubClientFactory {

    public static final String GITHUB_API_HREF = "https://api.github.com";

    public static GithubAppClient createGithubAppClient() {
        return Feign.builder()
                    .decoder(new GsonDecoder())
                    .target(GithubAppClient.class, GITHUB_API_HREF);
    }

    public static GithubClient createGithubClient() {
        return Feign.builder()
                    .decoder(new GsonDecoder())
                    .target(GithubClient.class, "https://api.github.com");
    }

    public static GithubIssuesClient createGithubIssueClient() {
        return Feign.builder()
                    .decoder(new GsonDecoder())
                    .target(GithubIssuesClient.class, "https://api.github.com");
    }
}
