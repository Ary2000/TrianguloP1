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
public class IfSequencialCommand extends Command {
    public IfSequencialCommand (Command c1AST, Expression eAST, Command c2AST, SourcePosition thePosition) {
    super (thePosition);
    C1 = c1AST;
    E = eAST;
    C2 = c2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitIfSequencialCommand(this, o);
  }
  
  @Override
    public Element conseguirNodes(Document doc) {
        Element rootElement = doc.createElement("SequencialCommand");
        rootElement.appendChild(C1.conseguirNodes(doc));
        rootElement.appendChild(C2.conseguirNodes(doc));
        return rootElement;
    }

  public Expression E;
  public Command C1, C2;
}
