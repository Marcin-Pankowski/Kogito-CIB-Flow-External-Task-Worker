package org.kie.kogito.handlers;

import org.kie.kogito.internal.process.workitem.WorkItemExecutionException;

@jakarta.enterprise.context.ApplicationScoped()
public class CibSevenFunctions_complete__SPH_CompleteTask_Handler extends org.kie.kogito.process.workitems.impl.DefaultKogitoWorkItemHandler {

    de.cib.kogito.worker.cibs.CibSevenFunctions service;

    public CibSevenFunctions_complete__SPH_CompleteTask_Handler() {
        this(new de.cib.kogito.worker.cibs.CibSevenFunctions());
    }

    @jakarta.inject.Inject()
    public CibSevenFunctions_complete__SPH_CompleteTask_Handler(de.cib.kogito.worker.cibs.CibSevenFunctions service) {
        this.service = service;
    }

    public java.util.Optional<org.kie.kogito.internal.process.workitem.WorkItemTransition> activateWorkItemHandler(org.kie.kogito.internal.process.workitem.KogitoWorkItemManager workItemManager, org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler workItemHandler, org.kie.kogito.internal.process.workitem.KogitoWorkItem workItem, org.kie.kogito.internal.process.workitem.WorkItemTransition transition) {
        java.util.Map<java.lang.String, java.lang.Object> result;
        service.complete((java.lang.String) workItem.getParameter("taskId"), (java.lang.Object) workItem.getParameter("variables"));
        result = java.util.Collections.emptyMap();
        return java.util.Optional.of(this.workItemLifeCycle.newTransition("complete", workItem.getPhaseStatus(), result));
    }

    public java.util.Optional<org.kie.kogito.internal.process.workitem.WorkItemTransition> abortWorkItemHandler(org.kie.kogito.internal.process.workitem.KogitoWorkItemManager workItemManager, org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler workItemHandler, org.kie.kogito.internal.process.workitem.KogitoWorkItem workItem, org.kie.kogito.internal.process.workitem.WorkItemTransition transition) {
        return java.util.Optional.empty();
    }

    public String getName() {
        return "de.cib.kogito.worker.cibs.CibSevenFunctions_complete__SPH_CompleteTask_Handler";
    }
}
