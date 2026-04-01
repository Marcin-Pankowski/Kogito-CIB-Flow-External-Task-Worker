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

@UserTask(taskName = "Fetch CIB Seven External Tasks", processName = "ShortPollWorkerExample")
public class ShortPollWorkerExample__SPW_FetchAndLockTask_TaskOutput implements MapOutput {

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("activatedJobs", this.activatedJobs);
        return params;
    }

    public static ShortPollWorkerExample__SPW_FetchAndLockTask_TaskOutput fromMap(Map<String, Object> params) {
        de.cib.kogito.worker.ShortPollWorkerExample__SPW_FetchAndLockTask_TaskOutput result = new ShortPollWorkerExample__SPW_FetchAndLockTask_TaskOutput();
        result.activatedJobs = (java.util.List<de.cib.kogito.worker.cibs.dto.ExternalTaskDto>) params.get("activatedJobs");
        return result;
    }

    @UserTaskParam(value = ParamType.OUTPUT)
    private java.util.List<de.cib.kogito.worker.cibs.dto.ExternalTaskDto> activatedJobs;

    public java.util.List<de.cib.kogito.worker.cibs.dto.ExternalTaskDto> getActivatedJobs() {
        return activatedJobs;
    }

    public void setActivatedJobs(java.util.List<de.cib.kogito.worker.cibs.dto.ExternalTaskDto> activatedJobs) {
        this.activatedJobs = activatedJobs;
    }
}
//Task output for user task 'Fetch CIB Seven External Tasks' in process 'ShortPollWorkerExample'
