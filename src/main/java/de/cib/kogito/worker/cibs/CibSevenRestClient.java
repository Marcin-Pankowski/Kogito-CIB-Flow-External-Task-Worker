/*
 * Copyright Marcin Pankowski
 * Behamstrasse 8
 * 80687
 * www.piu.de
 */
package de.cib.kogito.worker.cibs;

import de.cib.kogito.worker.cibs.dto.CompleteTaskRequestDto;
import de.cib.kogito.worker.cibs.dto.ExternalTaskDto;
import de.cib.kogito.worker.cibs.dto.FailureRequestDto;
import de.cib.kogito.worker.cibs.dto.FetchAndLockRequestDto;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 * MicroProfile REST Client for the CIB Seven / Camunda 7 External Task REST API.
 *
 * Base URL is configured via:
 *   quarkus.rest-client.cib-seven.url=http://localhost:8080
 */
@Path("/engine-rest")
@RegisterRestClient(configKey = "cib-seven")
@RegisterClientHeaders(CibSevenBasicAuthHeadersFactory.class)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CibSevenRestClient {

    @POST
    @Path("/external-task/fetchAndLock")
    List<ExternalTaskDto> fetchAndLock(FetchAndLockRequestDto request);

    @POST
    @Path("/external-task/{id}/complete")
    void complete(@PathParam("id") String id, CompleteTaskRequestDto request);

    @POST
    @Path("/external-task/{id}/failure")
    void reportFailure(@PathParam("id") String id, FailureRequestDto request);
}
