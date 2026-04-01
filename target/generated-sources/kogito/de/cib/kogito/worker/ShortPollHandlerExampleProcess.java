package de.cib.kogito.worker;

import de.cib.kogito.worker.ShortPollHandlerExampleModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("ShortPollHandlerExample")
@io.quarkus.runtime.Startup()
public class ShortPollHandlerExampleProcess extends org.kie.kogito.process.impl.AbstractProcess<de.cib.kogito.worker.ShortPollHandlerExampleModel> {

    @jakarta.inject.Inject()
    @jakarta.inject.Named("ComplexServiceExample")
    org.kie.kogito.process.Process<ComplexServiceExampleModel> processComplexServiceExample;

    public ShortPollHandlerExampleProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        this(app, correlations, new org.kie.kogito.handlers.CibSevenFunctions_complete__SPH_CompleteTask_Handler());
    }

    @jakarta.inject.Inject()
    public ShortPollHandlerExampleProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.handlers.CibSevenFunctions_complete__SPH_CompleteTask_Handler cibSevenFunctions_complete__SPH_CompleteTask_Handler) {
        super(app, java.util.Arrays.asList(cibSevenFunctions_complete__SPH_CompleteTask_Handler), correlations);
        activate();
    }

    public ShortPollHandlerExampleProcess() {
    }

    @Override()
    public de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance createInstance(de.cib.kogito.worker.ShortPollHandlerExampleModel value) {
        return new de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance(this, value, this.createProcessRuntime());
    }

    public de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance createInstance(java.lang.String businessKey, de.cib.kogito.worker.ShortPollHandlerExampleModel value) {
        return new de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, de.cib.kogito.worker.ShortPollHandlerExampleModel value) {
        return new de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public de.cib.kogito.worker.ShortPollHandlerExampleModel createModel() {
        return new de.cib.kogito.worker.ShortPollHandlerExampleModel();
    }

    public de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((de.cib.kogito.worker.ShortPollHandlerExampleModel) value);
    }

    public de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (de.cib.kogito.worker.ShortPollHandlerExampleModel) value);
    }

    public de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new de.cib.kogito.worker.ShortPollHandlerExampleProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("ShortPollHandlerExample", true);
        factory.variable("taskId", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("customTags", "internal", "taskId", "taskId", "ItemSubjectRef", "_taskIdItem"));
        factory.variable("outputVariables", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Object.class), java.util.Map.of("customTags", "output", "outputVariables", "outputVariables", "ItemSubjectRef", "_outputVariablesItem"));
        factory.variable("activatedJob", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(de.cib.kogito.worker.cibs.dto.ExternalTaskDto.class), java.util.Map.of("customTags", "input", "activatedJob", "activatedJob", "ItemSubjectRef", "_activatedJobItem"));
        factory.variable("inputVariables", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.util.Map.class), java.util.Map.of("customTags", "input", "inputVariables", "inputVariables", "ItemSubjectRef", "_inputVariablesItem"));
        factory.name("ShortPollHandlerExample");
        factory.packageName("de.cib.kogito.worker");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Private");
        factory.metaData("jbpm.enable.multi.con", null);
        factory.metaData("jbpm.transactions.enable", "true");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_SPH_Start = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_Start"));
        startNode_SPH_Start.name("handle job");
        startNode_SPH_Start.interrupting(true);
        startNode_SPH_Start.metaData("UniqueId", "_SPH_Start");
        startNode_SPH_Start.metaData("elementname", "handle job");
        startNode_SPH_Start.metaData("EventType", "none");
        startNode_SPH_Start.metaData("x", 160);
        startNode_SPH_Start.metaData("width", 56);
        startNode_SPH_Start.metaData("y", 174);
        startNode_SPH_Start.metaData("height", 56);
        startNode_SPH_Start.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_SPH_PrepareVars = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_PrepareVars"));
        actionNode_SPH_PrepareVars.name("prepare Variables");
        actionNode_SPH_PrepareVars.metaData("UniqueId", "_SPH_PrepareVars");
        actionNode_SPH_PrepareVars.metaData("elementname", "prepare Variables");
        actionNode_SPH_PrepareVars.metaData("NodeType", "ScriptTask");
        actionNode_SPH_PrepareVars.metaData("x", 280);
        actionNode_SPH_PrepareVars.metaData("width", 154);
        actionNode_SPH_PrepareVars.metaData("y", 151);
        actionNode_SPH_PrepareVars.metaData("height", 102);
        actionNode_SPH_PrepareVars.action(kcontext -> {
            java.lang.String taskId = (java.lang.String) kcontext.getVariable("taskId");
            de.cib.kogito.worker.cibs.dto.ExternalTaskDto activatedJob = (de.cib.kogito.worker.cibs.dto.ExternalTaskDto) kcontext.getVariable("activatedJob");
            java.util.Map<String, Object> inputVariables = (java.util.Map<String, Object>) kcontext.getVariable("inputVariables");
            kcontext.setVariable("taskId", activatedJob.getId());
            kcontext.setVariable("inputVariables", activatedJob.getVariablesAsMap());
        });
        actionNode_SPH_PrepareVars.done();
        org.jbpm.ruleflow.core.factory.SubProcessNodeFactory<?> subProcessNode_SPH_CallComplexService = factory.subProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_CallComplexService"));
        subProcessNode_SPH_CallComplexService.name("call complex service");
        subProcessNode_SPH_CallComplexService.processId("ComplexServiceExample");
        subProcessNode_SPH_CallComplexService.processName("");
        subProcessNode_SPH_CallComplexService.waitForCompletion(true);
        subProcessNode_SPH_CallComplexService.independent(false);
        subProcessNode_SPH_CallComplexService.subProcessNode(new org.jbpm.workflow.core.node.SubProcessFactory<ComplexServiceExampleModel>() {

            public ComplexServiceExampleModel bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                de.cib.kogito.worker.ComplexServiceExampleModel model = new de.cib.kogito.worker.ComplexServiceExampleModel();
                java.util.Map<java.lang.String, java.lang.Object> inputs = org.jbpm.workflow.core.impl.NodeIoHelper.processInputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
                model.update(inputs);
                return model;
            }

            public org.kie.kogito.process.ProcessInstance<ComplexServiceExampleModel> createInstance(ComplexServiceExampleModel model) {
                return (org.kie.kogito.process.ProcessInstance<ComplexServiceExampleModel>) app.get(org.kie.kogito.process.Processes.class).processById("ComplexServiceExample").createInstance(model);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, ComplexServiceExampleModel model) {
                java.util.Map<java.lang.String, java.lang.Object> outputs = new java.util.HashMap<java.lang.String, java.lang.Object>();
                outputs.put("outputVariables", model.getOutputVariables());
                org.jbpm.workflow.core.impl.NodeIoHelper.processOutputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return outputs.get(name);
                }, (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
            }
        });
        subProcessNode_SPH_CallComplexService.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("inputVariables", "inputVariables", "java.util.Map<String,Object>", null)), new org.jbpm.workflow.core.impl.DataDefinition("_SPH_CA_inputVariablesInputX", "inputVariables", "Object", null), null, null));
        subProcessNode_SPH_CallComplexService.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("taskId", "taskId", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_SPH_CA_taskIdInputX", "taskId", "String", null), null, null));
        subProcessNode_SPH_CallComplexService.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_SPH_CA_outputVariablesOutputX", "outputVariables", "Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("outputVariables", "outputVariables", "java.lang.Object", null), null, null));
        subProcessNode_SPH_CallComplexService.metaData("UniqueId", "_SPH_CallComplexService");
        subProcessNode_SPH_CallComplexService.metaData("elementname", "call complex service");
        subProcessNode_SPH_CallComplexService.metaData("x", 510);
        subProcessNode_SPH_CallComplexService.metaData("width", 154);
        subProcessNode_SPH_CallComplexService.metaData("y", 151);
        subProcessNode_SPH_CallComplexService.metaData("height", 102);
        subProcessNode_SPH_CallComplexService.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_SPH_CompleteTask = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_CompleteTask"));
        workItemNode_SPH_CompleteTask.name("complete job");
        workItemNode_SPH_CompleteTask.workName("de.cib.kogito.worker.cibs.CibSevenFunctions_complete__SPH_CompleteTask_Handler");
        workItemNode_SPH_CompleteTask.workParameter("Interface", "de.cib.kogito.worker.cibs.CibSevenFunctions");
        workItemNode_SPH_CompleteTask.workParameter("NodeName", "complete job");
        workItemNode_SPH_CompleteTask.workParameter("Operation", "complete");
        workItemNode_SPH_CompleteTask.workParameter("UNIQUE_TASK_ID", "_SPH_CompleteTask");
        workItemNode_SPH_CompleteTask.workParameter("implementation", "Java");
        workItemNode_SPH_CompleteTask.workParameter("interfaceImplementationRef", "de.cib.kogito.worker.cibs.CibSevenFunctions");
        workItemNode_SPH_CompleteTask.workParameter("operationImplementationRef", "complete");
        workItemNode_SPH_CompleteTask.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("taskId", "taskId", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_SPH_taskIdInputX", "taskId", "String", null), null, null));
        workItemNode_SPH_CompleteTask.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("outputVariables", "outputVariables", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_SPH_variablesInputX", "variables", "Object", null), null, null));
        workItemNode_SPH_CompleteTask.done();
        workItemNode_SPH_CompleteTask.metaData("UniqueId", "_SPH_CompleteTask");
        workItemNode_SPH_CompleteTask.metaData("Implementation", "Java");
        workItemNode_SPH_CompleteTask.metaData("elementname", "complete job");
        workItemNode_SPH_CompleteTask.metaData("Type", "Service Task");
        workItemNode_SPH_CompleteTask.metaData("OperationRef", "_SPH_ServiceOperation");
        workItemNode_SPH_CompleteTask.metaData("x", 740);
        workItemNode_SPH_CompleteTask.metaData("width", 154);
        workItemNode_SPH_CompleteTask.metaData("y", 151);
        workItemNode_SPH_CompleteTask.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_SPH_End = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_End"));
        endNode_SPH_End.name("job handled");
        endNode_SPH_End.terminate(false);
        endNode_SPH_End.metaData("UniqueId", "_SPH_End");
        endNode_SPH_End.metaData("elementname", "job handled");
        endNode_SPH_End.metaData("x", 970);
        endNode_SPH_End.metaData("width", 56);
        endNode_SPH_End.metaData("y", 174);
        endNode_SPH_End.metaData("height", 56);
        endNode_SPH_End.done();
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_Start"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_PrepareVars"), "_SPH_SF_0");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_PrepareVars"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_CallComplexService"), "_SPH_SF_1");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_CallComplexService"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_CompleteTask"), "_SPH_SF_2");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_CompleteTask"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPH_End"), "_SPH_SF_3");
        factory.validate();
        return factory.getProcess();
    }

    protected void registerListeners() {
        services.getSignalManager().addEventListener("ComplexServiceExample", completionEventListener);
    }
}
