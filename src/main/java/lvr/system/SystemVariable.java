package lvr.system;

import lombok.Data;
import lvr.exceptions.system.SystemVariableValueNotExpected;

import java.lang.reflect.Type;

@Data
public abstract class SystemVariable {
    protected String name;
    protected String value;

    protected SystemVariable(String name, String value) {
        this.name = name;
        this.value = value;
    }


    public boolean equals(SystemVariable otherVariable) {
        return this.name.equals(otherVariable.name) &&
                this.value.equals(otherVariable.value);
    }

    protected abstract void verify() throws SystemVariableValueNotExpected;
}
