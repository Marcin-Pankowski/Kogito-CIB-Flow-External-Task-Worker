/*
 * Copyright Marcin Pankowski
 * Behamstrasse 8
 * 80687
 * www.piu.de
 */
package de.cib.kogito.worker.service;

import jakarta.inject.Singleton;
import java.util.Map;

/**
 * Demo business-logic service.
 *
 * Called from the ComplexServiceExample BPMN process via a Kogito service task.
 * Replace the body of doSomething() with real work.
 */
@Singleton
public class ServiceExample {

    public Map<String, Object> doSomething(Map<String, Object> inputVariablesJavaObject) {

        var variableA = inputVariablesJavaObject.get("variableA");
        var variableB = inputVariablesJavaObject.get("variableB");

        String resultText = "Services with " + variableA + " " + variableB + " the World!";
        resultText = resultText + " — full input: " + inputVariablesJavaObject;

        return Map.of("resultText", resultText);
    }
}
