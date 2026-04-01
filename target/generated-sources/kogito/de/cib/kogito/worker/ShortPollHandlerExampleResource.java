/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package de.cib.kogito.worker;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jbpm.util.JsonSchemaUtil;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.ProcessService;
import org.kie.kogito.process.workitem.TaskModel;
import org.kie.kogito.auth.IdentityProviderFactory;
import org.kie.kogito.auth.SecurityPolicy;

@Path("/ShortPollHandlerExample")
@org.eclipse.microprofile.openapi.annotations.tags.Tag(name = "ShortPollHandlerExample")
@jakarta.enterprise.context.ApplicationScoped()
public class ShortPollHandlerExampleResource {

    @jakarta.inject.Inject()
    @jakarta.inject.Named("ShortPollHandlerExample")
    Process<ShortPollHandlerExampleModel> process;

    @Inject
    ProcessService processService;

    @Inject
    IdentityProviderFactory identityProviderFactory;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ShortPollHandlerExample", description = "")
    @jakarta.transaction.Transactional()
    public List<ShortPollHandlerExampleModelOutput> getResources_ShortPollHandlerExample() {
        return processService.getProcessInstanceOutput(process);
    }

    @GET
    @Path("schema")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ShortPollHandlerExample", description = "")
    @jakarta.transaction.Transactional()
    public Map<String, Object> getResourceSchema_ShortPollHandlerExample() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ShortPollHandlerExample", description = "")
    @jakarta.transaction.Transactional()
    public ShortPollHandlerExampleModelOutput getResource_ShortPollHandlerExample(@PathParam("id") String id) {
        return processService.findById(process, id).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ShortPollHandlerExample", description = "")
    @jakarta.transaction.Transactional()
    public ShortPollHandlerExampleModelOutput deleteResource_ShortPollHandlerExample(@PathParam("id") final String id) {
        return processService.delete(process, id).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ShortPollHandlerExample", description = "")
    @jakarta.transaction.Transactional()
    public ShortPollHandlerExampleModelOutput updateModel_ShortPollHandlerExample(@PathParam("id") String id, ShortPollHandlerExampleModelInput resource) {
        return processService.update(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ShortPollHandlerExample", description = "")
    @jakarta.transaction.Transactional()
    public ShortPollHandlerExampleModelOutput updateModelPartial_ShortPollHandlerExample(@PathParam("id") String id, ShortPollHandlerExampleModelInput resource) {
        return processService.updatePartial(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "ShortPollHandlerExample", description = "")
    @jakarta.transaction.Transactional()
    public List<TaskModel> getTasks_ShortPollHandlerExample(@PathParam("id") String id, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItems(process, id, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups))).orElseThrow(NotFoundException::new).stream().map(de.cib.kogito.worker.ShortPollHandlerExample_TaskModelFactory::from).collect(Collectors.toList());
    }

    @POST
    @Path("/{id}/complete_job/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public ShortPollHandlerExampleModelOutput completeTask_complete_job_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("complete") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final de.cib.kogito.worker.ShortPollHandlerExample__SPH_CompleteTask_TaskOutput model) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/complete_job/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public de.cib.kogito.worker.ShortPollHandlerExample__SPH_CompleteTask_TaskOutput saveTask_complete_job_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final de.cib.kogito.worker.ShortPollHandlerExample__SPH_CompleteTask_TaskOutput model) {
        return processService.setWorkItemOutput(process, id, taskId, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model, de.cib.kogito.worker.ShortPollHandlerExample__SPH_CompleteTask_TaskOutput::fromMap).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/complete_job/{taskId}/phases/{phase}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public ShortPollHandlerExampleModelOutput taskTransition_complete_job_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("phase") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final de.cib.kogito.worker.ShortPollHandlerExample__SPH_CompleteTask_TaskOutput model) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/complete_job/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public de.cib.kogito.worker.ShortPollHandlerExample__SPH_CompleteTask_TaskModel getWorkItem_complete_job_0(@PathParam("id") String id, @PathParam("taskId") String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItem(process, id, taskId, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), de.cib.kogito.worker.ShortPollHandlerExample__SPH_CompleteTask_TaskModel::from).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/complete_job/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public ShortPollHandlerExampleModelOutput abortTask_complete_job_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("abort") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), null).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("complete_job/schema")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public Map<String, Object> getSchema_complete_job_0() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "complete_job");
    }

    @GET
    @Path("/{id}/complete_job/{taskId}/schema")
    @Produces(MediaType.APPLICATION_JSON)
    @jakarta.transaction.Transactional()
    public Map<String, Object> getSchemaAndPhases_complete_job_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getWorkItemSchemaAndPhases(process, id, taskId, "complete_job", SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)));
    }
}
