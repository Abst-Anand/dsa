package src.lld.patterns;

import java.util.ArrayList;
import java.util.List;

interface FileSystem{
    void ls();

    void open();

    boolean isFolder();

    int size();

    String getName();
}

class File implements FileSystem{
    private String fileName;
    private int fileSize;

    public File(String fileName, int fileSize){
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    @Override
    public void ls() {
        System.out.println("ls not allowed for Files");
    }

    @Override
    public void open() {
        System.out.println(fileName);
    }

    @Override
    public boolean isFolder() {
        return false;
    }

    @Override
    public int size() {
        return fileSize;
    }

    @Override
    public String getName() {
        return fileName;
    }


}
class Folder implements FileSystem{
    private String folderName;
    private List<FileSystem> contents;
    private int indent;

    public Folder(String folderName){
        this.folderName = folderName;
        contents = new ArrayList<>();
        indent = 0;
    }

    public void addToFolder(FileSystem object){
        contents.add(object);
    }

    @Override
    public void ls() {
        for(FileSystem f : contents){
            if(f.isFolder()){
                System.out.println("+ " + f.getName());
            }else{
                f.open();
            }
        }
    }

    @Override
    public void open() {
        System.out.println("\t".repeat(indent) + folderName);
        for (FileSystem f : contents){
            if(f.isFolder()){
                indent++;
                f.open();
            }else{
                System.out.print("\t".repeat(indent));
                f.open();
            }
        }
    }

    @Override
    public boolean isFolder() {
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String getName() {
        return this.folderName;
    }


}

public class CompositeDesignPattern {

    public static void main(String[] args) {
        Folder root = new Folder("src");

        Folder subFolder = new Folder("temp");
        File txt1 = new File("f1.txt", 2);
        File txt2 = new File("f2.txt", 4);
        File txt3 = new File("f3.txt", 2);

        subFolder.addToFolder(txt3);

        root.addToFolder(subFolder);
        root.addToFolder(txt1);
        root.addToFolder(txt2);

        root.ls();
        System.out.println("==========");
        root.open();
    }
}
