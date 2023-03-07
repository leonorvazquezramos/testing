package lvr.exceptions.test;

public class TestFailedOnAssertions extends Exception {
    TestFailedOnAssertions(Exception e) {
        this.initCause(e);
    }
}
