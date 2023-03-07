package lvr.system;

import lombok.Data;
import lvr.exceptions.system.SystemVariableValueNotExpected;

import java.lang.reflect.Type;

@Data
public abstract class SystemVariable {
    private String name;
    private String value;
    private Type type;

    SystemVariable(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public void set(String value) {
        this.value = value;
    }

    public boolean equals(SystemVariable otherVariable) {
        return this.name.equals(otherVariable.name) &&
                this.value.equals(otherVariable.value);
    }

    protected abstract void verify() throws SystemVariableValueNotExpected;
}
