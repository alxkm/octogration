# Octogration <img src="https://www.svgrepo.com/show/353136/github.svg" height="32px" alt="Octogration" />

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Octogration is github integration java library.
It provides basic github API integration using feign-core.


It implemented api is enough to build commits analysis tool.
Or own github application, or github bot to process commit information.

Api cover next areas:
- commits 
- pull requests
- commits delta
- commits file information
- contributors info
- other


### Quick start

Using is very simple like it is described in main class:

```java

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

```



### Changelog

#### 0.0.1:
- initial release