/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class InVarDecl extends Declaration {
    public InVarDecl(Identifier iAST, Expression eAST, SourcePosition thePosition){
        super(thePosition);
        I = iAST;
        E = eAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitInVarDecl(this, o);
    }
    
    @Override
    public Element conseguirNodes(Document doc) {
        Element rootElement = doc.createElement("RangeVarDecl");
        rootElement.appendChild(I.conseguirNodes(doc));
        rootElement.appendChild(E.conseguirNodes(doc));
        return rootElement;
    }
    
    public Identifier I;
    public Expression E;
}
