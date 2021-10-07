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
public class CaseLiteralChar extends caseLiteral {
    public CaseLiteralChar(CharacterLiteral chrAST, SourcePosition thePosition){
        super (thePosition);
        chr = chrAST;
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitCaseLiteralChar(this, o);
    }
    
    public CharacterLiteral chr;
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

