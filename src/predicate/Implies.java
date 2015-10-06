package predicate;

import term.Term;
import term.Variable;

public class Implies implements Expr {

	private Predicate p1;
	private Predicate p2;

	public Implies(Predicate p1, Predicate p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		
	}

	@Override
	public Expr substitute(Variable variable, Term term) {
		return new Implies(p1.substitute(variable, term), p2.substitute(variable, term));
	}
	
	public String toString(){
		return p1+" -> "+ p2;
		
	}
}
