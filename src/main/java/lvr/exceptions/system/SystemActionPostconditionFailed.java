package lvr.exceptions.system;

public class SystemActionPostconditionFailed extends Exception {
    public SystemActionPostconditionFailed(Exception e) {
        this.initCause(e);
    }
}
