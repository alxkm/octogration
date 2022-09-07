package org.octogration.rest.client;

import java.util.List;
import java.util.Map;
import org.github.integration.model.dto.Commit;
import org.github.integration.model.dto.CommitSha;
import org.github.integration.model.dto.File;
import org.github.integration.model.dto.GitBranchView;
import org.github.integration.model.dto.GitCollaboratorView;
import org.github.integration.model.dto.GitRepositoryView;
import org.github.integration.model.dto.GithubRateCommon;
import org.github.integration.model.dto.PullRequest;
import feign.HeaderMap;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface GithubClient {
    @RequestLine("GET /repos/{ownerRepo}/pulls")
    List<PullRequest> getPullRequestsToBranch(@HeaderMap Map<String, String> headers,
                                              @Param("ownerRepo") String ownerRepo,
                                              @QueryMap Map<String, Object> params);

    @RequestLine("GET /repos/{ownerRepo}/commits/{ref}")
    Commit getSingleCommit(@HeaderMap Map<String, String> headers,
                           @Param("ownerRepo") String ownerRepo,
                           @Param("ref") String ref);

    @RequestLine("GET /repos/{ownerRepo}/commits")
    List<CommitSha> getCommitShas(@HeaderMap Map<String, String> headers,
                                  @Param("ownerRepo") String ownerRepo,
                                  @QueryMap Map<String, Object> queryParameters);

    @RequestLine("GET /repos/{ownerRepo}/compare/{startSha}...{stopSha}")
    String getInitialDiff(@HeaderMap Map<String, String> headers,
                          @Param("ownerRepo") String ownerRepo,
                          @Param("startSha") String startSha,
                          @Param("stopSha") String stopSha);

    @RequestLine("GET /repos/{ownerRepo}/branches?per_page={pageSize}&page={page}")
    List<GitBranchView> getRepositoryBranches(@HeaderMap Map<String, String> headers,
                                              @Param("ownerRepo") String ownerRepo,
                                              @Param("pageSize") int pageSize,
                                              @Param("page") int page);

    @RequestLine("GET /repos/{ownerRepo}/collaborators?per_page=100")
    List<GitCollaboratorView> getRepositoryCollaborators(@HeaderMap Map<String, String> headers,
                                                         @Param("ownerRepo") String ownerRepo);

    @RequestLine("GET /repos/{ownerRepo}/contributors?per_page=100")
    List<GitCollaboratorView> getRepositoryContributors(@HeaderMap Map<String, String> headers,
                                                        @Param("ownerRepo") String ownerRepo);

    @RequestLine("GET /user/repos?sort=pushed&direction=desc&per_page=100")
    List<GitRepositoryView> getUserRepositories(@HeaderMap Map<String, String> headers);

    @RequestLine("GET /repos/{ownerRepo}/pulls/{pullRequestId}/files")
    List<File> getPullRequestFiles(@HeaderMap Map<String, String> headers,
                                   @Param("ownerRepo") String ownerRepo,
                                   @Param("pullRequestId") String pullRequestId,
                                   @QueryMap Map<String, Object> queryParameters);

    @RequestLine("GET /repos/{ownerRepo}/pulls/{pullRequestId}/commits")
    List<CommitSha> getPullRequestCommits(@HeaderMap Map<String, String> headers,
                                          @Param("ownerRepo") String ownerRepo,
                                          @Param("pullRequestId") String pullRequestId,
                                          @QueryMap Map<String, Object> queryParameters);

    @RequestLine("GET /rate_limit")
    GithubRateCommon getRate(@HeaderMap Map<String, String> headers);
}
