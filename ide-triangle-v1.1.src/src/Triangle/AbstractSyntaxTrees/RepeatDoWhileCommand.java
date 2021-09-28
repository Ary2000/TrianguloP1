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
public class RepeatDoWhileCommand extends Command{
    public RepeatDoWhileCommand(Command cAST, Expression eAST, SourcePosition thePosition){
        super (thePosition);
        c = cAST;
        e = eAST;
    }
    
    public Object visit(Visitor v, Object o) {
    return v.visitRepeatDoWhileCommand(this, o);
  }
    
    Expression e;
    Command c;
}
