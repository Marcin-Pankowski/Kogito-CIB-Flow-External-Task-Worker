package de.cib.kogito.worker;

import de.cib.kogito.worker.ShortPollWorkerExampleModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("ShortPollWorkerExample")
@io.quarkus.runtime.Startup()
public class ShortPollWorkerExampleProcess extends org.kie.kogito.process.impl.AbstractProcess<de.cib.kogito.worker.ShortPollWorkerExampleModel> {

    @jakarta.inject.Inject()
    @jakarta.inject.Named("ShortPollHandlerExample")
    org.kie.kogito.process.Process<ShortPollHandlerExampleModel> processShortPollHandlerExample;

    public ShortPollWorkerExampleProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        this(app, correlations, new org.kie.kogito.handlers.CibSevenFunctions_fetchAndLock__SPW_FetchAndLockTask_Handler());
    }

    @jakarta.inject.Inject()
    public ShortPollWorkerExampleProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.handlers.CibSevenFunctions_fetchAndLock__SPW_FetchAndLockTask_Handler cibSevenFunctions_fetchAndLock__SPW_FetchAndLockTask_Handler) {
        super(app, java.util.Arrays.asList(cibSevenFunctions_fetchAndLock__SPW_FetchAndLockTask_Handler), correlations);
        activate();
    }

    public ShortPollWorkerExampleProcess() {
    }

    @Override()
    public de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance createInstance(de.cib.kogito.worker.ShortPollWorkerExampleModel value) {
        return new de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance(this, value, this.createProcessRuntime());
    }

    public de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance createInstance(java.lang.String businessKey, de.cib.kogito.worker.ShortPollWorkerExampleModel value) {
        return new de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, de.cib.kogito.worker.ShortPollWorkerExampleModel value) {
        return new de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public de.cib.kogito.worker.ShortPollWorkerExampleModel createModel() {
        return new de.cib.kogito.worker.ShortPollWorkerExampleModel();
    }

    public de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((de.cib.kogito.worker.ShortPollWorkerExampleModel) value);
    }

    public de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (de.cib.kogito.worker.ShortPollWorkerExampleModel) value);
    }

    public de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new de.cib.kogito.worker.ShortPollWorkerExampleProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("ShortPollWorkerExample", true);
        factory.variable("activatedJobs", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.util.List.class), java.util.Map.of("activatedJobs", "activatedJobs", "customTags", "internal", "ItemSubjectRef", "_activatedJobsItem"));
        factory.name("ShortPollWorkerExample");
        factory.packageName("de.cib.kogito.worker");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Private");
        factory.metaData("jbpm.enable.multi.con", null);
        factory.metaData("jbpm.transactions.enable", "true");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_SPW_TimerStart = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_TimerStart"));
        startNode_SPW_TimerStart.name("poll every 5 seconds");
        startNode_SPW_TimerStart.interrupting(true);
        startNode_SPW_TimerStart.metaData("UniqueId", "_SPW_TimerStart");
        startNode_SPW_TimerStart.metaData("elementname", "poll every 5 seconds");
        startNode_SPW_TimerStart.metaData("EventType", "Timer");
        startNode_SPW_TimerStart.metaData("x", 160);
        startNode_SPW_TimerStart.metaData("width", 56);
        startNode_SPW_TimerStart.metaData("y", 217);
        startNode_SPW_TimerStart.metaData("height", 56);
        startNode_SPW_TimerStart.timer("R/PT5S", "R/PT5S", null, 2);
        startNode_SPW_TimerStart.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_SPW_FetchAndLockTask = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_FetchAndLockTask"));
        workItemNode_SPW_FetchAndLockTask.name("Fetch CIB Seven External Tasks");
        workItemNode_SPW_FetchAndLockTask.workName("de.cib.kogito.worker.cibs.CibSevenFunctions_fetchAndLock__SPW_FetchAndLockTask_Handler");
        workItemNode_SPW_FetchAndLockTask.workParameter("Interface", "de.cib.kogito.worker.cibs.CibSevenFunctions");
        workItemNode_SPW_FetchAndLockTask.workParameter("NodeName", "Fetch CIB Seven External Tasks");
        workItemNode_SPW_FetchAndLockTask.workParameter("Operation", "fetchAndLock");
        workItemNode_SPW_FetchAndLockTask.workParameter("UNIQUE_TASK_ID", "_SPW_FetchAndLockTask");
        workItemNode_SPW_FetchAndLockTask.workParameter("implementation", "Java");
        workItemNode_SPW_FetchAndLockTask.workParameter("interfaceImplementationRef", "de.cib.kogito.worker.cibs.CibSevenFunctions");
        workItemNode_SPW_FetchAndLockTask.workParameter("operationImplementationRef", "fetchAndLock");
        workItemNode_SPW_FetchAndLockTask.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_SPW_topicNameInputX", "topicName", "String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("1401436c-612f-44d0-8253-c706bcf920a1", "EXPRESSION (demo-topic)", "java.lang.Object", "demo-topic"), new org.jbpm.workflow.core.impl.DataDefinition("_SPW_topicNameInputX", "topicName", "String", null))), null));
        workItemNode_SPW_FetchAndLockTask.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_SPW_workerNameInputX", "workerName", "String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("c0df2a25-663e-43fb-a789-2b7c9b61939b", "EXPRESSION (kogito-cib-worker)", "java.lang.Object", "kogito-cib-worker"), new org.jbpm.workflow.core.impl.DataDefinition("_SPW_workerNameInputX", "workerName", "String", null))), null));
        workItemNode_SPW_FetchAndLockTask.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_SPW_maxJobsToActivateInputX", "maxJobsToActivate", "Integer", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("777d5080-4fbd-48b4-b661-a538f60ee1af", "EXPRESSION (10)", "java.lang.Object", "10"), new org.jbpm.workflow.core.impl.DataDefinition("_SPW_maxJobsToActivateInputX", "maxJobsToActivate", "Integer", null))), null));
        workItemNode_SPW_FetchAndLockTask.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_SPW_lockDurationMinutesInputX", "lockDurationMinutes", "Integer", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("1f4bf190-1cc3-4235-98e2-f628495cdb0a", "EXPRESSION (1)", "java.lang.Object", "1"), new org.jbpm.workflow.core.impl.DataDefinition("_SPW_lockDurationMinutesInputX", "lockDurationMinutes", "Integer", null))), null));
        workItemNode_SPW_FetchAndLockTask.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_SPW_activatedJobsOutputX", "activatedJobs", "Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("activatedJobs", "activatedJobs", "java.util.List<de.cib.kogito.worker.cibs.dto.ExternalTaskDto>", null), null, null));
        workItemNode_SPW_FetchAndLockTask.done();
        workItemNode_SPW_FetchAndLockTask.metaData("UniqueId", "_SPW_FetchAndLockTask");
        workItemNode_SPW_FetchAndLockTask.metaData("Implementation", "Java");
        workItemNode_SPW_FetchAndLockTask.metaData("elementname", "Fetch CIB Seven External Tasks");
        workItemNode_SPW_FetchAndLockTask.metaData("Type", "Service Task");
        workItemNode_SPW_FetchAndLockTask.metaData("OperationRef", "_SPW_ServiceOperation");
        workItemNode_SPW_FetchAndLockTask.metaData("x", 280);
        workItemNode_SPW_FetchAndLockTask.metaData("width", 154);
        workItemNode_SPW_FetchAndLockTask.metaData("y", 194);
        workItemNode_SPW_FetchAndLockTask.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_SPW_Gateway = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_Gateway"));
        splitNode_SPW_Gateway.name("Split");
        splitNode_SPW_Gateway.type(2);
        splitNode_SPW_Gateway.metaData("UniqueId", "_SPW_Gateway");
        splitNode_SPW_Gateway.metaData("x", 510);
        splitNode_SPW_Gateway.metaData("width", 56);
        splitNode_SPW_Gateway.metaData("y", 217);
        splitNode_SPW_Gateway.metaData("Default", "_SPW_SF_NoJobs");
        splitNode_SPW_Gateway.metaData("height", 56);
        splitNode_SPW_Gateway.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_CallActivity"), "_SPW_SF_HasJobs", "DROOLS_DEFAULT", "java", kcontext -> {
            java.util.List<de.cib.kogito.worker.cibs.dto.ExternalTaskDto> activatedJobs = (java.util.List<de.cib.kogito.worker.cibs.dto.ExternalTaskDto>) kcontext.getVariable("activatedJobs");
            return activatedJobs.size() > 0;
        }, 0, false);
        splitNode_SPW_Gateway.done();
        splitNode_SPW_Gateway.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_CallActivity"), "_SPW_SF_HasJobs", "DROOLS_DEFAULT", "java", kcontext -> {
            java.util.List<de.cib.kogito.worker.cibs.dto.ExternalTaskDto> activatedJobs = (java.util.List<de.cib.kogito.worker.cibs.dto.ExternalTaskDto>) kcontext.getVariable("activatedJobs");
            return activatedJobs.size() > 0;
        }, 0, false);
        org.jbpm.ruleflow.core.factory.ForEachNodeFactory<?> forEachNode_SPW_CallActivity = factory.forEachNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_CallActivity"));
        forEachNode_SPW_CallActivity.name("JobHandler");
        forEachNode_SPW_CallActivity.sequential(false);
        forEachNode_SPW_CallActivity.metaData("UniqueId", "_SPW_CallActivity");
        forEachNode_SPW_CallActivity.metaData("x", 640);
        forEachNode_SPW_CallActivity.metaData("width", 154);
        forEachNode_SPW_CallActivity.metaData("y", 194);
        forEachNode_SPW_CallActivity.metaData("height", 102);
        forEachNode_SPW_CallActivity.tempVariable("foreach_output", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.util.Collection.class));
        forEachNode_SPW_CallActivity.variable("activatedJob", "activatedJob", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(Object.class));
        forEachNode_SPW_CallActivity.collectionExpression("activatedJobs");
        org.jbpm.ruleflow.core.factory.SubProcessNodeFactory<?> subProcessNode_SPW_CallActivity_1 = forEachNode_SPW_CallActivity.subProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_CallActivity_1"));
        subProcessNode_SPW_CallActivity_1.name("JobHandler");
        subProcessNode_SPW_CallActivity_1.processId("ShortPollHandlerExample");
        subProcessNode_SPW_CallActivity_1.processName("");
        subProcessNode_SPW_CallActivity_1.waitForCompletion(true);
        subProcessNode_SPW_CallActivity_1.independent(false);
        subProcessNode_SPW_CallActivity_1.subProcessNode(new org.jbpm.workflow.core.node.SubProcessFactory<ShortPollHandlerExampleModel>() {

            public ShortPollHandlerExampleModel bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                de.cib.kogito.worker.ShortPollHandlerExampleModel model = new de.cib.kogito.worker.ShortPollHandlerExampleModel();
                java.util.Map<java.lang.String, java.lang.Object> inputs = org.jbpm.workflow.core.impl.NodeIoHelper.processInputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
                model.update(inputs);
                return model;
            }

            public org.kie.kogito.process.ProcessInstance<ShortPollHandlerExampleModel> createInstance(ShortPollHandlerExampleModel model) {
                return (org.kie.kogito.process.ProcessInstance<ShortPollHandlerExampleModel>) app.get(org.kie.kogito.process.Processes.class).processById("ShortPollHandlerExample").createInstance(model);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, ShortPollHandlerExampleModel model) {
                java.util.Map<java.lang.String, java.lang.Object> outputs = new java.util.HashMap<java.lang.String, java.lang.Object>();
                org.jbpm.workflow.core.impl.NodeIoHelper.processOutputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return outputs.get(name);
                }, (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
            }
        });
        subProcessNode_SPW_CallActivity_1.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("activatedJobs", "activatedJobs", "java.util.List<de.cib.kogito.worker.cibs.dto.ExternalTaskDto>", null)), new org.jbpm.workflow.core.impl.DataDefinition("_SPW_CA_IN_COLLECTIONInputX", "IN_COLLECTION", "java.util.List<de.cib.kogito.worker.cibs.dto.ExternalTaskDto>", null), null, null));
        subProcessNode_SPW_CallActivity_1.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("activatedJob", "activatedJob", "Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_SPW_CA_activatedJobInputX", "activatedJob", "Object", null), null, null));
        subProcessNode_SPW_CallActivity_1.metaData("UniqueId", "_SPW_CallActivity");
        subProcessNode_SPW_CallActivity_1.metaData("elementname", "JobHandler");
        subProcessNode_SPW_CallActivity_1.metaData("hidden", true);
        subProcessNode_SPW_CallActivity_1.metaData("MICollectionInput", "IN_COLLECTION");
        subProcessNode_SPW_CallActivity_1.done();
        forEachNode_SPW_CallActivity.linkIncomingConnections(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_CallActivity_1"));
        forEachNode_SPW_CallActivity.linkOutgoingConnections(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_CallActivity_1"));
        forEachNode_SPW_CallActivity.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_SPW_EndNoJobs = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_EndNoJobs"));
        endNode_SPW_EndNoJobs.name("no jobs to handle");
        endNode_SPW_EndNoJobs.terminate(false);
        endNode_SPW_EndNoJobs.metaData("UniqueId", "_SPW_EndNoJobs");
        endNode_SPW_EndNoJobs.metaData("elementname", "no jobs to handle");
        endNode_SPW_EndNoJobs.metaData("x", 640);
        endNode_SPW_EndNoJobs.metaData("width", 56);
        endNode_SPW_EndNoJobs.metaData("y", 370);
        endNode_SPW_EndNoJobs.metaData("height", 56);
        endNode_SPW_EndNoJobs.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_SPW_EndAllHandled = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_EndAllHandled"));
        endNode_SPW_EndAllHandled.name("all jobs handled");
        endNode_SPW_EndAllHandled.terminate(false);
        endNode_SPW_EndAllHandled.metaData("UniqueId", "_SPW_EndAllHandled");
        endNode_SPW_EndAllHandled.metaData("elementname", "all jobs handled");
        endNode_SPW_EndAllHandled.metaData("x", 870);
        endNode_SPW_EndAllHandled.metaData("width", 56);
        endNode_SPW_EndAllHandled.metaData("y", 217);
        endNode_SPW_EndAllHandled.metaData("height", 56);
        endNode_SPW_EndAllHandled.done();
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_TimerStart"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_FetchAndLockTask"), "_SPW_SF_0");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_FetchAndLockTask"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_Gateway"), "_SPW_SF_1");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_Gateway"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_CallActivity"), "_SPW_SF_HasJobs");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_Gateway"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_EndNoJobs"), "_SPW_SF_NoJobs");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_CallActivity"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_SPW_EndAllHandled"), "_SPW_SF_2");
        factory.validate();
        return factory.getProcess();
    }

    protected void registerListeners() {
        services.getSignalManager().addEventListener("ShortPollHandlerExample", completionEventListener);
    }
}
