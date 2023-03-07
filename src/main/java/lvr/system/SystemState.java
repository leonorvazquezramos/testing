package lvr.system;

import lombok.Data;
import lvr.exceptions.system.SystemStateValueNotExpected;
import lvr.exceptions.system.SystemVariableValueNotExpected;

import java.util.List;

@Data
public abstract class SystemState {

    private String name;
    private List<SystemVariable> determiningVariables;

    public boolean isCompatibleWith(SystemState otherState) {
        for(SystemVariable thisVariable : determiningVariables) {
            for(SystemVariable otherVariable : otherState.determiningVariables) {
                if(thisVariable.getName().equals(otherVariable.getName())) {
                    if(!thisVariable.getValue().equals(otherVariable.getValue())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean conflictsWith(SystemState otherState) {
        return !isCompatibleWith(otherState);
    }

    public void verify() throws SystemStateValueNotExpected {
        for(SystemVariable systemVariable : determiningVariables) {
            try {
                systemVariable.verify();
            } catch (SystemVariableValueNotExpected e) {
                throw new SystemStateValueNotExpected(e);
            }
        }
    }
}
