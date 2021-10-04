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
public class RepeatForRangeUntilCommand extends Command {
    public RepeatForRangeUntilCommand(Identifier iAST, Expression e1AST, Expression e2AST, 
                                      Expression e3AST, Command cAST, SourcePosition thePosition){
        super(thePosition);
        I = iAST;
        E1 = e1AST;
        E2 = e2AST;
        E3 = e3AST;
        C = cAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatForRangeUntilCommand(this, o);
    }
    
    @Override
    public Element conseguirNodes(Document doc) {
        Element rootElement = doc.createElement("RepeatForRangeUntilCommand");
        rootElement.appendChild(I.conseguirNodes(doc));
        rootElement.appendChild(E1.conseguirNodes(doc));
        rootElement.appendChild(E2.conseguirNodes(doc));
        rootElement.appendChild(E3.conseguirNodes(doc));
        rootElement.appendChild(C.conseguirNodes(doc));
        return rootElement;
    }
    
    Identifier I;
    Expression E1, E2, E3;
    Command C;
    
}
