package lvr;

import lvr.system.SystemAction;
import lvr.system.SystemCapability;

import java.util.List;

public class Main {

    private List<SystemCapability> definedSystemCapabilities;
    private List<SystemAction> definedSystemActions;

    public List<SystemAction> getDefinedSystemActions() {
        return definedSystemActions;
    }

    public List<SystemCapability> getDefinedSystemCapabilities() {
        return definedSystemCapabilities;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}