package org.kie.kogito.handlers;

import org.kie.kogito.internal.process.workitem.WorkItemExecutionException;

@jakarta.enterprise.context.ApplicationScoped()
public class ServiceExample_doSomething__CSE_ServiceTask_Handler extends org.kie.kogito.process.workitems.impl.DefaultKogitoWorkItemHandler {

    de.cib.kogito.worker.service.ServiceExample service;

    public ServiceExample_doSomething__CSE_ServiceTask_Handler() {
        this(new de.cib.kogito.worker.service.ServiceExample());
    }

    @jakarta.inject.Inject()
    public ServiceExample_doSomething__CSE_ServiceTask_Handler(de.cib.kogito.worker.service.ServiceExample service) {
        this.service = service;
    }

    public java.util.Optional<org.kie.kogito.internal.process.workitem.WorkItemTransition> activateWorkItemHandler(org.kie.kogito.internal.process.workitem.KogitoWorkItemManager workItemManager, org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler workItemHandler, org.kie.kogito.internal.process.workitem.KogitoWorkItem workItem, org.kie.kogito.internal.process.workitem.WorkItemTransition transition) {
        java.util.Map<java.lang.String, java.lang.Object> result;
        result = java.util.Collections.singletonMap("variables", service.doSomething((java.util.Map) workItem.getParameter("inputVariablesJavaObject")));
        return java.util.Optional.of(this.workItemLifeCycle.newTransition("complete", workItem.getPhaseStatus(), result));
    }

    public java.util.Optional<org.kie.kogito.internal.process.workitem.WorkItemTransition> abortWorkItemHandler(org.kie.kogito.internal.process.workitem.KogitoWorkItemManager workItemManager, org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler workItemHandler, org.kie.kogito.internal.process.workitem.KogitoWorkItem workItem, org.kie.kogito.internal.process.workitem.WorkItemTransition transition) {
        return java.util.Optional.empty();
    }

    public String getName() {
        return "de.cib.kogito.worker.service.ServiceExample_doSomething__CSE_ServiceTask_Handler";
    }
}
