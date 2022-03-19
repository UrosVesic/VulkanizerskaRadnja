package auto_radnja.gume;

import javax.swing.JTextField;

/**
 * Predstavlja automobilsku gumu koja ima marku, precnik, sirinu i visinu
 * @author UrosVesic
 * @version 1.0
 */

public class AutoGuma {
	/**
	 * Marka i model gume
	 */
	private String markaModel = null;
	/**
	 * Precnik gume u incima
	 */
	private int precnik = -1;
	/**
	 * Sirina gume u mm
	 */
	private int sirina = -1;
	/**
	 * Visina gume u mm
	 */
	private int visina = -1;

	/**
	 * Default konstruktor klase AutoGuma.
	 * Postavlja vrednosti atributa na predefinisane vrednosti.
	 */
	public AutoGuma() {
	}
	
	/**
	 * 
	 * @param markaModel - nova marka i model
	 * @param precnik - novi precnik
	 * @param sirina - nova sirina
	 * @param visina - nova visina
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}
	
	/**
	 * Vraca marku i model gume
	 * @return String 
	 */
	public String getMarkaModel() {
		return markaModel;
		
	}
	
	/**
	 * Postavlja marku i model objektu this klase AutoGuma
	 * @param markaModel - nova marka i model gume
	 * @throws IllegalArgumentException ako je duzina naziva marke i modela kraca od 3 znaka
	 * @throws NullPointerException ako je uneta markaModel null
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}
	
	/**
	 * Vraca precnik gume
	 * @return int - precnik gume
	 */
	public int getPrecnik() {
		return precnik;
	}
	
	/**
	 * Postavlja precnik objektu this klase AutoGuma
	 * @param precnik - novi precnik gume
	 * @throws IllegalArgumentException ako je precik manji od 13 ili veci od 22
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}
	
	/**
	 * Vraca sirinu gume
	 * @return int - sirina gume
	 */
	public int getSirina() {
		return sirina;
	}
	
	/**
	 * Postavlja sirinu objektu this klase AutoGuma
	 * @param sirina - nova sirina gume
	 * @throws IllegalArgumentException ako je uneta sirina gume manja od 135 ili veca od 355
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}
	
	/**
	 * Vraca visinu gume
	 * @return int - visina gume
	 */
	public int getVisina() {
		return visina;
	}
	
	
	/**
	 * Postavlja visinu objektu this klase AutoGuma
	 * @param visina - nova visina gume
	 * @throws IllegalArgumentException ako je uneta visina gume manja od 25 ili veca od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}
	
	/**
	 * Vraca sve podatke o gumi u jednom String-u.
	 * 
	 * @return String sa svim podacima o gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}
	
	/**
	 * Poredi gume po atributima markaModel, precnik, visina i sirina
	 * @return 
	 * <ul>
	 * <li>true - ako su markaModel, visina, sirina i precnik isti</li>
	 * <li>false - ako to nije slucaj</li>
	 * </ul> 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}

}
