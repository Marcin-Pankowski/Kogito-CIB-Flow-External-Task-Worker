/*
 * Copyright Marcin Pankowski
 * Behamstrasse 8
 * 80687
 * www.piu.de
 */
package de.cib.kogito.worker.cibs.dto;

import java.util.Map;

public class CompleteTaskRequestDto {

    private String workerId;
    private Map<String, VariableValueDto> variables;

    public CompleteTaskRequestDto() {}

    public String getWorkerId() { return workerId; }
    public void setWorkerId(String workerId) { this.workerId = workerId; }

    public Map<String, VariableValueDto> getVariables() { return variables; }
    public void setVariables(Map<String, VariableValueDto> variables) { this.variables = variables; }
}
