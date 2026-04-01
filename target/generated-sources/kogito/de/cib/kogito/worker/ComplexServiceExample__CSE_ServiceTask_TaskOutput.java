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

import java.util.HashMap;
import java.util.Map;
import org.kie.kogito.MapOutput;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "do something with a service", processName = "ComplexServiceExample")
public class ComplexServiceExample__CSE_ServiceTask_TaskOutput implements MapOutput {

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("variables", this.variables);
        return params;
    }

    public static ComplexServiceExample__CSE_ServiceTask_TaskOutput fromMap(Map<String, Object> params) {
        de.cib.kogito.worker.ComplexServiceExample__CSE_ServiceTask_TaskOutput result = new ComplexServiceExample__CSE_ServiceTask_TaskOutput();
        result.variables = (java.util.Map<String,Object>) params.get("variables");
        return result;
    }

    @UserTaskParam(value = ParamType.OUTPUT)
    private java.util.Map<String, Object> variables;

    public java.util.Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(java.util.Map<String, Object> variables) {
        this.variables = variables;
    }
}
//Task output for user task 'do something with a service' in process 'ComplexServiceExample'
