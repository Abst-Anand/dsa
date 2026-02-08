package src.lld.taskscheduler.triggers;

import java.time.Instant;

public class ImmediateTrigger implements Trigger{
    private boolean isExecuted = false;

    @Override
    public Instant nextExecutionTime(Instant now) {
        if(!isExecuted){
            isExecuted = true;
            return now; // execute now
        }
        return Instant.MAX; // never again
    }
}
