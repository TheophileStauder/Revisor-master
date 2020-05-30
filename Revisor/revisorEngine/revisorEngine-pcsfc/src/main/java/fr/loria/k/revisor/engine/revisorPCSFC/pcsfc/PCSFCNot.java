package fr.loria.k.revisor.engine.revisorPCSFC.pcsfc;



import fr.loria.k.revisor.engine.revisorPCSFC.pclc.*;


public class PCSFCNot extends PCSFCUnaryFormula {

	public static final String LATEX_NOT_SYMBOL = "{\\neg}";
	public static final String NOT_SYMBOL = "NOT";
	
	public PCSFCNot(PCSFCFormula f) {
		super(f);
	}

	@Override
	public Formula toPCLC() {
		return new Not(this.child.toPCLC());
	}

	@Override
	public PCSFCFormula toPCSFC() {
		return new PCSFCNot(this.child.toPCSFC());
	}
	
	@Override
	public boolean canRevise() {
		return this.child.canRevise();
	}

	@Override
	public String operator(boolean latex) {
		if (latex) {
			return LATEX_NOT_SYMBOL;
		}
		return NOT_SYMBOL;
	}

}
