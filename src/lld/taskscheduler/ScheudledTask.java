package src.lld.taskscheduler;

import src.lld.taskscheduler.tasks.Task;
import src.lld.taskscheduler.triggers.Trigger;

import java.time.Instant;

public class ScheudledTask {
    private final Task task;
    private final Trigger trigger;
    private Instant nextRunTime;

    public ScheudledTask(Task task, Trigger trigger){
        this.task = task;
        this.trigger = trigger;
        this.nextRunTime = trigger.nextExecutionTime(Instant.now());
    }

    public boolean shouldRun(Instant time){
        return !time.isBefore(nextRunTime);
    }

    public void run(){
        task.execute();
        nextRunTime = trigger.nextExecutionTime(Instant.now());
    }
}
