package predicate;

import term.Term;
import term.TermList;
import term.Variable;

public class Predicate implements Expr {

	private String string;
	private TermList termList;

	public Predicate(String string, TermList termList) {
		this.string = string;
		this.termList = termList;
	}

	@Override
	public Predicate substitute(Variable variable, Term term) {

		return new Predicate(string, termList.substitute(variable, term));
	}

	@Override
	public String toString() {

		return string + termList;
	}

}
