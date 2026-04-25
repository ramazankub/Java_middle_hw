package org.example.homeWorks.hw7.part2;

public abstract class LoanHandler {

    protected LoanHandler next;

    public LoanHandler setNext(LoanHandler next) {
        this.next = next;
        return next;
    }

    public void handle(LoanApplication application) {

        if (!process(application)) {
            return;
        }

        if (next != null) {
            next.handle(application);
        }
    }

    protected abstract boolean process(
            LoanApplication application
    );
}