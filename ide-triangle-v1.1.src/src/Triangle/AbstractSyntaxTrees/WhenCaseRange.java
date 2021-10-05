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
public class WhenCaseRange extends Cases {
    public WhenCaseRange(caseLiteral clAST1, caseLiteral clAST2,Command cAST, SourcePosition thePosition){
        super (thePosition);
        cl1 = clAST1;
        cl2 = clAST1;
        c = cAST;
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitWhenCaseRange(this, o);
    }
    
    caseLiteral cl1,cl2;
    Command c;
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

