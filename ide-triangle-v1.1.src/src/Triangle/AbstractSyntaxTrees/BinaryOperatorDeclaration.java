/*
 * @(#)BinaryOperatorDeclaration.java                2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BinaryOperatorDeclaration extends Declaration {

  public BinaryOperatorDeclaration (Operator oAST, TypeDenoter arg1AST,
  		   TypeDenoter arg2AST, TypeDenoter resultAST,
  		   SourcePosition thePosition) {
    super (thePosition);
    O = oAST;
    ARG1 = arg1AST;
    ARG2 = arg2AST;
    RES = resultAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitBinaryOperatorDeclaration(this, o);
  }

  @Override
    public Element conseguirNodes(Document doc) {
        Element rootElement = doc.createElement("AnyTypeDenoter");
        rootElement.appendChild(O.conseguirNodes(doc));
        rootElement.appendChild(ARG1.conseguirNodes(doc));
        rootElement.appendChild(ARG2.conseguirNodes(doc));
        rootElement.appendChild(RES.conseguirNodes(doc));
        return rootElement;
    }
  
  public Operator O;
  public TypeDenoter ARG1, ARG2, RES;
}
