package src.lld.taskscheduler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private final List<ScheudledTask> tasks = new ArrayList<>();

    public void register(ScheudledTask task){
        tasks.add(task);
    }

    public void start(){
        while (true){
            Instant now = Instant.now();
            System.out.println("Now Time: " + now);
            for(ScheudledTask t : tasks){
                if(t.shouldRun(now)){
                    t.run();
                }
            }

            try {
                Thread.sleep(2000);
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }


}
