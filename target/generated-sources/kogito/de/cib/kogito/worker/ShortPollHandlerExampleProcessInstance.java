package de.cib.kogito.worker;

import de.cib.kogito.worker.ShortPollHandlerExampleModel;

public class ShortPollHandlerExampleProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<ShortPollHandlerExampleModel> {

    public ShortPollHandlerExampleProcessInstance(de.cib.kogito.worker.ShortPollHandlerExampleProcess process, ShortPollHandlerExampleModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public ShortPollHandlerExampleProcessInstance(de.cib.kogito.worker.ShortPollHandlerExampleProcess process, ShortPollHandlerExampleModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public ShortPollHandlerExampleProcessInstance(de.cib.kogito.worker.ShortPollHandlerExampleProcess process, ShortPollHandlerExampleModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public ShortPollHandlerExampleProcessInstance(de.cib.kogito.worker.ShortPollHandlerExampleProcess process, ShortPollHandlerExampleModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public ShortPollHandlerExampleProcessInstance(de.cib.kogito.worker.ShortPollHandlerExampleProcess process, ShortPollHandlerExampleModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(ShortPollHandlerExampleModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(ShortPollHandlerExampleModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
