package lvr.system;

import lombok.Data;
import lvr.exceptions.system.SystemStateValueNotExpected;
import lvr.exceptions.system.SystemVariableValueNotExpected;
import lvr.exceptions.test.SystemStateImplementationException;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class SystemState {

    private String name;
    private List<SystemVariable> determiningVariables = new ArrayList<>();

    protected SystemState(String name) {
        this.name = name;
    }

    private boolean hasVariables() {
        return determiningVariables.size() > 0;
    }

    private void exitIfNoVariables() throws SystemStateImplementationException {
        if(!hasVariables()) {
            throw new SystemStateImplementationException("system state has no variables defined");
        }
    }

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

    protected abstract void addDeterminingVariables();

    public static SystemState getWithName(String stateName) {

    }

}
