/*
 * Copyright Marcin Pankowski
 * Behamstrasse 8
 * 80687
 * www.piu.de
 */
package de.cib.kogito.worker.cibs.dto;

import java.util.List;

public class FetchAndLockRequestDto {

    private String workerId;
    private Integer maxTasks;
    private Boolean usePriority;
    private List<TopicDto> topics;

    public FetchAndLockRequestDto() {}

    public String getWorkerId() { return workerId; }
    public void setWorkerId(String workerId) { this.workerId = workerId; }

    public Integer getMaxTasks() { return maxTasks; }
    public void setMaxTasks(Integer maxTasks) { this.maxTasks = maxTasks; }

    public Boolean getUsePriority() { return usePriority; }
    public void setUsePriority(Boolean usePriority) { this.usePriority = usePriority; }

    public List<TopicDto> getTopics() { return topics; }
    public void setTopics(List<TopicDto> topics) { this.topics = topics; }
}
