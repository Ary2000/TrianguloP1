/*
 * @(#)Identifier.java                        2.1 2003/10/07
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

public class Identifier extends Terminal {

  public Identifier (String theSpelling, SourcePosition thePosition) {
    super (theSpelling, thePosition);
    type = null;
    decl = null;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitIdentifier(this, o);
  }

  @Override
    public Element conseguirNodes(Document doc) {
        Element rootElement = doc.createElement("Identifier");
        rootElement.setAttribute("value", spelling);
        //rootElement.appendChild(type.conseguirNodes(doc));
        //rootElement.appendChild(decl.conseguirNodes(doc));
        return rootElement;
    }
  
  public TypeDenoter type;
  public AST decl; // Either a Declaration or a FieldTypeDenoter
}
