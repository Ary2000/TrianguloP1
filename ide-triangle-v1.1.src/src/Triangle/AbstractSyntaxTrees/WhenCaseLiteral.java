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
public class WhenCaseLiteral extends Cases {
    public WhenCaseLiteral(caseLiteral clAST, Command cAST, SourcePosition thePosition){
        super (thePosition);
        cl = clAST;
        c = cAST;
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitWhenCaseLiteral(this, o);
    }
    
    caseLiteral cl;
    Command c;
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

