/*
 * Copyright Marcin Pankowski
 * Behamstrasse 8
 * 80687
 * www.piu.de
 */
package de.cib.kogito.worker.cibs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a CIB Seven / Camunda 7 external task returned by fetchAndLock.
 *
 * Mirrors the Zeebe ActivatedJob role in the template — used as the loop item
 * in the ShortPollWorkerExample multi-instance call activity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalTaskDto {

    private String id;
    private String workerId;
    private String topicName;
    private String processInstanceId;
    private String activityId;
    private String businessKey;
    private Map<String, VariableValueDto> variables;
    private Integer retries;
    private Integer priority;
    private String tenantId;

    public ExternalTaskDto() {}

    /** Convenience method — mirrors ActivatedJob.getVariablesAsMap() from the template. */
    public Map<String, Object> getVariablesAsMap() {
        if (variables == null) return Collections.emptyMap();
        return variables.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue() != null ? e.getValue().getValue() : null
                ));
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getWorkerId() { return workerId; }
    public void setWorkerId(String workerId) { this.workerId = workerId; }

    public String getTopicName() { return topicName; }
    public void setTopicName(String topicName) { this.topicName = topicName; }

    public String getProcessInstanceId() { return processInstanceId; }
    public void setProcessInstanceId(String processInstanceId) { this.processInstanceId = processInstanceId; }

    public String getActivityId() { return activityId; }
    public void setActivityId(String activityId) { this.activityId = activityId; }

    public String getBusinessKey() { return businessKey; }
    public void setBusinessKey(String businessKey) { this.businessKey = businessKey; }

    public Map<String, VariableValueDto> getVariables() { return variables; }
    public void setVariables(Map<String, VariableValueDto> variables) { this.variables = variables; }

    public Integer getRetries() { return retries; }
    public void setRetries(Integer retries) { this.retries = retries; }

    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
}
