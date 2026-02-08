package src.lld.taskscheduler.triggers;

import java.time.Duration;
import java.time.Instant;

public class CronTrigger implements Trigger{

    private final Duration interval;

    public CronTrigger(Duration interval){
        this.interval = interval;
    }

    @Override
    public Instant nextExecutionTime(Instant now) {
        return now.plus(interval);
    }
}
