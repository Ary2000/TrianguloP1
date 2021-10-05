/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

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
/**
 *
 * @author Ary
 */
public class RepeatDoUntilCommand extends Command {
    public RepeatDoUntilCommand(Command cAST, Expression eAST, SourcePosition thePosition){
        super (thePosition);
        c = cAST;
        e = eAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatDoUntilCommand(this, o);
    }
    
    public Element conseguirNodes(Document doc) {
      Element rootElement = doc.createElement("RepeatDoUntilCommand");
      rootElement.appendChild(e.conseguirNodes(doc));
      rootElement.appendChild(c.conseguirNodes(doc));
      return rootElement;
  }
    
    public Expression e;
    public Command c;
}
