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
public class RecursiveDeclaration extends Declaration{

    public RecursiveDeclaration(ProcFunc pAST,SourcePosition thePosition) {
        super(thePosition);
        P = pAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitRecursiveDeclaration(this, o);
    }
    public ProcFunc P;
    public TypeDenoter T;
    
}
