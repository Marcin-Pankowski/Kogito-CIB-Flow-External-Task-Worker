/*
 * Copyright Marcin Pankowski
 * Behamstrasse 8
 * 80687
 * www.piu.de
 */
package de.cib.kogito.worker.cibs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a single Camunda 7 / CIB Seven typed variable value.
 *
 * REST format: {"value": "Kogito", "type": "String", "valueInfo": {}}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableValueDto {

    private Object value;
    private String type;

    public VariableValueDto() {}

    public VariableValueDto(Object value) {
        this.value = value;
        this.type = value != null ? value.getClass().getSimpleName() : "Null";
    }

    public Object getValue() { return value; }
    public void setValue(Object value) { this.value = value; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
