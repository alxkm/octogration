package org.octogration;

import org.octogration.config.GithubClientFactory;
import org.octogration.config.GithubContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestExample {
    public static void main(String[] args) {
        try {
            var githubClient = GithubClientFactory.createGithubClient();
            var ctx = GithubContext.builder()
                                   .owner("owner")
                                   .isApp(true)
                                   .token("yourGithubToken")
                                   .repository("repo").build();

            githubClient.getRepositoryContributors(ctx.getHeaders(), ctx.getOwnerRepository())
                        .forEach(s -> log.info("Contributor{{}} to repo{{}}", s.getId(), ctx.getRepository()));
        } catch (Exception e) {
            log.error("Error during github test call", e);
        }
    }
}
