package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

class RadnjaTest {

	protected Radnja radnja;

	@Test
	void testDodajGumu() {
		AutoGuma ag = new AutoGuma("Michelin Alpin 5", 16, 200, 50);
		radnja.dodajGumu(ag);
		
		assertEquals(radnja.vratiSveGume().size(), 1);
		assertEquals(radnja.vratiSveGume().get(0), ag);
	}
	
	@Test
	void testDodajGumuViseGuma() {
		AutoGuma ag = new AutoGuma("Michelin Alpin 5", 16, 200, 50);
		radnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma("Michelin Alpin 6", 17, 220, 60);
		radnja.dodajGumu(ag2);
		
		assertEquals(radnja.vratiSveGume().size(), 2);
		assertTrue(radnja.vratiSveGume().contains(ag));
		assertTrue(radnja.vratiSveGume().contains(ag2));
	}
	
	@Test
	void testDodajGumuNullGuma() {
		assertThrows(NullPointerException.class, () -> radnja.dodajGumu(null));
	}
	
	@Test
	void testDodajGumuPostojeca() {
		AutoGuma ag = new AutoGuma("Michelin Alpin 5", 16, 200, 50);
		radnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma("Michelin Alpin 5", 16, 200, 50);
		assertThrows(RuntimeException.class, () -> radnja.dodajGumu(ag2));
	}
	
	@Test
	void testPronadjuGumuJedanRezultat() {
		AutoGuma ag = new AutoGuma("Michelin Alpin 5", 16, 200, 50);
		radnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma("Michelin Alpin 6", 17, 220, 60);
		radnja.dodajGumu(ag2);
		
		List<AutoGuma> lista = radnja.pronadjiGumu("Michelin Alipin 6");
		
		assertEquals(1, lista.size());
		assertTrue(lista.contains(ag2));
	}
	
	@Test
	void testPronadjuGumuViseRezultata() {
		AutoGuma ag = new AutoGuma("Michelin Alpin 5", 16, 200, 50);
		radnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma("Michelin Alpin 6", 17, 220, 60);
		radnja.dodajGumu(ag2);
		
		AutoGuma ag3 = new AutoGuma("Michelin Alpin 6", 18, 230, 60);
		radnja.dodajGumu(ag3);
		
		List<AutoGuma> lista = radnja.pronadjiGumu("Michelin Alipin 6");
		
		assertEquals(2, lista.size());
		assertTrue(lista.contains(ag2));
		assertTrue(lista.contains(ag3));
	}
	
	@Test
	void testPronadjiGumuNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiNijedanRezultat() {
		AutoGuma ag = new AutoGuma("Michelin Alpin 5", 16, 200, 50);
		radnja.dodajGumu(ag);
		
		assertEquals(0, radnja.pronadjiGumu("Michelin Alpin 6"));
	}
	
	@Test
	void testVratiSveGume() {
		AutoGuma ag = new AutoGuma("Michelin Alpin 5", 16, 200, 50);
		radnja.dodajGumu(ag);
		
		assertEquals(1, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(ag));
	}

}
