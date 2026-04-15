package src.lld.examples.taskscheduler.tasks;

public class SyncTask implements Task {

    @Override
    public void execute() {
        System.out.println("Syncing data with remote service...");
    }
}
