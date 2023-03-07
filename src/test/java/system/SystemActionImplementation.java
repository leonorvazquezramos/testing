package system;

import lvr.system.SystemAction;
import lvr.system.SystemState;

public class SystemActionImplementation extends SystemAction {

    SystemActionImplementation(String name) {
        super(name);
    }

    @Override
    protected void actionImplementation() {
        System.out.println("action");
    }

    @Override
    protected void setPrecondition(String stateName) {
        this.postcondition = SystemState.getWithName(stateName);
    }

    @Override
    protected void setPostcondition(String stateName) {
        this.postcondition = SystemState.getWithName(stateName);
    }

}
