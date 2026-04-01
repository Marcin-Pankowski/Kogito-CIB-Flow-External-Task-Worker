package de.cib.kogito.worker;

import de.cib.kogito.worker.ComplexServiceExampleModel;

public class ComplexServiceExampleProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<ComplexServiceExampleModel> {

    public ComplexServiceExampleProcessInstance(de.cib.kogito.worker.ComplexServiceExampleProcess process, ComplexServiceExampleModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public ComplexServiceExampleProcessInstance(de.cib.kogito.worker.ComplexServiceExampleProcess process, ComplexServiceExampleModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public ComplexServiceExampleProcessInstance(de.cib.kogito.worker.ComplexServiceExampleProcess process, ComplexServiceExampleModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public ComplexServiceExampleProcessInstance(de.cib.kogito.worker.ComplexServiceExampleProcess process, ComplexServiceExampleModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public ComplexServiceExampleProcessInstance(de.cib.kogito.worker.ComplexServiceExampleProcess process, ComplexServiceExampleModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(ComplexServiceExampleModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(ComplexServiceExampleModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
