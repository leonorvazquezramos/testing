package system;

import lvr.exceptions.system.SystemActionPostconditionFailed;
import lvr.exceptions.system.SystemActionPreconditionFailed;
import lvr.exceptions.test.TestImplementationException;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemActionTest {

    @Test
    public void executeTestNoPreconditionsNoPostconditions() {
        SystemActionImplementation action = new SystemActionImplementation("test action");
        TestImplementationException thrown = assertThrows(
                TestImplementationException.class,
                action::execute,
                "Expected to throw TestImplementationException but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("this action has no defined postconditions"));
    }

    public void executeTestNoPreconditionsPostconditions() {
        SystemActionImplementation action = new SystemActionImplementation("test action");
        action.setPostcondition("defined postcondition");
        TestImplementationException thrown = assertThrows(
                TestImplementationException.class,
                action::execute,
                "Expected to throw TestImplementationException but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("this action has no defined postconditions"));
    }

}
