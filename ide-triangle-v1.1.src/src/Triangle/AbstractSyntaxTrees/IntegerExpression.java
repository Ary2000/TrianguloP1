/*
 * @(#)IntegerExpression.java                        2.1 2003/10/07
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

public class IntegerExpression extends Expression {

  public IntegerExpression (IntegerLiteral ilAST, SourcePosition thePosition) {
    super (thePosition);
    IL = ilAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitIntegerExpression(this, o);
  }
  
  public Element conseguirNodes(Document doc){
      Element rootElement = doc.createElement("IntegerExpression");
      rootElement.appendChild(IL.conseguirNodes(doc));
      return rootElement;
  }

  public IntegerLiteral IL;
}
