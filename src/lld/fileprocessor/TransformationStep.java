package src.lld.fileprocessor;

public class TransformationStep implements ProcessingStep{

    @Override
    public void execute(FileContext fileContext) {
        if (fileContext.getContent() == null || fileContext.getContent().length == 0){
            throw new IllegalStateException("Invalid File:" + fileContext.getFileName());
        }
        System.out.println("File Transformed");
    }
}
