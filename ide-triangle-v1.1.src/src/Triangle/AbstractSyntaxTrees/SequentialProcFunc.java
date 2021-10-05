/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author yeico
 */
public class SequentialProcFunc extends ProcFunc{

    public SequentialProcFunc(ProcFunc pF1AST, ProcFunc pF2AST, SourcePosition thePosition) {
        super(thePosition);
        PF1 = pF1AST;
        PF2 = pF2AST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitSequentialProcFunc(this, o);
    }
    
    public ProcFunc PF1, PF2;
    
}
