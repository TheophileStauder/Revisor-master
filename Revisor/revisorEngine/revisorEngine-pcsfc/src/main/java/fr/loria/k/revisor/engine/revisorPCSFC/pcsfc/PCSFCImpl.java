package fr.loria.k.revisor.engine.revisorPCSFC.pcsfc;


import fr.loria.k.revisor.engine.revisorPCSFC.pclc.*;


public class PCSFCImpl extends PCSFCBinaryFormula {

	public static final String LATEX_IMPLICATION_SYMBOL = "{\\Rightarrow}";
	public static final String IMPLICATION_SYMBOL = "IMPLIES";
	
	public PCSFCImpl(PCSFCFormula lc, PCSFCFormula rc) {
		super(lc, rc);
	}

	@Override
	public Formula toPCLC() {
		return  new Or(this.rightChild.toPCLC(),new Not(this.leftChild.toPCLC()));
	}

	@Override
	public PCSFCFormula toPCSFC() {
		return new PCSFCImpl(this.leftChild.toPCSFC(), this.rightChild.toPCSFC());
	}
	
	@Override
	public boolean canRevise() {
		return false;
	}

	@Override
	public String operator(boolean latex) {
		if (latex) {
			return "\\:" + LATEX_IMPLICATION_SYMBOL + "\\:";
		}
		return IMPLICATION_SYMBOL;
	}
	
}
