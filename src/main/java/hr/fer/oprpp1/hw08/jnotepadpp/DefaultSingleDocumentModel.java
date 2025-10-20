package hr.fer.oprpp1.hw08.jnotepadpp;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.nio.file.Files.readAllBytes;

public class DefaultSingleDocumentModel implements SingleDocumentModel{
    JTextArea area;
    Path path;
    ImageIcon red,green;
    List<SingleDocumentListener> list;
    boolean isModified;
    public DefaultSingleDocumentModel(Path path,List<String> text) {
        this.path = path;
        area=new JTextArea();
        for(String s:text){
            area.append(s);
        }
        this.isModified=false;
        list=new ArrayList<>();
      /*  InputStream is = this.getClass().getResourceAsStream("/src/main/resources/crvena.png");
        if(is==null) throw new NullPointerException();
        try {
            byte[] bytes = Files.readAllBytes((Path) is);
            red=new ImageIcon(bytes);
            is=this.getClass().getResourceAsStream("src/main/resources/hr.fer.oprpp1.hw08.jnotepadpp.icons/zelena.png");
            bytes = Files.readAllBytes((Path) is);
            green=new ImageIcon(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


    }
    public ImageIcon getRed(){
        return red;
    }
    public ImageIcon getGreen(){
        return green;
    }
    public ImageIcon getIcon(){
        if(isModified()){
            return red;
        }
        return green;
    }

    @Override
    public JTextArea getTextComponent() {
        return area;
    }

    @Override
    public Path getFilePath() {
        return path;
    }

    @Override
    public void setFilePath(Path path) {
        if(path==null) {
            throw new NullPointerException();
        }
       this.path=path;

    }

    @Override
    public boolean isModified() {
        return isModified;
    }

    @Override
    public void setModified(boolean modified) {
        isModified=modified;
    }

    @Override
    public void addSingleDocumentListener(SingleDocumentListener l) {
           list.add(l);
    }

    @Override
    public void removeSingleDocumentListener(SingleDocumentListener l) {
        list.remove(l);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultSingleDocumentModel that = (DefaultSingleDocumentModel) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }
}
