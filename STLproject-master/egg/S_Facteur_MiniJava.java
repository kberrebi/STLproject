package egg;
import java.util.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import fr.n7.stl.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_Facteur_MiniJava {
LEX_MiniJava scanner;
  S_Facteur_MiniJava() {
	}
  S_Facteur_MiniJava(LEX_MiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Expression att_ast;
  SymbolTable att_tdsAtt;
  LEX_MiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsInterface;
  SymbolTable att_tdsMethodes;
  String att_nomClasse;
  private void regle79() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Type_MiniJava x_3 = new S_Type_MiniJava(scanner,att_eval) ;
	S_SuiteNouveau_MiniJava x_5 = new S_SuiteNouveau_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_79(x_3, x_5);
	x_2.analyser(LEX_MiniJava.token_nouveau);
	x_3.analyser() ;
if  (att_eval)	  action_type_79(x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_79(x_3, x_5);
  }
  private void regle80() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expression_MiniJava x_3 = new S_Expression_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_80(x_3);
	x_2.analyser(LEX_MiniJava.token_parenthese_ouvrante);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_parenthese_fermante);
if  (att_eval)	  action_ast_80(x_3);
  }
  private void regle76() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Facteur_MiniJava x_3 = new S_Facteur_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_76(x_3);
	x_2.analyser(LEX_MiniJava.token_soustraction);
	x_3.analyser() ;
if  (att_eval)	  action_ast_76(x_3);
  }
  private void regle87() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	T_MiniJava x_3 = new T_MiniJava(scanner ) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	S_AppelOuAcces_MiniJava x_6 = new S_AppelOuAcces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_87(x_2, x_4, x_6);
	x_2.analyser(LEX_MiniJava.token_identificateur_type);
	x_3.analyser(LEX_MiniJava.token_point);
	x_4.analyser(LEX_MiniJava.token_identificateur);
if  (att_eval)	  action_inh_87(x_2, x_4, x_6);
	x_6.analyser() ;
if  (att_eval)	  action_ast_87(x_2, x_4, x_6);
  }
  private void regle75() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Expressions_MiniJava x_3 = new S_Expressions_MiniJava(scanner,att_eval) ;
	T_MiniJava x_4 = new T_MiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_75(x_3);
	x_2.analyser(LEX_MiniJava.token_accolade_ouvrante);
	x_3.analyser() ;
	x_4.analyser(LEX_MiniJava.token_accolade_fermante);
if  (att_eval)	  action_ast_75(x_3);
  }
  private void regle78() throws Exception {

	//declaration
	S_Valeur_MiniJava x_2 = new S_Valeur_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_78(x_2);
	x_2.analyser() ;
if  (att_eval)	  action_ast_78(x_2);
  }
  private void regle77() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_Facteur_MiniJava x_3 = new S_Facteur_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_77(x_3);
	x_2.analyser(LEX_MiniJava.token_negation);
	x_3.analyser() ;
if  (att_eval)	  action_ast_77(x_3);
  }
  private void regle88() throws Exception {

	//declaration
	T_MiniJava x_2 = new T_MiniJava(scanner ) ;
	S_AppelOuAcces_MiniJava x_4 = new S_AppelOuAcces_MiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_88(x_2, x_4);
	x_2.analyser(LEX_MiniJava.token_identificateur);
if  (att_eval)	  action_inh_88(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_88(x_2, x_4);
  }
private void action_type_79(S_Type_MiniJava x_3, S_SuiteNouveau_MiniJava x_5) throws Exception {
try {
// instructions
x_5.att_type=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#type","Facteur -> nouveau Type #type SuiteNouveau #ast ;", e });
}
  }
private void action_ast_80(S_Expression_MiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> parenthese_ouvrante Expression parenthese_fermante #ast ;", e });
}
  }
private void action_ast_75(S_Expressions_MiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> accolade_ouvrante Expressions accolade_fermante #ast ;", e });
}
  }
private void action_ast_76(S_Facteur_MiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createUnaryExpression(UnaryOperator.Opposite, x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> soustraction Facteur1 #ast ;", e });
}
  }
