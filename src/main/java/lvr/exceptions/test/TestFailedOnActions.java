package lvr.exceptions.test;

public class TestFailedOnActions extends Exception {
    public TestFailedOnActions(Exception e) {
        this.initCause(e);
    }
}
