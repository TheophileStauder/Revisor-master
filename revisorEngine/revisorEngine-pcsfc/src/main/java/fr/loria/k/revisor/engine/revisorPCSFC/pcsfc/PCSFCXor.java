package fr.loria.k.revisor.engine.revisorPCSFC.pcsfc;


import fr.loria.k.revisor.engine.revisorPCSFC.pclc.*;


public class PCSFCXor extends PCSFCBinaryFormula {

	public static final String LATEX_XOR_SYMBOL = "{\\oplus}";
	public static final String XOR_SYMBOL = "XOR";
	
	public PCSFCXor(PCSFCFormula lc, PCSFCFormula rc) {
		super(lc, rc);
	}

	@Override
	public Formula toPCLC() {
		return new Or(new And(this.leftChild.toPCLC(), new Not(this.rightChild.toPCLC())), new And(new Not(this.leftChild.toPCLC()), this.rightChild.toPCLC()));
	}

	@Override
	public PCSFCFormula toPCSFC() {
		return new PCSFCXor(this.leftChild.toPCSFC(), this.rightChild.toPCSFC());
	}
	
	@Override
	public boolean canRevise() {
		return false;
	}
	
	@Override
	public String operator(boolean latex) {
		if (latex) {
			return "\\:" + LATEX_XOR_SYMBOL + "\\:";
		}
		return XOR_SYMBOL;
	}

}
