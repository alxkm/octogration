package org.octogration.rest.client;

import java.util.List;
import java.util.Map;
import org.octogration.model.dto.GitIssue;
import feign.HeaderMap;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface GithubIssuesClient {
    @RequestLine("GET /repos/{ownerRepo}/issues")
    List<GitIssue> getRepositoryIssues(@HeaderMap Map<String, String> headers,
                                       @Param("ownerRepo") String ownerRepo,
                                       @QueryMap Map<String, Object> queryParameters);
}