package de.cib.kogito.worker;

import de.cib.kogito.worker.ShortPollWorkerExampleModel;

public class ShortPollWorkerExampleProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<ShortPollWorkerExampleModel> {

    public ShortPollWorkerExampleProcessInstance(de.cib.kogito.worker.ShortPollWorkerExampleProcess process, ShortPollWorkerExampleModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public ShortPollWorkerExampleProcessInstance(de.cib.kogito.worker.ShortPollWorkerExampleProcess process, ShortPollWorkerExampleModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public ShortPollWorkerExampleProcessInstance(de.cib.kogito.worker.ShortPollWorkerExampleProcess process, ShortPollWorkerExampleModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public ShortPollWorkerExampleProcessInstance(de.cib.kogito.worker.ShortPollWorkerExampleProcess process, ShortPollWorkerExampleModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public ShortPollWorkerExampleProcessInstance(de.cib.kogito.worker.ShortPollWorkerExampleProcess process, ShortPollWorkerExampleModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(ShortPollWorkerExampleModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(ShortPollWorkerExampleModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
