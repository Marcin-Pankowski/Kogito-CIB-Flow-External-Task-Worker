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

import java.util.Map;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "Fetch CIB Seven External Tasks", processName = "ShortPollWorkerExample")
public class ShortPollWorkerExample__SPW_FetchAndLockTask_TaskInput {

    public static ShortPollWorkerExample__SPW_FetchAndLockTask_TaskInput fromMap(Map<String, Object> params) {
        ShortPollWorkerExample__SPW_FetchAndLockTask_TaskInput item = new ShortPollWorkerExample__SPW_FetchAndLockTask_TaskInput();
        item.lockDurationMinutes = (java.lang.Integer) params.get("lockDurationMinutes");
        item.topicName = (java.lang.String) params.get("topicName");
        item.workerName = (java.lang.String) params.get("workerName");
        item.maxJobsToActivate = (java.lang.Integer) params.get("maxJobsToActivate");
        item.Interface = (java.lang.String) params.get("Interface");
        item.Operation = (java.lang.String) params.get("Operation");
        item.interfaceImplementationRef = (java.lang.String) params.get("interfaceImplementationRef");
        item.operationImplementationRef = (java.lang.String) params.get("operationImplementationRef");
        item.implementation = (java.lang.String) params.get("implementation");
        return item;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.Integer lockDurationMinutes;

    public java.lang.Integer getLockDurationMinutes() {
        return lockDurationMinutes;
    }

    public void setLockDurationMinutes(java.lang.Integer lockDurationMinutes) {
        this.lockDurationMinutes = lockDurationMinutes;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String topicName;

    public java.lang.String getTopicName() {
        return topicName;
    }

    public void setTopicName(java.lang.String topicName) {
        this.topicName = topicName;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String workerName;

    public java.lang.String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(java.lang.String workerName) {
        this.workerName = workerName;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.Integer maxJobsToActivate;

    public java.lang.Integer getMaxJobsToActivate() {
        return maxJobsToActivate;
    }

    public void setMaxJobsToActivate(java.lang.Integer maxJobsToActivate) {
        this.maxJobsToActivate = maxJobsToActivate;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String Interface;

    public java.lang.String getInterface() {
        return Interface;
    }

    public void setInterface(java.lang.String Interface) {
        this.Interface = Interface;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String Operation;

    public java.lang.String getOperation() {
        return Operation;
    }

    public void setOperation(java.lang.String Operation) {
        this.Operation = Operation;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String interfaceImplementationRef;

    public java.lang.String getInterfaceImplementationRef() {
        return interfaceImplementationRef;
    }

    public void setInterfaceImplementationRef(java.lang.String interfaceImplementationRef) {
        this.interfaceImplementationRef = interfaceImplementationRef;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String operationImplementationRef;

    public java.lang.String getOperationImplementationRef() {
        return operationImplementationRef;
    }

    public void setOperationImplementationRef(java.lang.String operationImplementationRef) {
        this.operationImplementationRef = operationImplementationRef;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String implementation;

    public java.lang.String getImplementation() {
        return implementation;
    }

    public void setImplementation(java.lang.String implementation) {
        this.implementation = implementation;
    }
}
//Task input for user task 'Fetch CIB Seven External Tasks' in process 'ShortPollWorkerExample'
