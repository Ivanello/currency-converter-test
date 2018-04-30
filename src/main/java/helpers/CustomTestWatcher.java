package helpers;

import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class CustomTestWatcher extends TestWatcher {

    public void succeeded(Description description) {
        System.out.println("### succeeded");
        System.out.println(description.getMethodName());
    }

    public void failed(Throwable e, Description description) {
        System.out.println("### failed");
        System.out.println(description.getMethodName());
    }

    public void skipped(AssumptionViolatedException e, Description description) {
    }

    public void starting(Description description) {
        System.out.println("### started");
        System.out.println(description.getMethodName());
    }

    public void finished(Description description) {

        System.out.println("### finshed");
        System.out.println(description.getMethodName());
    }

}
