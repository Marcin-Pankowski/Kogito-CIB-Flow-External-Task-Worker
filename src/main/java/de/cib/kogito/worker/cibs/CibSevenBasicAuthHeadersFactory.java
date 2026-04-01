/*
 * Copyright Marcin Pankowski
 * Behamstrasse 8
 * 80687
 * www.piu.de
 */
package de.cib.kogito.worker.cibs;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@ApplicationScoped
public class CibSevenBasicAuthHeadersFactory implements ClientHeadersFactory {

    @ConfigProperty(name = "cib-seven.auth.username")
    Optional<String> username;

    @ConfigProperty(name = "cib-seven.auth.password")
    Optional<String> password;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders,
                                                 MultivaluedMap<String, String> clientOutgoingHeaders) {
        MultivaluedMap<String, String> headers = new MultivaluedHashMap<>();
        headers.putAll(clientOutgoingHeaders);

        if (username.isEmpty() || password.isEmpty()) {
            return headers;
        }

        String credentials = username.get() + ":" + password.get();
        String encoded = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
        headers.putSingle("Authorization", "Basic " + encoded);
        return headers;
    }
}
