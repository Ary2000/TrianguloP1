package Triangle.TreeWriterHTLM;

import Triangle.AbstractSyntaxTrees.Program;
import Triangle.SyntacticAnalyzer.Scanner;
import Triangle.SyntacticAnalyzer.SourceFile;
import Triangle.SyntacticAnalyzer.TokenPrinter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public class Writer {

  private String fileName;

  public Writer(String fileName) {
    this.fileName = fileName;
  }

  // Draw the AST representing a complete program.
  public void write(Program ast) {
    // Prepare the file to write
    try {
      FileWriter fileWriter = new FileWriter(fileName);

      //HTML header
      fileWriter.write("<?xml version=\"1.0\" standalone=\"yes\"?>\n");

      WriterVisitor layout = new WriterVisitor(fileWriter);
      ast.visit(layout, null);

      fileWriter.close();

    } catch (IOException e) {
      System.err.println("Error while creating file for print the AST");
      e.printStackTrace();
    }
  }
  //****************************************
 //*        AGREGACION DE JACOB           *
 //****************************************
  public void writeHtml(String sourceName){  //Funcion que crea el documento, lo rellena y luego lo genera
      try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            SourceFile source2 = new SourceFile(sourceName);
            Scanner scanner2 = new Scanner(source2);
            TokenPrinter tP = new TokenPrinter(scanner2);
            Document doc = tP.printTokensHtml();   
            DOMSource dmSource = new DOMSource(doc);
            String sourceNameHtml = sourceName.replace(".tri", ".html");
            StreamResult result = new StreamResult(new File(sourceNameHtml));
            transformer.transform(dmSource, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
                    
    }
    //****************************************
 //*        FIN DE AGREGACION DE JACOB           *
 //****************************************

}
