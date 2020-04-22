package regressionTestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class TC001 extends RegressionTestCasesBaseClass {

	@Test(dataProvider = "sectionName")
	void TC001_Step01(String secName, String subSecName) {
		System.out.println(secName + "SreeTest");
		assertTrue(obj_HomePage.selectSection(secName, subSecName));
	}

	@DataProvider(name = "sectionName")
	Object[][] sectionName() {
		return new Object[][] {{"Men", "Inner Wear Tops"},
			{"Women", "Leggings"},
			{"Boys", "Inner Wear Tops"},
			/*{"New Arrivals", "Girls"}*/};	
	}
}
