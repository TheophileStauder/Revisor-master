package fr.loria.k.revisor.engine.revisorPCSFC.console.instruction;

import java.util.ArrayList;
import fr.loria.k.revisor.engine.revisorPCSFC.pclc.*;
import java.util.Collection;
import java.util.Collections;

import fr.loria.k.revisor.engine.revisorPCSFC.RevisorEnginePCSFC;
import fr.loria.k.revisor.engine.revisorPCSFC.console.AbstractRevisorConsolePCSFC;
import fr.loria.k.revisor.engine.revisorPCSFC.console.RevisorConsolePCSFC;
import fr.loria.k.revisor.engine.revisorPCSFC.console.config.PCSFCConfig;
import fr.loria.k.revisor.engine.revisorPCSFC.console.tos.ConstantSymbol;
import fr.loria.k.revisor.engine.revisorPCSFC.console.tos.EnumSymbol;
import fr.loria.k.revisor.engine.revisorPCSFC.console.tos.Symbol;
import fr.loria.k.revisor.engine.revisorPCSFC.console.tos.TableOfSymbols;
import fr.loria.k.revisor.engine.revisorPCSFC.console.tos.VariableType;
import fr.loria.k.revisor.engine.revisorPCSFC.pcsfc.PCSFCFormulaVariableList;
import fr.loria.orpailleur.revisor.engine.core.console.RevisorConsole;
import fr.loria.orpailleur.revisor.engine.core.console.exception.InstructionExecutionException;
import fr.loria.orpailleur.revisor.engine.core.console.exception.InstructionValidationException;
import fr.loria.orpailleur.revisor.engine.core.console.instruction.AbstractInstruction;
import fr.loria.orpailleur.revisor.engine.core.console.instruction.Instruction;
import fr.loria.k.revisor.engine.revisorPCSFC.pcsfc.PCSFCFormula;

public class PCSFC_PrintFormulaPCLC<C extends RevisorConsole<C, ?, ?, ?>> extends AbstractInstruction<C> {
	
	/**
	 * Class to display on the console  all formula in PCLC formalism 
	 * Author :Théophile Stauder
	 */
	private static final String FORMULA_PCLC = "\nFormula printed in PCLC .";
	
	protected PCSFC_PrintFormulaPCLC(C console, String inputText) {
		super(console, inputText);
		System.out.println("Bien ICIp");
	}



	@Override
	protected void doValidate() throws InstructionValidationException {
		// Nothing to do here.
	}

	@Override
	protected void doExecute() throws InstructionExecutionException {
		// Nothing to do here.
	
	}

	
	@Override
	protected String createFormatedInputText() {
		return this.simplifiedString(this.inputText);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected String createOutput(boolean latex) {
		
		ArrayList<Symbol> variableNames = TableOfSymbols.getInstance().getAllSymbols();
		StringBuilder res = new StringBuilder();
		for (Symbol s:  variableNames) {
			if (s.getVariableType() == VariableType.FORMULA) {
				PCSFCFormula formule = PCSFCFormulaVariableList.getInstance().getFormulaByIdentifier(s.getSymbolName());
				Formula f = formule.toPCLC();
				res.append(f.toString());
			}
		}
		return "Hello" + res;
	}
	
	@Override
	protected String createOutputText() {
		return this.createOutput(false) + FORMULA_PCLC;
	}

}