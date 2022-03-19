package auto_radnja;

import java.util.List;
import auto_radnja.gume.AutoGuma;

/**
 * 
 * Predstavlja radnju koja skladisti gume.
 * Sadrzi operacije dodavanja, pretrage i vracanja svih guma.
 * @version 1.0
 * @author UrosVesic
 *
 */
public interface Radnja {
	
	/**
	 * Dodaje novu automobilsku gumu u radnju ukoliko ona vec ne postoji u radnji.
	 * @param a - Nova automobilska guma koja se dodaje
	 * @throws NullPointerException  ako je uneta guma null
	 * @throws RuntimeException  ako uneta guma vec postoji u radnji
	 */
	void dodajGumu(AutoGuma a);
	
	/**
	 * Pretrazuje sve gume koje imaju odgovarajucu marku i model.
	 * @param markaModel - marka i model po kojoj se guma pretrazuje
	 * @return Lista guma koje odgovaraju unetoj marci i modelu
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);

	/**
	 * Vraca sve auto gume koje se nalaze u radnji.
	 * @return Lista svih automobilskih guma u radnji.
	 */
	List<AutoGuma> vratiSveGume();
}
