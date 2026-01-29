package src.lld.fileprocessor;

public class ValidationStep implements ProcessingStep{

    @Override
    public void execute(FileContext fileContext) {
        if(fileContext.getContent() == null || fileContext.getContent().length == 0){
            throw new IllegalStateException("Invalid File: " + fileContext.getFileName());
        }
        System.out.println("FileName: " + fileContext.getFileName());
        System.out.println("File: " + fileContext.getFileName() + " is VALIDATED");
    }
}
