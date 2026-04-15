package src.lld.examples.taskscheduler;

import src.lld.examples.taskscheduler.tasks.CleanupTask;
import src.lld.examples.taskscheduler.tasks.FeedTask;
import src.lld.examples.taskscheduler.tasks.SyncTask;
import src.lld.examples.taskscheduler.triggers.CronTrigger;
import src.lld.examples.taskscheduler.triggers.ImmediateTrigger;
import src.lld.examples.taskscheduler.triggers.RetryTrigger;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {

        Scheduler scheduler = new Scheduler();

        scheduler.register(
                new ScheudledTask(
                        new FeedTask(),
                        new ImmediateTrigger()
                ));

        scheduler.register(
                new ScheudledTask(
                        new SyncTask(),
                        new RetryTrigger(3, Duration.ofSeconds(5))
                ));

        scheduler.register(new ScheudledTask(new CleanupTask(), new CronTrigger(Duration.ofSeconds(3))));

        scheduler.start();
    }
}
