package system;

import lvr.exceptions.system.SystemVariableValueNotExpected;
import lvr.system.SystemVariable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemVariableTest {

    @Test
    public void verify() {
        SystemVariableImplementation variableImplementation = new SystemVariableImplementation("variable name", "variable value");
        try {
            variableImplementation.verify();
        } catch (SystemVariableValueNotExpected e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void equalsEqual() {
        SystemVariableImplementation variableImplementation1 = new SystemVariableImplementation("variable name", "variable value");
        SystemVariableImplementation variableImplementation2 = new SystemVariableImplementation("variable name", "variable value");

        assertTrue(variableImplementation1.equals(variableImplementation2));
    }

    @Test
    public void equalsDistinctName() {
        SystemVariableImplementation variableImplementation1 = new SystemVariableImplementation("variable name1", "variable value");
        SystemVariableImplementation variableImplementation2 = new SystemVariableImplementation("variable name2", "variable value");

        assertFalse(variableImplementation1.equals(variableImplementation2));
    }

    @Test
    public void equalsDistinctValue() {
        SystemVariableImplementation variableImplementation1 = new SystemVariableImplementation("variable name", "variable value1");
        SystemVariableImplementation variableImplementation2 = new SystemVariableImplementation("variable name", "variable value2");

        assertFalse(variableImplementation1.equals(variableImplementation2));
    }

}
