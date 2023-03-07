package system;

import lvr.exceptions.system.SystemVariableValueNotExpected;
import lvr.system.SystemVariable;

import java.lang.reflect.Type;

public class SystemVariableImplementation extends SystemVariable {
    protected SystemVariableImplementation(String name, String value) {
        super(name, value);
    }

    @Override
    protected void verify() throws SystemVariableValueNotExpected {
        System.out.println("verified");
    }



}
