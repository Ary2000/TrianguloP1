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
public class RepeatForInCommand extends Command {
    public RepeatForInCommand(Identifier iAST, Expression eAST, Command cAST, SourcePosition thePosition) {
        super(thePosition);
        I = iAST;
        E = eAST;
        C = cAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatForInCommand(this, o);
    }
    
    @Override
    public Element conseguirNodes(Document doc) {
        Element rootElement = doc.createElement("RepeatForInCommand");
        rootElement.appendChild(I.conseguirNodes(doc));
        rootElement.appendChild(E.conseguirNodes(doc));
        rootElement.appendChild(C.conseguirNodes(doc));
        return rootElement;
    }
    
    public Identifier I;
    public Expression E;
    public Command C;
}
