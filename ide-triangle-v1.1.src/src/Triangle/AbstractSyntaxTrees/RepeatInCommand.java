/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Ary
 */
public class RepeatInCommand extends Command {
    public RepeatInCommand(Identifier iAST, Expression eAST, Command cAST, SourcePosition thePosition){
        super (thePosition);
        i = iAST;
        e = eAST;
        c = cAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatInCommand(this, o);
    }
    
    Identifier i;
    Expression e;
    Command c;
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

