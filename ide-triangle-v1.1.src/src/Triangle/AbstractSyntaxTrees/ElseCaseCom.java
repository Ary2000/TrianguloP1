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
public class ElseCaseCom extends elseCase {
    public ElseCaseCom(Command cAST, SourcePosition thePosition){
        super (thePosition);
        c = cAST;
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitElseCaseCom(this, o);
    }
    
    public Command c;
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

