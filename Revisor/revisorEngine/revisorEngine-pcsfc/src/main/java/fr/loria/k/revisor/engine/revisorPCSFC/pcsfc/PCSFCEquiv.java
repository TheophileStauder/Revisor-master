package fr.loria.k.revisor.engine.revisorPCSFC.pcsfc;


import fr.loria.k.revisor.engine.revisorPCSFC.pclc.*;

public class PCSFCEquiv extends PCSFCBinaryFormula {

	public static final String LATEX_EQUIV_SYMBOL = "{\\Leftrightarrow}";
	public static final String EQUIV_SYMBOL = "EQUIV";
	
	public PCSFCEquiv(PCSFCFormula lc, PCSFCFormula rc) {
		super(lc, rc);
	}

	@Override
	public Formula toPCLC() {
		
		// A <=> B equivaut à B=>A et A=>B
		return new And( new Or(this.rightChild.toPCLC(),new Not(this.leftChild.toPCLC())) , new Or(this.leftChild.toPCLC(),new Not(this.rightChild.toPCLC())));
		//Travail Matthieu
		//return new PCSFCAnd(new PCSFCImpl(this.leftChild, this.rightChild).toPCLC(), new PCSFCImpl(this.rightChild, this.leftChild).toPCLC());
	}

	@Override
	public PCSFCFormula toPCSFC() {
		return new PCSFCEquiv(this.leftChild.toPCSFC(), this.rightChild.toPCSFC());
	}
	
	@Override
	public boolean canRevise() {
		return false;
	}
	
	@Override
	public String operator(boolean latex) {
		if (latex) {
			return "\\:" + LATEX_EQUIV_SYMBOL + "\\:";
		}
		return EQUIV_SYMBOL;
	}

}
