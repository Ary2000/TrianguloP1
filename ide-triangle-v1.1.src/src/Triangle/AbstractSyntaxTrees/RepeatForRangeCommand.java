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
public class RepeatForRangeCommand extends Command {
    public RepeatForRangeCommand(Identifier iAST, Expression e1AST, Expression e2AST, Command cAST, SourcePosition thePosition){
        super (thePosition);
        i = iAST;
        e1 = e1AST;
        e2 = e2AST;
        c = cAST;
    }
    
   public Object visit(Visitor v, Object o) {
    return v.visitRepeatForRangeCommand(this, o);
  }
   
   Identifier i;
   Expression e1, e2;
   Command c;
}
