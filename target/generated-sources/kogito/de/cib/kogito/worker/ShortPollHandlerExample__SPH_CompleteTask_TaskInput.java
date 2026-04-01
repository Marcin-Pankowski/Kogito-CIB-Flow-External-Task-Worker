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

@UserTask(taskName = "complete job", processName = "ShortPollHandlerExample")
public class ShortPollHandlerExample__SPH_CompleteTask_TaskInput {

    public static ShortPollHandlerExample__SPH_CompleteTask_TaskInput fromMap(Map<String, Object> params) {
        ShortPollHandlerExample__SPH_CompleteTask_TaskInput item = new ShortPollHandlerExample__SPH_CompleteTask_TaskInput();
        item.variables = (java.lang.Object) params.get("variables");
        item.taskId = (java.lang.String) params.get("taskId");
        item.Interface = (java.lang.String) params.get("Interface");
        item.Operation = (java.lang.String) params.get("Operation");
        item.interfaceImplementationRef = (java.lang.String) params.get("interfaceImplementationRef");
        item.operationImplementationRef = (java.lang.String) params.get("operationImplementationRef");
        item.implementation = (java.lang.String) params.get("implementation");
        return item;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.Object variables;

    public java.lang.Object getVariables() {
        return variables;
    }

    public void setVariables(java.lang.Object variables) {
        this.variables = variables;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String taskId;

    public java.lang.String getTaskId() {
        return taskId;
    }

    public void setTaskId(java.lang.String taskId) {
        this.taskId = taskId;
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
//Task input for user task 'complete job' in process 'ShortPollHandlerExample'
