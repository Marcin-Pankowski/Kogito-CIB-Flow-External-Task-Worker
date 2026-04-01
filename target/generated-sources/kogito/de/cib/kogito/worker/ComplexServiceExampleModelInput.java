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
import org.kie.kogito.ProcessInput;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "ComplexServiceExample", name = "ComplexServiceExample", hidden = true)
@ProcessInput(processName = "ComplexServiceExample")
public class ComplexServiceExampleModelInput implements Model, MapInput, MapInputId, MapOutput, MappableToModel<ComplexServiceExampleModel> {

    @org.kie.kogito.codegen.VariableInfo(tags = "input")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "externalTask")
    private de.cib.kogito.worker.cibs.dto.ExternalTaskDto externalTask;

    public de.cib.kogito.worker.cibs.dto.ExternalTaskDto getExternalTask() {
        return externalTask;
    }

    public void setExternalTask(de.cib.kogito.worker.cibs.dto.ExternalTaskDto externalTask) {
        this.externalTask = externalTask;
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

    @org.kie.kogito.codegen.VariableInfo(tags = "input")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "taskId")
    private java.lang.String taskId;

    public java.lang.String getTaskId() {
        return taskId;
    }

    public void setTaskId(java.lang.String taskId) {
        this.taskId = taskId;
    }

    @Override()
    public ComplexServiceExampleModel toModel() {
        ComplexServiceExampleModel result = new ComplexServiceExampleModel();
        result.setExternalTask(getExternalTask());
        result.setInputVariables(getInputVariables());
        result.setTaskId(getTaskId());
        return result;
    }
}
