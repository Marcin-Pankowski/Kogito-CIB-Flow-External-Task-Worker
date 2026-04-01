package de.cib.kogito.worker;

import de.cib.kogito.worker.ComplexServiceExampleModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("ComplexServiceExample")
@io.quarkus.runtime.Startup()
public class ComplexServiceExampleProcess extends org.kie.kogito.process.impl.AbstractProcess<de.cib.kogito.worker.ComplexServiceExampleModel> {

    public ComplexServiceExampleProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        this(app, correlations, new org.kie.kogito.handlers.ServiceExample_doSomething__CSE_ServiceTask_Handler());
    }

    @jakarta.inject.Inject()
    public ComplexServiceExampleProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.handlers.ServiceExample_doSomething__CSE_ServiceTask_Handler serviceExample_doSomething__CSE_ServiceTask_Handler) {
        super(app, java.util.Arrays.asList(serviceExample_doSomething__CSE_ServiceTask_Handler), correlations);
        activate();
    }

    public ComplexServiceExampleProcess() {
    }

    @Override()
    public de.cib.kogito.worker.ComplexServiceExampleProcessInstance createInstance(de.cib.kogito.worker.ComplexServiceExampleModel value) {
        return new de.cib.kogito.worker.ComplexServiceExampleProcessInstance(this, value, this.createProcessRuntime());
    }

    public de.cib.kogito.worker.ComplexServiceExampleProcessInstance createInstance(java.lang.String businessKey, de.cib.kogito.worker.ComplexServiceExampleModel value) {
        return new de.cib.kogito.worker.ComplexServiceExampleProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public de.cib.kogito.worker.ComplexServiceExampleProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, de.cib.kogito.worker.ComplexServiceExampleModel value) {
        return new de.cib.kogito.worker.ComplexServiceExampleProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public de.cib.kogito.worker.ComplexServiceExampleModel createModel() {
        return new de.cib.kogito.worker.ComplexServiceExampleModel();
    }

    public de.cib.kogito.worker.ComplexServiceExampleProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((de.cib.kogito.worker.ComplexServiceExampleModel) value);
    }

    public de.cib.kogito.worker.ComplexServiceExampleProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (de.cib.kogito.worker.ComplexServiceExampleModel) value);
    }

    public de.cib.kogito.worker.ComplexServiceExampleProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new de.cib.kogito.worker.ComplexServiceExampleProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public de.cib.kogito.worker.ComplexServiceExampleProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new de.cib.kogito.worker.ComplexServiceExampleProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("ComplexServiceExample", true);
        factory.variable("externalTask", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(de.cib.kogito.worker.cibs.dto.ExternalTaskDto.class), java.util.Map.of("customTags", "input", "externalTask", "externalTask", "ItemSubjectRef", "_externalTaskItem"));
        factory.variable("inputVariables", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.util.Map.class), java.util.Map.of("customTags", "input", "inputVariables", "inputVariables", "ItemSubjectRef", "_inputVariablesItem"));
        factory.variable("taskId", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("customTags", "input", "taskId", "taskId", "ItemSubjectRef", "_taskIdItem"));
        factory.variable("outputVariables", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.util.Map.class), java.util.Map.of("customTags", "output", "outputVariables", "outputVariables", "ItemSubjectRef", "_outputVariablesItem"));
        factory.name("ComplexServiceExample");
        factory.packageName("de.cib.kogito.worker");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("jbpm.enable.multi.con", null);
        factory.metaData("jbpm.transactions.enable", "true");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_CSE_Start = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CSE_Start"));
        startNode_CSE_Start.name("Service Start");
        startNode_CSE_Start.interrupting(true);
        startNode_CSE_Start.metaData("UniqueId", "_CSE_Start");
        startNode_CSE_Start.metaData("elementname", "Service Start");
        startNode_CSE_Start.metaData("EventType", "none");
        startNode_CSE_Start.metaData("x", 158);
        startNode_CSE_Start.metaData("width", 56);
        startNode_CSE_Start.metaData("y", 101);
        startNode_CSE_Start.metaData("height", 56);
        startNode_CSE_Start.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_CSE_ScriptTask = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CSE_ScriptTask"));
        actionNode_CSE_ScriptTask.name("log inputs");
        actionNode_CSE_ScriptTask.metaData("UniqueId", "_CSE_ScriptTask");
        actionNode_CSE_ScriptTask.metaData("elementname", "log inputs");
        actionNode_CSE_ScriptTask.metaData("NodeType", "ScriptTask");
        actionNode_CSE_ScriptTask.metaData("x", 280);
        actionNode_CSE_ScriptTask.metaData("width", 154);
        actionNode_CSE_ScriptTask.metaData("y", 78);
        actionNode_CSE_ScriptTask.metaData("height", 102);
        actionNode_CSE_ScriptTask.action(kcontext -> {
            java.util.Map<String, Object> inputVariables = (java.util.Map<String, Object>) kcontext.getVariable("inputVariables");
            java.lang.String taskId = (java.lang.String) kcontext.getVariable("taskId");
            System.out.println("inputVariables: " + inputVariables);
            System.out.println("taskId: " + taskId);
        });
        actionNode_CSE_ScriptTask.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_CSE_ServiceTask = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CSE_ServiceTask"));
        workItemNode_CSE_ServiceTask.name("do something with a service");
        workItemNode_CSE_ServiceTask.workName("de.cib.kogito.worker.service.ServiceExample_doSomething__CSE_ServiceTask_Handler");
        workItemNode_CSE_ServiceTask.workParameter("Interface", "de.cib.kogito.worker.service.ServiceExample");
        workItemNode_CSE_ServiceTask.workParameter("NodeName", "do something with a service");
        workItemNode_CSE_ServiceTask.workParameter("Operation", "doSomething");
        workItemNode_CSE_ServiceTask.workParameter("UNIQUE_TASK_ID", "_CSE_ServiceTask");
        workItemNode_CSE_ServiceTask.workParameter("implementation", "Java");
        workItemNode_CSE_ServiceTask.workParameter("interfaceImplementationRef", "de.cib.kogito.worker.service.ServiceExample");
        workItemNode_CSE_ServiceTask.workParameter("operationImplementationRef", "doSomething");
        workItemNode_CSE_ServiceTask.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("inputVariables", "inputVariables", "java.util.Map<String,Object>", null)), new org.jbpm.workflow.core.impl.DataDefinition("_CSE_ServiceTask_inputX", "inputVariablesJavaObject", "Object", null), null, null));
        workItemNode_CSE_ServiceTask.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_CSE_ServiceTask_outputX", "variables", "java.util.Map<String,Object>", null)), new org.jbpm.workflow.core.impl.DataDefinition("outputVariables", "outputVariables", "java.util.Map<String,Object>", null), null, null));
        workItemNode_CSE_ServiceTask.done();
        workItemNode_CSE_ServiceTask.metaData("UniqueId", "_CSE_ServiceTask");
        workItemNode_CSE_ServiceTask.metaData("Implementation", "Java");
        workItemNode_CSE_ServiceTask.metaData("elementname", "do something with a service");
        workItemNode_CSE_ServiceTask.metaData("Type", "Service Task");
        workItemNode_CSE_ServiceTask.metaData("OperationRef", "_CSE_ServiceOperation");
        workItemNode_CSE_ServiceTask.metaData("x", 510);
        workItemNode_CSE_ServiceTask.metaData("width", 154);
        workItemNode_CSE_ServiceTask.metaData("y", 78);
        workItemNode_CSE_ServiceTask.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_CSE_End = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CSE_End"));
        endNode_CSE_End.name("Service fulfilled");
        endNode_CSE_End.terminate(false);
        endNode_CSE_End.metaData("UniqueId", "_CSE_End");
        endNode_CSE_End.metaData("elementname", "Service fulfilled");
        endNode_CSE_End.metaData("x", 740);
        endNode_CSE_End.metaData("width", 56);
        endNode_CSE_End.metaData("y", 101);
        endNode_CSE_End.metaData("height", 56);
        endNode_CSE_End.done();
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CSE_Start"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CSE_ScriptTask"), "Flow_CSE_0");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CSE_ScriptTask"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CSE_ServiceTask"), "Flow_CSE_1");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CSE_ServiceTask"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CSE_End"), "Flow_CSE_2");
        factory.validate();
        return factory.getProcess();
    }
}
