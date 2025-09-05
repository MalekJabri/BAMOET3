package org.kie.kogito.dmn.consumer.example.customprofiles;

import java.util.List;

import org.kie.dmn.api.marshalling.DMNExtensionRegister;
import org.kie.dmn.core.compiler.DMNProfile;
import org.kie.dmn.core.compiler.DRGElementCompiler;
import org.kie.dmn.feel.runtime.FEELFunction;

public class CustomDMNProfile implements DMNProfile {

    @Override
    public List<DMNExtensionRegister> getExtensionRegisters() {
        return List.of();
    }

    @Override
    public List<DRGElementCompiler> getDRGElementCompilers() {
        return List.of();
    }

    @Override
    public List<FEELFunction> getFEELFunctions() {
        return List.of();
    }
}