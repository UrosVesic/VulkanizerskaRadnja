package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import auto_radnja.gume.AutoGuma;



class AutoGumaTest {

	private AutoGuma ag;

	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void testAutoGuma() {
		assertTrue(ag != null);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Michelin Alpin 5", 16, 205, 65);
		assertEquals(16, ag.getPrecnik());
		assertEquals(205, ag.getSirina());
		assertEquals(65, ag.getVisina());
		assertEquals("Michelin Alpin 5", ag.getMarkaModel());
	}

	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Michelin Aplin 5");
		assertEquals("Michelin Aplin 5", ag.getMarkaModel());
	}

	@Test
	void testSetMarkaModelPrazanString() {
		assertThrows(NullPointerException.class, () -> ag.setMarkaModel(null));
	}

	@Test
	void testSetMarkaModelDuzina() {
		assertThrows(IllegalArgumentException.class, () -> ag.setMarkaModel("AA"));
		assertThrows(IllegalArgumentException.class, () -> ag.setMarkaModel("A"));
		assertThrows(IllegalArgumentException.class, () -> ag.setMarkaModel(""));
	}

	@ParameterizedTest
	@CsvSource({ "13", "14", "15", "16","17", "18", "19", "20","21","22" })
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);
		assertEquals(precnik, ag.getPrecnik());
	}
	
	@ParameterizedTest
	@CsvSource({ "25", "35", "45", "46","57", "68", "79", "85","95" })
	void testSetVisina(int visina) {
		ag.setVisina(visina);
		assertEquals(visina, ag.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({ "135", "145", "155", "165","175", "185", "195", "205","215","225" })
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);
		assertEquals(sirina, ag.getSirina());
	}
	
	@Test
	void testSetPrecnikVanOpsega() {
		assertThrows(IllegalArgumentException.class, ()->ag.setPrecnik(10));
	}
	
	@Test
	void testSetSirinaVanOpsega() {
		assertThrows(IllegalArgumentException.class, ()->ag.setVisina(405));
	}
	
	@Test
	void testSetVisinaVanOpsega() {
		assertThrows(IllegalArgumentException.class, ()->ag.setSirina(105));
	}
	@Test
	void testToString() {
		ag.setMarkaModel("Michelin Alpin5");
		ag.setSirina(300);
		ag.setVisina(55);
		ag.setPrecnik(16);
		
		String s = ag.toString();
		assertTrue(s.contains(ag.getMarkaModel()));
		assertTrue(s.contains(ag.getPrecnik()+""));
		assertTrue(s.contains(ag.getVisina()+""));
		assertTrue(s.contains(ag.getSirina()+""));
	}
	
	@ParameterizedTest
	@CsvSource({
			"MM1, MM1, 16, 16, 45,45,200,200,true",
			
			"MM1, MM2, 16, 16, 45,45,200,200,false",
			"MM1, MM1, 16, 17, 45,45,200,200,false",
			"MM1, MM1, 16, 16, 45,50,200,200,false",
			"MM1, MM1, 16, 16, 45,45,210,200,false",
			
			"MM1, MM1, 16, 16, 45,50,210,200,false",
			"MM1, MM1, 16, 17, 45,45,210,200,false",
			"MM1, MM1, 16, 17, 45,46,200,200,false",
			"MM1, MM2, 16, 16, 45,45,210,200,false",
			"MM1, MM2, 16, 16, 45,50,200,200,false",
			"MM1, MM2, 16, 17, 45,45,200,200,false",
			
			"MM1, MM2, 16, 16, 45,45,200,200,false",
			"MM1, MM1, 16, 17, 45,45,200,200,false",
			"MM1, MM1, 16, 16, 45,50,200,200,false",
			"MM1, MM1, 16, 16, 45,45,200,210,false",
			
			"MM1, MM2, 16, 17, 45,50,200,210,false",
			
	})
	void testEquals(String markaModel1, String markaModel2,
			int precnik1, int precnik2, int visina1, int visina2, int sirina1, int sirina2,boolean equals) {
		ag.setMarkaModel(markaModel1);
		ag.setPrecnik(precnik1);
		ag.setSirina(sirina1);
		ag.setVisina(visina1);
		
		AutoGuma ag2 = new AutoGuma(markaModel2, precnik2, sirina2, visina2);
		
		assertEquals(equals, ag.equals(ag2));
		
	}
	
	@Test
	void testEquals2() {
		AutoGuma ag2 = ag;
		assertEquals(true, ag.equals(ag2));
	}
	
	

}
