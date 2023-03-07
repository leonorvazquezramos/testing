package lvr.test;

import lvr.exceptions.system.SystemActionPostconditionFailed;
import lvr.exceptions.system.SystemActionPreconditionFailed;
import lvr.exceptions.system.SystemStateValueNotExpected;
import lvr.exceptions.test.TestFailedOnActions;
import lvr.system.SystemAction;
import lvr.system.SystemCapability;
import lvr.system.SystemState;

import java.util.List;

public abstract class Test {
    private String name;
    private SystemCapability capability;
    private List<SystemAction> steps;
    private SystemState assertion;

    Test(String name) {
        this.name = name;
    }

    public void execute() throws TestFailedOnActions {
        for(SystemAction step : steps) {
            try {
                step.execute();
            } catch (SystemActionPreconditionFailed | SystemActionPostconditionFailed e) {
                throw new TestFailedOnActions(e);
            }
        }
        try {
            assertion.verify();
        } catch (SystemStateValueNotExpected e) {
            throw new TestFailedOnActions(e);
        }
    }
}