private void action_ast_87(T_MiniJava x_2, T_MiniJava x_4, S_AppelOuAcces_MiniJava x_6) throws Exception {
try {
// instructions
this.att_ast=x_6.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> identificateur_type point identificateur #inh AppelOuAcces #ast ;", e });
}
  }
private void action_ast_77(S_Facteur_MiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createUnaryExpression(UnaryOperator.Negate, x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> negation Facteur1 #ast ;", e });
}
  }
private void action_ast_88(T_MiniJava x_2, S_AppelOuAcces_MiniJava x_4) throws Exception {
try {
// locales
AppelOuAcces loc_ap;
// instructions
if (x_4.att_ast instanceof AppelOuAcces ){
loc_ap=((AppelOuAcces)x_4.att_ast);
loc_ap.setStatic(false);
this.att_ast=loc_ap;
}
else if (x_4.att_ast instanceof VariableUseImpl ){
this.att_ast=((VariableUseImpl)x_4.att_ast);
}
else if (x_4.att_ast instanceof AttributUseImpl ){
this.att_ast=((AttributUseImpl)x_4.att_ast);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Facteur_identificateur, MiniJavaMessages.Facteur_identificateur,new Object[]{""+" ap_o_acc should be an appelOuAcces or a VaraibleUse"});


}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> identificateur #inh AppelOuAcces #ast ;", e });
}
  }
private void action_ast_78(S_Valeur_MiniJava x_2) throws Exception {
try {
// instructions
this.att_ast=x_2.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> Valeur #ast ;", e });
}
  }
private void action_ast_79(S_Type_MiniJava x_3, S_SuiteNouveau_MiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#ast","Facteur -> nouveau Type #type SuiteNouveau #ast ;", e });
}
  }
private void action_inh_87(T_MiniJava x_2, T_MiniJava x_4, S_AppelOuAcces_MiniJava x_6) throws Exception {
try {
// locales
Optional<Declaration> loc_o;
Declaration loc_d;
// instructions
if (this.att_tdsAttributs.contains(x_4.att_txt, x_2.att_txt)){
loc_o=this.att_tdsAttributs.get(((x_2.att_txt+".")+x_4.att_txt));
loc_d=loc_o.get();
x_6.att_decl=loc_d;
x_6.att_support=this.att_factory.createStaticFieldUse(loc_d);
}
else if (this.att_tdsMethodes.contains(x_4.att_txt, x_2.att_txt)){
loc_o=this.att_tdsMethodes.get(((x_2.att_txt+".")+x_4.att_txt));
loc_d=loc_o.get();
x_6.att_decl=loc_d;
x_6.att_support=this.att_factory.createStaticFieldUse(loc_d);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Programme_undeclared_variable, MiniJavaMessages.Programme_undeclared_variable,new Object[]{""+((((" variable "+x_2.att_txt)+".")+x_4.att_txt)+" non déclaree")});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Facteur -> identificateur_type point identificateur #inh AppelOuAcces #ast ;", e });
}
  }
private void action_auto_inh_75(S_Expressions_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_3.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_3.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> accolade_ouvrante Expressions accolade_fermante #ast ;", e });
}
  }
private void action_auto_inh_76(S_Facteur_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_3.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_3.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> soustraction Facteur1 #ast ;", e });
}
  }
private void action_auto_inh_87(T_MiniJava x_2, T_MiniJava x_4, S_AppelOuAcces_MiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tdsClasses=this.att_tdsClasses;
x_6.att_tdsInterface=this.att_tdsInterface;
x_6.att_tdsMethodes=this.att_tdsMethodes;
x_6.att_tdsAttributs=this.att_tdsAttributs;
x_6.att_tds=this.att_tds;
x_6.att_tdsAtt=this.att_tdsAtt;
x_6.att_factory=this.att_factory;
x_6.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> identificateur_type point identificateur #inh AppelOuAcces #ast ;", e });
}
  }
private void action_auto_inh_77(S_Facteur_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_3.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_3.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> negation Facteur1 #ast ;", e });
}
  }
