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
public class VarInitDeclaration extends Declaration{

    public VarInitDeclaration(Identifier iAST, Expression eAST, SourcePosition thePosition) {
        super(thePosition);
        I = iAST;
        E = eAST;
        T = null;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitVarInitDeclaration(this, o);
        
    }
    public Identifier I;
    public Expression E;
    public TypeDenoter T;
    
}
