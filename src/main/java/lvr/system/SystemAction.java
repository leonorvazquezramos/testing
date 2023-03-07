package lvr.system;

import lvr.config.InterfaceType;
import lvr.exceptions.system.SystemActionPostconditionFailed;
import lvr.exceptions.system.SystemActionPreconditionFailed;
import lvr.exceptions.system.SystemStateValueNotExpected;

public abstract class SystemAction {
    private String name;
    private SystemState precondition;
    private SystemState postcondition;
    private InterfaceType type;

    public void execute() throws SystemActionPreconditionFailed, SystemActionPostconditionFailed {
        setup();
        actionImplementation();
        finish();
    }

    private void setup() throws SystemActionPreconditionFailed {
        try {
            precondition.verify();
        } catch (SystemStateValueNotExpected e) {
            throw new SystemActionPreconditionFailed(e);
        }
    }

    protected abstract void actionImplementation();

    private void finish() throws SystemActionPostconditionFailed {
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
