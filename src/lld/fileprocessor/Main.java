package src.lld.fileprocessor;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //steps -> can be done in separate file or loaded fromm yaml file
        EncryptionStep encryptionStep = new EncryptionStep();
        TransformationStep transformationStep = new TransformationStep();
        ValidationStep validationStep = new ValidationStep();

        FileProcessor pdfProcessor = new FileProcessor(List.of(encryptionStep, transformationStep));
        FileProcessor xmlProcessor = new FileProcessor(List.of(validationStep, transformationStep));

        FileContext context = new FileContext("file.pdf", new byte[]{1, 2, 3});
        pdfProcessor.process(context);

        context = new FileContext("test.xml", new byte[]{4, 5, 6});
        xmlProcessor.process(context);

    }
}
