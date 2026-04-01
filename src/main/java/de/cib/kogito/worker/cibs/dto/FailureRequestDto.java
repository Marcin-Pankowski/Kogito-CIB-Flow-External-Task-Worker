/*
 * Copyright Marcin Pankowski
 * Behamstrasse 8
 * 80687
 * www.piu.de
 */
package de.cib.kogito.worker.cibs.dto;

public class FailureRequestDto {

    private String workerId;
    private String errorMessage;
    private String errorDetails;
    private Integer retries;
    private Long retryTimeout;

    public FailureRequestDto() {}

    public String getWorkerId() { return workerId; }
    public void setWorkerId(String workerId) { this.workerId = workerId; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    public String getErrorDetails() { return errorDetails; }
    public void setErrorDetails(String errorDetails) { this.errorDetails = errorDetails; }

    public Integer getRetries() { return retries; }
    public void setRetries(Integer retries) { this.retries = retries; }

    public Long getRetryTimeout() { return retryTimeout; }
    public void setRetryTimeout(Long retryTimeout) { this.retryTimeout = retryTimeout; }
}
