/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AppelOuAcces;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a binary expression.
 * @author Marc Pantel
 *
 */
public class AccesImpl implements AppelOuAcces {

	protected Expression exp;
	protected String ident;

	public AccesImpl(Expression _exp, String _ident) // Ici Expression est potentiellement un AccesImpl
	{
		this.exp = _exp;
		this.ident = _ident;
		System.out.println("Creation acces : exp : " + this.exp + ", ident : " + this.ident);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {		
		return this.exp.toString() + "." + this.ident;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		 Type expType = this.exp.getType();
		 Attribut a = null;
		 if (expType instanceof ClassTypeImpl) {
			 ClasseImpl c = (ClasseImpl)((ClassTypeImpl)expType).getClasse();
			 a = c.getAttribut(this.ident);
		 }
		 return a.getType();
	}
	
	 @Override
	 public Type getTypeReel() {
		 Type expType = this.exp.getType();
		 Attribut a = null;
		 if (expType instanceof ClassTypeImpl) {
			 ClasseImpl c = (ClasseImpl)((ClassTypeImpl)expType).getClasse();
			 a = c.getAttribut(this.ident);
		 }
		 return a.getTypeReel();
	 }

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		 throw new SemanticsUndefinedException("getCode is undefined in AccesImpl.java");
	}

}
