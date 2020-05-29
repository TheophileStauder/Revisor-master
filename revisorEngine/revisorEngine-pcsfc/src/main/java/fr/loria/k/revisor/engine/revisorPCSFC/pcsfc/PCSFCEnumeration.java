package fr.loria.k.revisor.engine.revisorPCSFC.pcsfc;

import java.util.ArrayList;

import java.util.Collection;

import fr.loria.k.revisor.engine.revisorPCSFC.RevisorPCSFC;
import fr.loria.k.revisor.engine.revisorPCSFC.pclc.*;
public class PCSFCEnumeration extends PCSFCFormula {

	private String name;
	private String modality;
	private ArrayList<String> unusedModalities;
	
	public PCSFCEnumeration(String n, String mod, Collection<String> um) {
		this.name = n;
		this.modality = mod;
		this.unusedModalities = new ArrayList<>(um);
		this.unusedModalities.remove(this.modality);
	}

	@Override
	public String toString(boolean latex) {
		if (latex) {
			return " \\:" + RevisorPCSFC.formatNameToLatex(this.name) + "\\: = \\:" + this.modality;
		}
		return " " + this.name + " = " + this.modality;
	}

	@Override
	public boolean canRevise() {
		return false;
	}

	@Override
	public Formula toPCLC() {
		/*PCSFCFormula pclc;
		String modalityWithoutQuotes = this.modality.replace("\"", "");
		pclc = new PCSFCBoolean("boolean_encoding_" + modalityWithoutQuotes).toPCLC();
		for (String s: this.unusedModalities) {
			modalityWithoutQuotes = s.replace("\"", "");
			pclc = new PCSFCAnd(pclc, new PCSFCNot(new PCSFCBoolean("boolean_encoding_" + modalityWithoutQuotes).toPCLC()));
		}
		return pclc;*/

		/*For each element of enumeration , we convert it into boolean
		then convert the PCSFC boolean to PCLC constraint

		We initiliaze the result formula by create an AND between the two first element of the enumeration*/

		int size = unusedModalities.size();
		String modalityWithoutQuotesFirstElement = unusedModalities.get(0).replace("\"", "");
		String modalityWithoutQuotesSecondElement = unusedModalities.get(1).replace("\"", "");
		Formula pclc = new And(new Not(new PCSFCBoolean("boolean_encoding_" + modalityWithoutQuotesFirstElement).toPCLC()),new Not(new PCSFCBoolean("boolean_encoding_" + modalityWithoutQuotesSecondElement).toPCLC()));
		int i = 0;
		for (String s: this.unusedModalities) {
			if (i>1) {
				String modalityWithoutQuotes = s.replace("\"", "");
				pclc = new And(pclc, new Not(new PCSFCBoolean("boolean_encoding_" + modalityWithoutQuotes).toPCLC()));
			}
			i++;
		}
		// Théophile
		//retourne tout les booleen.PCLC
		return pclc;
	}
	
	@Override
	public PCSFCFormula toPCSFC() {
		return new PCSFCEnumeration(this.name, this.modality, this.unusedModalities);
	}

}
