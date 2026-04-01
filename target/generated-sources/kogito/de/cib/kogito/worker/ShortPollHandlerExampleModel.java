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

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;

public class ShortPollHandlerExampleModel implements org.kie.kogito.Model, MapInput, MapInputId, MapOutput, MappableToModel<ShortPollHandlerExampleModelOutput> {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "output")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "outputVariables")
    private java.lang.Object outputVariables;

    public java.lang.Object getOutputVariables() {
        return outputVariables;
    }

    public void setOutputVariables(java.lang.Object outputVariables) {
        this.outputVariables = outputVariables;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "input")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "activatedJob")
    private de.cib.kogito.worker.cibs.dto.ExternalTaskDto activatedJob;

    public de.cib.kogito.worker.cibs.dto.ExternalTaskDto getActivatedJob() {
        return activatedJob;
    }

    public void setActivatedJob(de.cib.kogito.worker.cibs.dto.ExternalTaskDto activatedJob) {
        this.activatedJob = activatedJob;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "input")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "inputVariables")
    private java.util.Map<String, Object> inputVariables;

    public java.util.Map<String, Object> getInputVariables() {
        return inputVariables;
    }

    public void setInputVariables(java.util.Map<String, Object> inputVariables) {
        this.inputVariables = inputVariables;
    }

    @Override()
    public ShortPollHandlerExampleModelOutput toModel() {
        ShortPollHandlerExampleModelOutput result = new ShortPollHandlerExampleModelOutput();
        result.setId(getId());
        result.setOutputVariables(getOutputVariables());
        return result;
    }
}
