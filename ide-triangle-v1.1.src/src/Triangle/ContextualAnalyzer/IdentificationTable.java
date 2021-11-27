/*
 * @(#)IdentificationTable.java                2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.ContextualAnalyzer;

import Triangle.AbstractSyntaxTrees.Declaration;
import java.util.Stack;

public final class IdentificationTable {

  private int level;
  private IdEntry latest;
  private Stack<IdEntry> alfa = new Stack<>();
  private Stack<IdEntry> beta = new Stack<>();


  public IdentificationTable () {
    level = 0;
    latest = null;
  }

  // Opens a new level in the identification table, 1 higher than the
  // current topmost level.

  public void openScope () {

    level ++;
  }
  
  // Closes the topmost level in the identification table, discarding
  // all entries belonging to that level.

  public void closeScope () {

    IdEntry entry, local;

    // Presumably, idTable.level > 0.
    entry = this.latest;
    while (entry.level == this.level) {
      local = entry;
      entry = local.previous;
    }
    this.level--;
    this.latest = entry;
  }
  
  
  public void beginLocal(){
      alfa.push(this.latest); //alfa
  }
  public void beginIn(){
      beta.push(this.latest); //beta
  }
  //Variable alfa es el nivel 0 Tid
  //Variable Beta es lo que esta en el nivel 1 antes del in
  public void endLocal(){
    IdEntry local, temp, entry, varAlfa, varBeta;
    Stack<IdEntry> stackDeclarations = new Stack<>();
    varBeta = beta.pop();
    varAlfa = alfa.pop();
    
    entry = this.latest;  //latest actual  C0 <- C1 <- C2
    int numDeclarations = 0;
    while (!entry.equals(varBeta)){ // mientras no se cumpla (latest actual anterior igual beta)
        entry = entry.previous;
        numDeclarations++; //Cuenta el numero de declaraciones que hay hasta salir del in
    }

    temp = entry; //aqui tenemos todo lo sucio C0 <- C1
    
    while(!(temp.equals(varAlfa))){ //aqui queremos llegar al nivel 0
        local = temp;
        temp = local.previous;
    }
    //tenemos a temporal en nivel 0 C0
    
    entry = temp; //Todo lo limpio
    local = this.latest;
    while(numDeclarations!=0){ //metemos las declaraciones que hubieron delante del beta a una pila
        stackDeclarations.push(local);
        local = local.previous;
        numDeclarations--;
    }
    local = stackDeclarations.pop(); //sacamos una declaración
    local.previous = entry; //detras de esa declaración va lo limpio
    while(!stackDeclarations.empty()){ //mientras no existan declaraciones declaracion.atras = lo limpio 
        temp = stackDeclarations.pop();
        temp.previous = local;
        local = temp;
    }
    //C0 <- C2
    this.latest = local;
  }
  
  
  


  // Makes a new entry in the identification table for the given identifier
  // and attribute. The new entry belongs to the current level.
  // duplicated is set to to true iff there is already an entry for the
  // same identifier at the current level.

  public void enter (String id, Declaration attr) {

    IdEntry entry = this.latest;
    boolean present = false, searching = true;

    // Check for duplicate entry ...
    while (searching) {
      if (entry == null || entry.level < this.level)
        searching = false;
      else if (entry.id.equals(id)) {
        present = true;
        searching = false;
       } else
       entry = entry.previous;
    }

    attr.duplicated = present;
    // Add new entry ...
    entry = new IdEntry(id, attr, this.level, this.latest);
    this.latest = entry;
  }

  // Finds an entry for the given identifier in the identification table,
  // if any. If there are several entries for that identifier, finds the
  // entry at the highest level, in accordance with the scope rules.
  // Returns null iff no entry is found.
  // otherwise returns the attribute field of the entry found.

  public Declaration retrieve (String id) {

    IdEntry entry;
    Declaration attr = null;
    boolean present = false, searching = true;

    entry = this.latest;
    while (searching) {
      if (entry == null)
        searching = false;
      else if (entry.id.equals(id)) {
        present = true;
        searching = false;
        attr = entry.attr;
      } else
        entry = entry.previous;
    }

    return attr;
  }

}
