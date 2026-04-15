package src.lld.examples.taskscheduler.tasks;

public class CleanupTask implements Task {

    @Override
    public void execute() {
        System.out.println("Cleaning up temporary files...");
    }
}
