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
public class RepeatForInCommand extends Command {
    public RepeatForInCommand(Identifier iAST, Expression eAST, Command cAST, SourcePosition thePosition) {
        super(thePosition);
        I = iAST;
        E = eAST;
        C = cAST;
    }
    
    public Object visit(Visitor v, Object o) {
        return v.visitRepeatForInCommand(this, o);
    }
    
    public Identifier I;
    public Expression E;
    public Command C;
}
