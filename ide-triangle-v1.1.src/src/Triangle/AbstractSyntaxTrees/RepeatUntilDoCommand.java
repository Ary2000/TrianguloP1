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
public class RepeatUntilDoCommand extends Command {
    public RepeatUntilDoCommand(Expression eAST, Command cAST, SourcePosition thePosition){
        super (thePosition);
        e = eAST;
        c = cAST;
    }
    
    public Object visit(Visitor v, Object o) {
    return v.visitRepeatUntilDoCommand(this, o);
  }
    
    Expression e;
    Command c;
}
