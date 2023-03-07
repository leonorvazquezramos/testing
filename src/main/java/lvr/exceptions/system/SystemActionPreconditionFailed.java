package lvr.exceptions.system;

public class SystemActionPreconditionFailed extends Exception {
    public SystemActionPreconditionFailed(Exception e) {
        this.initCause(e);
    }
}
