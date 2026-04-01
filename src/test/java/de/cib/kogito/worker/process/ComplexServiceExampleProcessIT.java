/*
 * Copyright Marcin Pankowski
 * Behamstrasse 8
 * 80687
 * www.piu.de
 */
package de.cib.kogito.worker.process;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.kie.kogito.process.Processes;

import jakarta.inject.Inject;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration test for the ComplexServiceExample process.
 *
 * Starts the process with sample inputVariables and asserts that:
 *  - the process completes
 *  - outputVariables contains the expected resultText
 */
@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ComplexServiceExampleProcessIT {

    @Inject
    Processes processes;

    @Test
    public void processCompletesSuccessfully() {
        var process = processes.processById("ComplexServiceExample");
        var model = process.createModel();

        Map<String, Object> inputVariables = new HashMap<>();
        inputVariables.put("variableA", "Kogito");
        inputVariables.put("variableB", "rocks");

        Map<String, Object> processVariables = new HashMap<>();
        processVariables.put("inputVariables", inputVariables);
        processVariables.put("taskId", "test-task-001");

        model.fromMap(processVariables);

        var processInstance = process.createInstance(model);
        processInstance.start();

        assertThat(processInstance.status())
                .isEqualTo(org.kie.api.runtime.process.ProcessInstance.STATE_COMPLETED);
    }

    @Test
    public void outputVariablesContainResultText() {
        var process = processes.processById("ComplexServiceExample");
        var model = process.createModel();

        Map<String, Object> inputVariables = new HashMap<>();
        inputVariables.put("variableA", "Kogito");
        inputVariables.put("variableB", "rocks");

        Map<String, Object> processVariables = new HashMap<>();
        processVariables.put("inputVariables", inputVariables);
        processVariables.put("taskId", "test-task-002");

        model.fromMap(processVariables);

        var processInstance = process.createInstance(model);
        processInstance.start();

        @SuppressWarnings("unchecked")
        var outputVariables = (Map<String, Object>) processInstance.variables().toMap().get("outputVariables");
        assertThat(outputVariables).isNotNull();
        assertThat(outputVariables.get("resultText").toString())
                .contains("Kogito")
                .contains("rocks")
                .contains("the World!");
    }
}
