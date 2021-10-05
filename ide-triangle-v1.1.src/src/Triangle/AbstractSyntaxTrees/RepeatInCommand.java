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
public class RepeatInCommand extends Command {
    public RepeatInCommand(Identifier iAST, Expression eAST, Command cAST, SourcePosition thePosition){
        super (thePosition);
        i = iAST;
        e = eAST;
        c = cAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatInCommand(this, o);
    }
    
    @Override
    public Element conseguirNodes(Document doc) {
        Element rootElement = doc.createElement("RepeatInCommand");
        rootElement.appendChild(i.conseguirNodes(doc));
        rootElement.appendChild(e.conseguirNodes(doc));
        rootElement.appendChild(c.conseguirNodes(doc));
        return rootElement;
    }
    
    public Identifier i;
    public Expression e;
    public Command c;
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

