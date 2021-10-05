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
public class RepeatForRangeCommand extends Command {
    public RepeatForRangeCommand(Identifier iAST, Expression e1AST, Expression e2AST, Command cAST, SourcePosition thePosition){
        super (thePosition);
        RVD = new RangeVarDecl(iAST, e1AST, thePosition);
        e = e2AST;
        c = cAST;
    }
    
   public Object visit(Visitor v, Object o) {
    return v.visitRepeatForRangeCommand(this, o);
  }
   
   @Override
    public Element conseguirNodes(Document doc) {
        Element rootElement = doc.createElement("RepeatForRangeCommand");
        rootElement.appendChild(RVD.conseguirNodes(doc));
        rootElement.appendChild(e.conseguirNodes(doc));
        rootElement.appendChild(c.conseguirNodes(doc));
        return rootElement;
    }
   
   public RangeVarDecl RVD;
   public Expression e;
   public Command c;
}
