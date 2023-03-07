package lvr.system;

import lvr.config.InterfaceType;
import lvr.exceptions.system.SystemActionPostconditionFailed;
import lvr.exceptions.system.SystemActionPreconditionFailed;
import lvr.exceptions.system.SystemStateValueNotExpected;
import lvr.exceptions.test.SystemActionImplementationException;
import lvr.exceptions.test.TestImplementationException;

public abstract class SystemAction {
    protected String name;
    protected SystemState precondition;
    protected SystemState postcondition;
    protected InterfaceType type;

    protected SystemAction(String name) {
        this.name = name;
    }

    public void execute() throws SystemActionPreconditionFailed, SystemActionPostconditionFailed, SystemActionImplementationException {
        setup();
        actionImplementation();
        finish();
    }

    private void setup() throws SystemActionPreconditionFailed {
        try {
            if(precondition != null) {
                precondition.verify();
            }
        } catch (SystemStateValueNotExpected e) {
            throw new SystemActionPreconditionFailed(e);
        }
    }

    protected abstract void actionImplementation();
    protected abstract void setPrecondition(String stateName);
    protected abstract void setPostcondition(String stateName);


    private void finish() throws SystemActionPostconditionFailed, SystemActionImplementationException {
        if(postcondition == null) {
            throw new SystemActionImplementationException("this action has no defined postconditions");
        }
        try {
            postcondition.verify();
        } catch (SystemStateValueNotExpected e) {
            throw new SystemActionPostconditionFailed(e);
        }
    }

    public boolean canBeChainedAfter(SystemAction previousAction) {
        return previousAction.postcondition.isCompatibleWith(this.precondition);
    }
}
