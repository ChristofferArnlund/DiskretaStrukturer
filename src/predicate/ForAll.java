package predicate;

import java.util.HashSet;

import term.Term;
import term.Variable;

public class ForAll implements Expr{

	private Variable var;
	private Predicate pz;
	public ForAll(Variable var, Predicate pz) {
		this.var = var;
		this.pz = pz;
	}

	@Override
	public Expr substitute(Variable variable, Term term) {
	if(var.equals(variable)){
		return this;
	}else if(!term.collectVariables(new HashSet<Variable>()).contains(var)){
		return new ForAll(var,pz.substitute(variable, term));
	}else{
		Variable v = new Variable();
		return new ForAll(v, pz.substitute(var, v).substitute(variable, term));
	}
	
	}
	public String toString(){
		return "FORALL(" + var +") ."+ pz;
	}


}
