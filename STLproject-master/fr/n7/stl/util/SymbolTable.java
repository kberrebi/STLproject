/**
 * 
 */
package fr.n7.stl.util;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.ParametreGenericite;
import fr.n7.stl.block.ast.ForbiddenDeclarationException;
import fr.n7.stl.block.ast.HierarchicalScope;
import fr.n7.stl.block.ast.impl.Attribut;
import fr.n7.stl.block.ast.impl.Methode;

/**
 * @author pantel2
 *
 */
public class SymbolTable implements HierarchicalScope<Declaration> {
	
	private Map<String, Declaration> declarations;
	private Optional<SymbolTable> context;

	public SymbolTable() {
		this.declarations = new HashMap<String,Declaration>();
		this.context = Optional.empty();
	}
	
	public SymbolTable(SymbolTable _context) {
		this();
		if (_context != null) {
			this.context = Optional.of(_context);
		}
	}

	@Override
	public Optional<Declaration> get(String _name) {

		System.out.println("get " +_name);

		if (this.declarations.containsKey(_name)) {
			return Optional.of(this.declarations.get(_name));
		} else {
			if (this.context.isPresent()) {
				return this.context.get().get(_name);
			} else {
				return Optional.empty();
			}
		}
	}

	@Override
	public boolean contains(String _name) {
		// System.out.println("Contains( " + _name + " )");
		return (this.declarations.containsKey(_name));
	}

	@Override
	public boolean accepts(Declaration _declaration) {
		// System.out.println("Accepts( " + _declaration.getName() + " )");
		return (! this.contains(_declaration.getName()));
	}

	@Override
	public void register(Declaration _declaration) throws ForbiddenDeclarationException {
		 System.out.println("Register( " + _declaration.getName() + " )");
		if (this.accepts(_declaration)) {
			this.declarations.put(_declaration.getName(), _declaration);
		} else {
			throw new ForbiddenDeclarationException();
		}
	}



	@Override
	public boolean knows(String _name) {
		// System.out.println("Knows( " + _name + " )");
		if (this.contains(_name)) {
			return true;
		} else {
			if (this.context.isPresent()) {
				return this.context.get().knows(_name);
			} else {
				return false;
			}
		}
	}
	
	@Override
	public String toString() {
		String _local = "";
		if (this.context.isPresent()) {
			_local += "Hierarchical definitions :\n" + this.context.get().toString();
		}
		_local += "Local definitions : ";
		for (Entry<String,Declaration> _entry : this.declarations.entrySet()) {
			_local += _entry.getKey() + " -> " + _entry.getValue().toString() + "\n";
		}
		return _local;
	}


//My functions
	public void register(Declaration _declaration, String _identObjet) throws ForbiddenDeclarationException {
		
		if (this.accepts(_declaration)) {
			String key = _identObjet+"."+_declaration.getName();
			System.out.println("Register( " + key + " )");
			this.declarations.put(key, _declaration);
		} else {
			throw new ForbiddenDeclarationException();
		}
	}


	public boolean contains(String _name, String idType) {
		String key = idType+"."+_name;
		System.out.println("Contains( " + key + " )");
		return (this.declarations.containsKey(key));
	}

	public void registerM(Declaration _declaration, String _identObjet) throws ForbiddenDeclarationException {
		
		String key = _identObjet+"."+_declaration.getName();
		if ((! this.contains(key))) {
			System.out.println("Register( " + key + " )");
			this.declarations.put(key, _declaration);
		}
		/*
		else 
		{
			Methode m1 = (Methode) _declaration;
			this.get(key).addListeParam(m1.getParametres);
			this.get(key).addNewBlock(m1.getBlock());
			
		}
		*/
	}
	
	public void registerAttributs(List<Attribut> attributs) {
		for (Attribut a : attributs) {
			try {
				register(a, a.getClassName());
			} catch (ForbiddenDeclarationException e) {
				continue;
			}
		}
	}

	public static boolean checkIfGenericParameterIsdefined(	String identificateur, LinkedList<ParametreGenericite> genericite)
	{
		for(ParametreGenericite p : genericite)
		{
			if(p.getName().equals(identificateur))
				return true;
		}
		return false;
	}

	public static int getParameterIndex(String identificateur, LinkedList<ParametreGenericite> genericite)
	{
		int i = 0;
		for(ParametreGenericite p : genericite)
		{
			if(p.getName().equals(identificateur))
				return i;
			i++;
		}
		return i;
	}

/*
			TypeAtomique^ast:=TypeAtomique^factory.createGenericParameterType(TypeAtomique^genericite.get(i), InstanceGenericite^ast);
*/

}
