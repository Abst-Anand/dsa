package src.lld.fileprocessor;

import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
    private final List<ProcessingStep> steps;

    public FileProcessor(List<ProcessingStep> steps){
        this.steps = steps;
    }

    public void process(FileContext context){
        for(ProcessingStep step : steps){
            step.execute(context);
        }
    }

    public List<ProcessingStep> getSteps() {
        return steps;
    }
}
