/*
 * Copyright Marcin Pankowski
 * Behamstrasse 8
 * 80687
 * www.piu.de
 */
package de.cib.kogito.worker.cibs.dto;

import java.util.List;

public class TopicDto {

    private String topicName;
    private Long lockDuration;
    private List<String> variables;

    public TopicDto() {}

    public String getTopicName() { return topicName; }
    public void setTopicName(String topicName) { this.topicName = topicName; }

    public Long getLockDuration() { return lockDuration; }
    public void setLockDuration(Long lockDuration) { this.lockDuration = lockDuration; }

    public List<String> getVariables() { return variables; }
    public void setVariables(List<String> variables) { this.variables = variables; }
}
