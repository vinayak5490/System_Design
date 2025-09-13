package DocumentEditor.Bad_Design;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
class DocumentEditor{
    private List<String> documentElements;
    private String renderedDocument;

    public DocumentEditor(){
        documentElements = new ArrayList<>();
        renderedDocument = "";
    }
    public void addText(String text){
        documentElements.add(text);
    }
    public void addImage(String imagePath){
        documentElements.add(imagePath);
    }

    //Render the document by checking the type of each element at runtime
    public String renderDocument(){
        if(renderedDocument.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(String element : documentElements){
                if(element.length() > 4 && (element.endsWith(".jpg") || element.endsWith(".png"))){
                    sb.append("[image: ").append(element).append("]\n");
                }else{
                    sb.append(element).append("\n");
                }
            }
            renderedDocument = sb.toString();
        }
        return renderedDocument;
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(renderDocument());
            writer.close();
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}
public class DocumentEditorClient {
public static void main(String[] args) {
    DocumentEditor editor = new DocumentEditor();
    editor.addText("Hello, world!");
    editor.addImage("picture.jpg");
    editor.addText("This is a document editor.");

    System.out.println(editor.renderDocument());

    editor.saveToFile();
}
    
}