package src.lld.taskscheduler.triggers;

import java.time.Instant;

public interface Trigger {
    Instant nextExecutionTime(Instant now);
}