private void action_auto_inh_88(T_MiniJava x_2, S_AppelOuAcces_MiniJava x_4) throws Exception {
try {
// instructions
x_4.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsInterface=this.att_tdsInterface;
x_4.att_tdsMethodes=this.att_tdsMethodes;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tds=this.att_tds;
x_4.att_tdsAtt=this.att_tdsAtt;
x_4.att_factory=this.att_factory;
x_4.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> identificateur #inh AppelOuAcces #ast ;", e });
}
  }
private void action_auto_inh_78(S_Valeur_MiniJava x_2) throws Exception {
try {
// instructions
x_2.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsInterface=this.att_tdsInterface;
x_2.att_tdsMethodes=this.att_tdsMethodes;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_2.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> Valeur #ast ;", e });
}
  }
private void action_auto_inh_79(S_Type_MiniJava x_3, S_SuiteNouveau_MiniJava x_5) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_5.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_5.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_5.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_5.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
x_5.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
x_5.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> nouveau Type #type SuiteNouveau #ast ;", e });
}
  }
private void action_inh_88(T_MiniJava x_2, S_AppelOuAcces_MiniJava x_4) throws Exception {
try {
// locales
Optional<Declaration> loc_o;
Declaration loc_d;
// instructions
if (this.att_tds.knows(x_2.att_txt)){
loc_o=this.att_tds.get(x_2.att_txt);
loc_d=loc_o.get();
x_4.att_decl=loc_d;
if (loc_d instanceof VariableDeclaration ){
x_4.att_support=this.att_factory.createVariableUse(((VariableDeclaration)loc_d));
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_NOT_A_VARIABLE_DECLARATION, MiniJavaMessages.NOT_A_VARIABLE_DECLARATION,new Object[]{""+"should be a variable declaration"});


}
}
else if (this.att_tdsAttributs.contains(x_2.att_txt, this.att_nomClasse)){
loc_o=this.att_tdsAttributs.get(((this.att_nomClasse+".")+x_2.att_txt));
loc_d=loc_o.get();
x_4.att_decl=loc_d;
if (loc_d instanceof Attribut ){
x_4.att_support=this.att_factory.createAttributUse(((Attribut)loc_d));
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_NOT_AN_ATTRIBUT, MiniJavaMessages.NOT_AN_ATTRIBUT,new Object[]{""+" should be an attribut"});


}
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IMiniJavaMessages.id_Programme_undeclared_variable, MiniJavaMessages.Programme_undeclared_variable,new Object[]{""+((" variable "+x_2.att_txt)+" non déclaree")});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#inh","Facteur -> identificateur #inh AppelOuAcces #ast ;", e });
}
  }
private void action_auto_inh_80(S_Expression_MiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsInterface=this.att_tdsInterface;
x_3.att_tdsMethodes=this.att_tdsMethodes;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tds=this.att_tds;
x_3.att_tdsAtt=this.att_tdsAtt;
x_3.att_factory=this.att_factory;
x_3.att_nomClasse=this.att_nomClasse;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "MiniJava", "#auto_inh","Facteur -> parenthese_ouvrante Expression parenthese_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_MiniJava.token_accolade_ouvrante : // 53
        regle75 () ;
      break ;
      case LEX_MiniJava.token_soustraction : // 70
        regle76 () ;
      break ;
      case LEX_MiniJava.token_negation : // 76
        regle77 () ;
      break ;
      case LEX_MiniJava.token_entier : // 106
        regle78 () ;
      break ;
      case LEX_MiniJava.token_vrai : // 78
        regle78 () ;
      break ;
      case LEX_MiniJava.token_faux : // 79
        regle78 () ;
      break ;
      case LEX_MiniJava.token_chaine : // 104
        regle78 () ;
      break ;
      case LEX_MiniJava.token_caractere : // 105
        regle78 () ;
      break ;
      case LEX_MiniJava.token_nouveau : // 83
        regle79 () ;
      break ;
      case LEX_MiniJava.token_parenthese_ouvrante : // 57
        regle80 () ;
      break ;
      case LEX_MiniJava.token_identificateur_type : // 108
        regle87 () ;
      break ;
      case LEX_MiniJava.token_identificateur : // 107
        regle88 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IMiniJavaMessages.id_MiniJava_unexpected_token,MiniJavaMessages.MiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }