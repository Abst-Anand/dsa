package src.lld.taskscheduler.triggers;

import java.time.Duration;
import java.time.Instant;

public class RetryTrigger implements Trigger{
    private int retriesLeft;
    private final Duration retryInterval;

    public RetryTrigger(int retries, Duration retryInterval){
        this.retriesLeft = retries;
        this.retryInterval = retryInterval;
    }

    @Override
    public Instant nextExecutionTime(Instant now) {
        if(retriesLeft <= 0){
            return Instant.MAX; // dont execute if no retries left
        }

        retriesLeft--;
        return now.plus(retryInterval); // after this interval, it retries again
    }
}
