package src.lld.examples.fileprocessor;

public class EncryptionStep implements ProcessingStep{

    @Override
    public void execute(FileContext fileContext) {
        System.out.println("Encrypted " + fileContext.getFileName());
    }
}
