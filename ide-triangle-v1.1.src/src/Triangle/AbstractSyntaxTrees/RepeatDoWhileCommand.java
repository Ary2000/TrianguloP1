/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Ary
 */
public class RepeatDoWhileCommand extends Command{
    public RepeatDoWhileCommand(Command cAST, Expression eAST, SourcePosition thePosition){
        super (thePosition);
        c = cAST;
        e = eAST;
    }
    
    public Object visit(Visitor v, Object o) {
    return v.visitRepeatDoWhileCommand(this, o);
  }
    
    @Override
    public Element conseguirNodes(Document doc) {
        Element rootElement = doc.createElement("RepeatDoWhileCommand");
        rootElement.appendChild(e.conseguirNodes(doc));
        rootElement.appendChild(c.conseguirNodes(doc));
        return rootElement;
    }
    
    public Expression e;
    public Command c;
}
