package org.octogration.rest.client;

import java.util.Map;
import org.github.integration.model.dto.GithubInstallationToken;
import feign.HeaderMap;
import feign.Param;
import feign.RequestLine;

public interface GithubAppClient {
    @RequestLine("POST /app/installations/{installationId}/access_tokens")
    GithubInstallationToken getInstallationToken(@HeaderMap Map<String, String> headers, @Param("owner") String installationId);
}
