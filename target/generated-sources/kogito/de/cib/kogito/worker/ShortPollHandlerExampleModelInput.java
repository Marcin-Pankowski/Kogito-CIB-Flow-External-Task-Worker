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

@ProcessInput(processName = "ShortPollHandlerExample")
public class ShortPollHandlerExampleModelInput implements Model, MapInput, MapInputId, MapOutput, MappableToModel<ShortPollHandlerExampleModel> {

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
    public ShortPollHandlerExampleModel toModel() {
        ShortPollHandlerExampleModel result = new ShortPollHandlerExampleModel();
        result.setActivatedJob(getActivatedJob());
        result.setInputVariables(getInputVariables());
        return result;
    }
}
