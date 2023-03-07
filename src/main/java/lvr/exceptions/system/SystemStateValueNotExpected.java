package lvr.exceptions.system;

public class SystemStateValueNotExpected extends Exception {
    public SystemStateValueNotExpected(Exception e) {
        this.initCause(e);
    }
}
