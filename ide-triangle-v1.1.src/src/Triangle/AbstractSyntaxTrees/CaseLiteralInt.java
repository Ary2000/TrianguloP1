/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Sebas
 */
public class CaseLiteralInt extends caseLiteral {
    public CaseLiteralInt(IntegerLiteral ilAST, SourcePosition thePosition){
        super (thePosition);
        il = ilAST;
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitCaseLiteralInt(this, o);
    }
    
    IntegerLiteral il;
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

