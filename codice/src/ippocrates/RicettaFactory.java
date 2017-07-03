package ippocrates;

public class RicettaFactory implements PrescriptionFactory {

	@Override
	public Prescrizione creaPrescrizione() {
		return new Ricetta();
	}

}
