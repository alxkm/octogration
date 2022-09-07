package org.octogration;

import org.github.integration.config.GithubClientFactory;
import org.github.integration.config.GithubContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            var githubClient = GithubClientFactory.createGithubClient();
            var ctx = GithubContext.builder()
                                   .login("login")
                                   .password("password")
                                   .owner("owner")
                                   .repository("repo").build();

            githubClient.getRepositoryContributors(ctx.getHeaders(), ctx.getOwnerRepository())
                        .forEach(s -> log.info("Contributor{{}} to repo{{}}", s.getId(), ctx.getRepository()));
        } catch (Exception e) {
            log.error("Error during github test call", e);
        }
    }
}
