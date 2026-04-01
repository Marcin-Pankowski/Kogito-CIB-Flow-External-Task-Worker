package org.kie.kogito.handlers;

import org.kie.kogito.internal.process.workitem.WorkItemExecutionException;

@jakarta.enterprise.context.ApplicationScoped()
public class CibSevenFunctions_fetchAndLock__SPW_FetchAndLockTask_Handler extends org.kie.kogito.process.workitems.impl.DefaultKogitoWorkItemHandler {

    de.cib.kogito.worker.cibs.CibSevenFunctions service;

    public CibSevenFunctions_fetchAndLock__SPW_FetchAndLockTask_Handler() {
        this(new de.cib.kogito.worker.cibs.CibSevenFunctions());
    }

    @jakarta.inject.Inject()
    public CibSevenFunctions_fetchAndLock__SPW_FetchAndLockTask_Handler(de.cib.kogito.worker.cibs.CibSevenFunctions service) {
        this.service = service;
    }

    public java.util.Optional<org.kie.kogito.internal.process.workitem.WorkItemTransition> activateWorkItemHandler(org.kie.kogito.internal.process.workitem.KogitoWorkItemManager workItemManager, org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler workItemHandler, org.kie.kogito.internal.process.workitem.KogitoWorkItem workItem, org.kie.kogito.internal.process.workitem.WorkItemTransition transition) {
        java.util.Map<java.lang.String, java.lang.Object> result;
        result = java.util.Collections.singletonMap("activatedJobs", service.fetchAndLock((java.lang.String) workItem.getParameter("topicName"), (java.lang.String) workItem.getParameter("workerName"), (java.lang.Integer) workItem.getParameter("maxJobsToActivate"), (java.lang.Integer) workItem.getParameter("lockDurationMinutes")));
        return java.util.Optional.of(this.workItemLifeCycle.newTransition("complete", workItem.getPhaseStatus(), result));
    }

    public java.util.Optional<org.kie.kogito.internal.process.workitem.WorkItemTransition> abortWorkItemHandler(org.kie.kogito.internal.process.workitem.KogitoWorkItemManager workItemManager, org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler workItemHandler, org.kie.kogito.internal.process.workitem.KogitoWorkItem workItem, org.kie.kogito.internal.process.workitem.WorkItemTransition transition) {
        return java.util.Optional.empty();
    }

    public String getName() {
        return "de.cib.kogito.worker.cibs.CibSevenFunctions_fetchAndLock__SPW_FetchAndLockTask_Handler";
    }
}
