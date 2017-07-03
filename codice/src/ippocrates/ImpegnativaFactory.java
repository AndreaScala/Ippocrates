package ippocrates;

public class ImpegnativaFactory implements PrescriptionFactory {

	@Override
	public Prescrizione creaPrescrizione() {
		return new Impegnativa();
	}

}
