package fr.loria.k.revisor.engine.revisorPCSFC.pcsfc;

import fr.loria.k.revisor.engine.revisorPCSFC.RevisorPCSFC;
import fr.loria.k.revisor.engine.revisorPCSFC.pclc.*;
import fr.loria.k.revisor.engine.revisorPCSFC.pcsfc.constraint.LeftMemberElementTerminal;
import fr.loria.k.revisor.engine.revisorPCSFC.pcsfc.constraint.OperatorMoreEquals;
import fr.loria.k.revisor.engine.revisorPCSFC.pcsfc.constraint.RightMember;
import fr.loria.k.revisor.engine.revisorPCSFC.pclc.*;


public class PCSFCBoolean extends PCSFCFormula {

	public static final int DELIMITER = 1;
	
	private final String name;
	
	public PCSFCBoolean(final String n) {
		this.name = n;
	}

	@Override
	public String toString(boolean latex) {
		if (latex) {
			return RevisorPCSFC.formatNameToLatex(this.name);
		}
		return this.name;
	}

	@Override
	public Formula toPCLC() {
		//Travail MAttthieu
		//return new PCSFCConstraint(new LeftMemberElementTerminal<Double>("integer_encoding_" + this.name), new OperatorMoreEquals(), new RightMember<Double>((double)DELIMITER));
		Variable bool = new IntegerVariable(this.name) ;
        Coefficients coefficients = new Coefficients() ;
        coefficients.put(bool, new RationalNumber(1.));
		return new Constraint(coefficients , new RationalNumber(1.)) ;
	}

	@Override
	public PCSFCFormula toPCSFC() {
		return new PCSFCBoolean(this.name);
	}
	
	@Override
	public boolean canRevise() {
		return false;
	}

}
