package src.lld.examples.taskscheduler.tasks;

public class FeedTask implements Task {

    @Override
    public void execute() {
        System.out.println("Fetching feed...");
    }
}
