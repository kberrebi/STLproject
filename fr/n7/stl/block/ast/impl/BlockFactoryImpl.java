/**
 * 
 */
package fr.n7.stl.block.ast.impl;
import java.net.InterfaceAddress;
import java.util.List;

import fr.n7.stl.block.ast.ArgumentGenericite;
import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.BinaryOperator;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.BlockFactory;
import fr.n7.stl.block.ast.BooleanValue;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Sequence;
import fr.n7.stl.block.ast.ConstantDeclaration;
import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.DroitAcces;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.ElementInterface;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FieldDeclaration;
import fr.n7.stl.block.ast.FunctionCall;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Objet;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.ParametreGenericite;
import fr.n7.stl.block.ast.RecordType;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.TypeDeclaration;
import fr.n7.stl.block.ast.TypeInterface;
import fr.n7.stl.block.ast.TypeObjet;
import fr.n7.stl.block.ast.UnaryOperator;
import fr.n7.stl.block.ast.Value;
import fr.n7.stl.block.ast.VariableDeclaration;

/**
 * Implementation of the factory for building Abstract Syntax Tree node for the Bloc language.
 * @author Marc Pantel
 *
 */
public class BlockFactoryImpl implements BlockFactory {

	/**
	 * 
	 */
	public BlockFactoryImpl() {
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.ASTFactory#createBinaryExpression(fr.n7.block.ast.Expression, fr.n7.block.ast.Expression)
	 */
	@Override
	public Expression createBinaryExpression(Expression _left, BinaryOperator _operator, Expression _right) {
		return new BinaryExpressionImpl(_left,_operator,_right);
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.ASTFactory#createIntegerValue()
	 */
	@Override
	public Value createIntegerValue(String _texte) {
		return new IntegerValueImpl(_texte);
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.ASTFactory#createBlock()
	 */
	@Override
	public Block createBlock(Block _context) {
		return new BlockImpl(_context);
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.ASTFactory#createVariableDeclaration(java.lang.String, fr.n7.block.ast.Type, fr.n7.block.ast.Expression)
	 */
	@Override
	public VariableDeclaration createVariableDeclaration(String _name, Type _type, Expression _initialValue) {
		return new VariableDeclarationImpl(_name,_type,_initialValue);
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.ASTFactory#createIntegerType()
	 */
	@Override
	public Type createIntegerType() {
		return AtomicType.IntegerType;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createUnaryExpression(fr.n7.stl.block.ast.UnaryOperator, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Expression createUnaryExpression(UnaryOperator _operator, Expression _parameter) {
		return new UnaryExpressionImpl(_operator,_parameter);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createVariableUse(fr.n7.stl.block.ast.VariableDeclaration)
	 */
	@Override
	public Expression createVariableUse(VariableDeclaration _declaration) {
		return new VariableUseImpl(_declaration);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createVariableAssignment(fr.n7.stl.block.ast.VariableDeclaration)
	 */
	@Override
	public Assignable createVariableAssignment(VariableDeclaration _declaration) {
		return new VariableAssignmentImpl(_declaration);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createConditional(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Block, fr.n7.stl.block.ast.Block)
	 */
	@Override
	public Instruction createConditional(Expression _condition, Block _then, Block _else) {
		return new ConditionalImpl(_condition,_then,_else);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createRepetition(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Block)
	 */
	@Override
	public Instruction createRepetition(Expression _condition, Block _body) {
		return new RepetitionImpl(_condition,_body);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createBooleanType()
	 */
	@Override
	public Type createBooleanType() {
		return AtomicType.BooleanType;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createCoupleType(fr.n7.stl.block.ast.Type, fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type createCoupleType(Type _first, Type _second) {
		return new CoupleTypeImpl( _first, _second);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createCouple(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Expression createCouple(Expression _first, Expression _second) {
		return new CoupleImpl(_first, _second);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createPrinter(fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Instruction createPrinter(Expression _value) {
		return new PrinterImpl(_value);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createFirst(fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Expression createFirst(Expression _parameter) {
		return new UnaryExpressionImpl(UnaryOperator.First,_parameter);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createSecond(fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Expression createSecond(Expression _parameter) {
		return new UnaryExpressionImpl(UnaryOperator.Second,_parameter);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createAssignment(fr.n7.stl.block.ast.VariableDeclaration, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Instruction createAssignment(VariableDeclaration _declaration, Expression _value) {
		return new AssignmentImpl(_declaration,_value);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createAssignment(fr.n7.stl.block.ast.VariableDeclaration, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Instruction createAssignment(Assignable _assignable, Expression _value) {
		return new AssignmentImpl(_assignable,_value);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createBooleanValue(boolean)
	 */
	@Override
	public Value createBooleanValue(boolean _value) {
		if (_value) {
			return BooleanValue.True;
		} else {
			return BooleanValue.False;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createFunctionCall(fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public FunctionCall createFunctionCall(Expression _function) {
		return new FunctionCallImpl(_function);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createArrayAccess(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Expression createArrayAccess(Expression _array, Expression _index) {
		return new ArrayAccessImpl(_array,_index);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createArrayAssignment(fr.n7.stl.block.ast.Assignable, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Assignable createArrayAssignment(Assignable _array, Expression _index) {
		return new ArrayAssignmentImpl(_array,_index);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createFieldAccess(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.FieldDeclaration)
	 */
	@Override
	public Expression createFieldAccess(Expression _record, FieldDeclaration _field) {
		return new FieldAccessImpl(_record,_field);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createFieldAssignment(fr.n7.stl.block.ast.Assignable, fr.n7.stl.block.ast.FieldDeclaration)
	 */
	@Override
	public Assignable createFieldAssignment(Assignable _record, FieldDeclaration _field) {
		return new FieldAssignmentImpl(_record,_field);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createFieldAccess(fr.n7.stl.block.ast.Expression, java.lang.String)
	 */
	@Override
	public Expression createFieldAccess(Expression _record, String _name) {
		return new FieldAccessImpl(_record, _name);
	}
	
	@Override
	public Assignable createFieldAssignment(Assignable _record, String _name) {
		return new FieldAssignmentImpl(_record, _name);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createBlock()
	 */
	@Override
	public Block createBlock() {
		return createBlock((Block)null);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createBlock(java.lang.Iterable)
	 */
	@Override
	public Block createBlock(Iterable<Instruction> _content) {
		Block _local = createBlock();
		_local.addAll(_content);
		return _local;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createBlock(fr.n7.stl.block.ast.Block, java.lang.Iterable)
	 */
	@Override
	public Block createBlock(Block _context, Iterable<Instruction> _content) {
		Block _local = createBlock(_context);
		_local.addAll(_content);
		return _local;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createConditional(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Block)
	 */
	@Override
	public Instruction createConditional(Expression _condition, Block _then) {
		return new ConditionalImpl(_condition,_then);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createRecordType(java.lang.Iterable)
	 */
	@Override
	public RecordType createRecordType(String _name, Iterable<FieldDeclaration> _fields) {
		return new RecordTypeImpl(_name, _fields);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createRecordType()
	 */
	@Override
	public RecordType createRecordType(String _name) {
		return new RecordTypeImpl(_name);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createConstantDeclaration(java.lang.String, fr.n7.stl.block.ast.Type, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public ConstantDeclaration createConstantDeclaration(String _name, Type _type, Expression _value) {
		return new ConstantDeclarationImpl(_name,_type,_value);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createTypeDeclaration(java.lang.String, fr.n7.stl.block.ast.Type)
	 */
	@Override
	public TypeDeclaration createTypeDeclaration(String _name, Type _type) {
		return new TypeDeclarationImpl(_name,_type);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createArrayType(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type createArrayType(Type _element) {
		return new ArrayTypeImpl(_element);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createPointerType(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type createPointerType(Type _element) {
		return new PointerTypeImpl(_element);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createFunctionType(fr.n7.stl.block.ast.Type, java.lang.Iterable)
	 */
	@Override
	public Type createFunctionType(Type _result, Iterable<Type> _parameters) {
		return new FunctionTypeImpl(_result,_parameters);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createFieldDeclaration(java.lang.String, fr.n7.stl.block.ast.Type)
	 */
	@Override
	public FieldDeclaration createFieldDeclaration(String _name, Type _type) {
		return new FieldDeclarationImpl(_name,_type);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createTypeConversion(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Expression createTypeConversion(Expression _target, Type _type) {
		return new TypeConversionImpl(_target,_type);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createCollection()
	 */
	@Override
	public Sequence createSequence() {
		return new SequenceImpl();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createCollection(java.lang.Iterable)
	 */
	@Override
	public Sequence createSequence(Iterable<Expression> _values) {
		return new SequenceImpl(_values);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createNamedType(fr.n7.stl.block.ast.TypeDeclaration)
	 */
	@Override
	public Type createNamedType(TypeDeclaration _declaration) {
		return new NamedTypeImpl(_declaration);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createPointerAccess(fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Expression createPointerAccess(Expression _pointer) {
		return new PointerAccessImpl(_pointer);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createPointerAssignment(fr.n7.stl.block.ast.Assignable)
	 */
	@Override
	public Assignable createPointerAssignment(Assignable _pointer) {
		return new PointerAssignmentImpl(_pointer);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createFloatingType()
	 */
	@Override
	public Type createFloatingType() {
		return AtomicType.FloatingType;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createCharType()
	 */
	@Override
	public Type createCharType() {
		return AtomicType.CharacterType;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createStringType()
	 */
	@Override
	public Type createStringType() {
		return AtomicType.StringType;
	}

    public Expression createAddressAccess(Assignable _assignable) {
        return new AddressAccessImpl(_assignable);
    }

    public Expression createArrayAllocation(Type _type, Expression _array) {
        return new ArrayAllocationImpl(_array, _type);
    }

    public Expression createPointerAllocation(Type _type) {
        return new PointerAllocationImpl(_type);
    }

    /**
     * créer une interface avec un nom et une liste de méthodes
     */
	@Override
	public Interface createInterface(String _name, List<ElementInterface> _methodes) {
		return new InterfaceImpl(_name, _methodes);	
	}
	public Interface createInterface(String _name,List<Type> _types,List<ElementInterface> _elts){
		return new InterfaceImpl(_name,_types,_elts);
	}
	public Interface createInterface(String _name,List<ParametreGenericite> _param,List<Type> _types,List<ElementInterface> _elts){
		return new InterfaceImpl(_name,_param,_types,_elts);
	}
	@Override
	public ElementInterface createSignature(String _name, List<Parametre> _param){
		return new SignatureImpl(_name,_param);
	}
	@Override
	public ElementInterface createSignature(String _name,Type _type,List<Parametre> _param){
		return new SignatureImpl(_type,_name,_param);
	}
	public FinalStaticFieldImpl createFinalStaticField(String _name, Type _type, Expression _expr) {
		return new FinalStaticFieldImpl(_name, _type, _expr);
	}
	public ParametreGenericite createParametreGenericite(String _name, List<Objet> _param ){
		return new ParametreGenericiteImpl(_name,_param);
	}
	public ParametreGenericite createParametreGenericite( List<Objet> _param ){
		return new ParametreGenericiteImpl(_param);
	}

	public Type createTypeGenerique(String _name,List<ArgumentGenericite> _argGen){
		return new TypeGenericiteImpl(_name,_argGen);
	}
	
	public Classe createClasse(String _name,List<ElementClasse> _elts){
		return new ClasseImpl(_name,_elts);
	}
	
	public Classe createClasse(String _name,List<TypeInterface> _interfaces,List<ElementClasse> _elts){
		return new ClasseImpl(_name, _interfaces, _elts);	
	}
	public Classe createClasse(List<ParametreGenericite> _heritage,String _name,List<ElementClasse> _elts){
		return new ClasseImpl( _heritage,_name, _elts);	
	}
	
	public Classe createClasse(String _name,List<TypeObjet> _heritage,List<TypeInterface> _interfaces,  List<ElementClasse> _elts){
		return new ClasseImpl(_name,_heritage,_interfaces,_elts);
	}
	public Classe createClasse(List<ParametreGenericite> _genericite,  List<ElementClasse> _elts,String _name){
		return new ClasseImpl(_genericite,_elts,_name);
	}
	
	public Classe createClasse(List<ParametreGenericite> _genericite,List<TypeInterface> _interfaces,  List<ElementClasse> _elts,String _name){
		return new ClasseImpl(_genericite,_interfaces,_elts,_name);
	}
	
	public Classe createClasse(List<ParametreGenericite> _genericite,List<TypeObjet> _heritage,String _name,List<ElementClasse> _elts){
		return new ClasseImpl(_genericite,_heritage,_name,_elts);
	}
	
	public Classe createClasse(String _name,List<ParametreGenericite> _genericite,List<TypeObjet> _heritage,List<TypeInterface> _interfaces,List<ElementClasse> _elts){
		return new ClasseImpl(_name,_genericite,_heritage,_interfaces,_elts);
	}
	
	public ArgumentGenericite createArgumentGenericite(String _name){
		return new ArgumentGenericiteImpl(_name);
	}
	
	public ArgumentGenericite createArgumentGenericite(String _name,List<ArgumentGenericite> _inst){
		return new ArgumentGenericiteImpl(_name,_inst);
	}
	
	public DroitAcces createDroitAcces(int i ){
		switch (i) {
		case 0:
			return DroitAcces.publique;
		case 1:
			return DroitAcces.protege;
		case 2:
			return DroitAcces.prive;
		default:
			return null;
		}
	}       
	
	public ElementClasse createMethode(DroitAcces _droit,String _name,List<Parametre> _param, Block _bloc){
		return new Methode(_droit,_name,_param,_bloc);
	}
	
	public ElementClasse createAttribut(DroitAcces _droit,Type _type,String _name){
		return new Attribut(_droit,_type,_name);
	}
	
	public ElementClasse createMethode(DroitAcces _droit,Type _type,String _name,List<Parametre> _param, Block _bloc){
		return new Methode(_droit,_type,_param,_name,_bloc);
	}
	
	public ElementClasse createConstructeur(String _name,List<Parametre> _param,Expression _exp) {
		return new Constructeur(_name,_param,_exp);
	}
	
	public Parametre createParametre(Type _type,String _name){
		return new ParametreImpl(_type,_name);
	}
	
	public TypeObjet createTypeObjet(Declaration _decl){
		return new TypeObjetImpl(_decl);
	}
	
	public Type createTypeGenerique(Declaration _decl,List<ArgumentGenericite> _argGen){
		return new TypeGenericiteImpl(_decl,_argGen);
	}
	
}
