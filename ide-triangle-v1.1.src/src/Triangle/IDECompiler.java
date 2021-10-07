/*
 * IDE-Triangle v1.0
 * Compiler.java 
 */

package Triangle;

import Triangle.CodeGenerator.Frame;
import java.awt.event.ActionListener;
import Triangle.SyntacticAnalyzer.SourceFile;
import Triangle.SyntacticAnalyzer.Scanner;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.SyntacticAnalyzer.Parser;
import Triangle.SyntacticAnalyzer.TokenPrinter;
import Triangle.ContextualAnalyzer.Checker;
import Triangle.CodeGenerator.Encoder;
import Triangle.SyntacticAnalyzer.TokenPrinter;
import Triangle.TreeWriterHTLM.Writer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/** 
 * This is merely a reimplementation of the Triangle.Compiler class. We need
 * to get to the ASTs in order to draw them in the IDE without modifying the
 * original Triangle code.
 *
 * @author Luis Leopoldo P�rez <luiperpe@ns.isi.ulatina.ac.cr>
 */
public class IDECompiler {

    // <editor-fold defaultstate="collapsed" desc=" Methods ">
    /**
     * Creates a new instance of IDECompiler.
     *
     */
    public IDECompiler() {
    }
    
    /**
     * Particularly the same compileProgram method from the Triangle.Compiler
     * class.
     * @param sourceName Path to the source file.
     * @return True if compilation was succesful.
     */
    
    public boolean compileProgram(String sourceName) {
        System.out.println("********** " +
                           "Triangle Compiler (IDE-Triangle 1.0)" +
                           " **********");
        
        System.out.println("Syntactic Analysis ...");
        SourceFile source = new SourceFile(sourceName);
        Scanner scanner = new Scanner(source);
        report = new IDEReporter();
        Parser parser = new Parser(scanner, report);
        boolean success = false;
        rootAST = parser.parseProgram();
        
        if (report.numErrors == 0) {
            //System.out.println("Contextual Analysis ...");
            //Checker checker = new Checker(report);
            //checker.check(rootAST);
            if (report.numErrors == 0) {
                //System.out.println("Code Generation ...");
                //Encoder encoder = new Encoder(report);
                //encoder.encodeRun(rootAST, false);
                
                if (report.numErrors == 0) {
                    //encoder.saveObjectProgram(sourceName.replace(".tri", ".tam"));
                    /*
                    try {
                        DocumentBuilderFactory dbFactory =
                        DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                        Document doc = dBuilder.newDocument();
                        doc.appendChild(rootAST.conseguirNodes(doc));
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource dmSource = new DOMSource(doc);
                        StreamResult result = new StreamResult(new File("resultado.xml"));
                        transformer.transform(dmSource, result);

                        //------------HTML HTML HTML ADD FOR JACOB ------------------------------                    
                        
                        SourceFile source2 = new SourceFile(sourceName);
                        Scanner scanner2 = new Scanner(source2);
                        TokenPrinter tP = new TokenPrinter(scanner2);
                        doc = tP.printTokensHtml();
                        dmSource = new DOMSource(doc);
                        String sourceNameHtml = sourceName.replace(".tri", ".html");
                        result = new StreamResult(new File(sourceNameHtml));
                        transformer.transform(dmSource, result);
                        
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    */
                    Writer writer = new Writer("Resultado.xml");
                    writer.write(rootAST);
                    success = true;
                }
            }
        }

        if (success)
        {
            System.out.println("Compilation was successful.");
            
            //TokenPrinter tokenPrinter = new TokenPrinter(scanner);
            //tokenPrinter.printTokens();
        }
        else
            System.out.println("Compilation was unsuccessful.");
        
        return(success);
    }
    
      
    /**
     * Returns the line number where the first error is.
     * @return Line number.
     */
    public int getErrorPosition() {
        return(report.getFirstErrorPosition());
    }
        
    /**
     * Returns the root Abstract Syntax Tree.
     * @return Program AST (root).
     */
    public Program getAST() {
        return(rootAST);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Attributes ">
    private Program rootAST;        // The Root Abstract Syntax Tree.    
    private IDEReporter report;     // Our ErrorReporter class.
    // </editor-fold>
}
