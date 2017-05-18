package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;

public class ParametreImpl implements Parametre {

	protected Type _type;
	protected String _nom;
	
	public ParametreImpl(Type _type2, String _name) {
		this._type=_type2;
		this._nom=_name;
	}

	@Override
	public String getName() {
		return this._nom;
	}

	@Override
	public Type getType() {
		return this._type;
	}

	@Override
	public String toString() {
		return _type.toString() + " " + this._nom;
	}

}