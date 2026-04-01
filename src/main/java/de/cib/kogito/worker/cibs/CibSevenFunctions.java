/*
 * Copyright Marcin Pankowski
 * Behamstrasse 8
 * 80687
 * www.piu.de
 */
package de.cib.kogito.worker.cibs;

import de.cib.kogito.worker.cibs.dto.*;
import io.quarkus.logging.Log;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * CIB Seven / Camunda 7 helper bean — mirrors the role of ZeebeFunctions in the template.
 *
 * Methods are called directly from Kogito BPMN service tasks.
 * Parameter names must match the BPMN data input names exactly (Kogito maps by name via reflection).
 */
@Singleton
public class CibSevenFunctions {

    @Inject
    @RestClient
    CibSevenRestClient restClient;

    /**
     * Fetches and locks external tasks from CIB Seven.
     *
     * Called from ShortPollWorkerExample.bpmn service task with inputs:
     *   topicName, workerName, maxJobsToActivate, lockDurationMinutes
     */
    public List<ExternalTaskDto> fetchAndLock(String topicName, String workerName,
                                               Integer maxJobsToActivate, Integer lockDurationMinutes) {
        FetchAndLockRequestDto request = new FetchAndLockRequestDto();
        request.setWorkerId(workerName);
        request.setMaxTasks(maxJobsToActivate);
        request.setUsePriority(false);

        TopicDto topic = new TopicDto();
        topic.setTopicName(topicName);
        topic.setLockDuration((long) lockDurationMinutes * 60 * 1000L);
        request.setTopics(Collections.singletonList(topic));

        try {
            List<ExternalTaskDto> tasks = restClient.fetchAndLock(request);
            Log.infof("Fetched %d external task(s) for topic '%s'", tasks.size(), topicName);
            return tasks;
        } catch (Exception e) {
            Log.errorf("fetchAndLock failed for topic '%s': %s", topicName, e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Completes an external task in CIB Seven.
     *
     * Called from ShortPollHandlerExample.bpmn service task with inputs:
     *   taskId (String), variables (Object — Map<String,Object> at runtime)
     */
    public void complete(String taskId, Object variables) {
        CompleteTaskRequestDto request = new CompleteTaskRequestDto();
        request.setWorkerId("kogito-cib-worker");

        if (variables instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> vars = (Map<String, Object>) variables;
            Map<String, VariableValueDto> variableValues = vars.entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> new VariableValueDto(e.getValue())
                    ));
            request.setVariables(variableValues);
        }

        restClient.complete(taskId, request);

        Log.infof("Completed external task: %s", taskId);
        Log.info("CIB Seven Task Fullfilled");
    }

    /**
     * Reports a failure for an external task (decrements retries; becomes incident at 0).
     */
    public void failTask(String taskId, String workerName, String errorMessage, Integer retries) {
        FailureRequestDto request = new FailureRequestDto();
        request.setWorkerId(workerName);
        request.setErrorMessage(errorMessage);
        request.setRetries(retries);
        request.setRetryTimeout(5_000L);

        restClient.reportFailure(taskId, request);
        Log.errorf("Reported failure for external task %s (retries left: %d): %s",
                taskId, retries, errorMessage);
    }
}
