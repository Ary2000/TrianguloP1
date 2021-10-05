/*
 * @(#)BinaryExpression.java                        2.1 2003/10/07
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

public class BinaryExpression extends Expression {

  public BinaryExpression (Expression e1AST, Operator oAST, Expression e2AST,
             SourcePosition thePosition) {
    super (thePosition);
    O = oAST;
    E1 = e1AST;
    E2 = e2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitBinaryExpression(this, o);
  }

  public Element conseguirNodes(Document doc) {
      Element rootElement = doc.createElement("IntegerLiteral");
      rootElement.appendChild(E1.conseguirNodes(doc));
      rootElement.appendChild(E2.conseguirNodes(doc));
      rootElement.appendChild(O.conseguirNodes(doc));
      return rootElement;
  }
  
  public Expression E1, E2;
  public Operator O;
}
