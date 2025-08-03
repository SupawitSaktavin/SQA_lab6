package sqa.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.TVPlan.TVPackage;

class test_EEDT {
	TVPlan test;

	@ParameterizedTest
	@CsvSource({
	"M1, A3, true, 300",
	"M1, A3, false, 350",
	"M1, A1, true, 200",
	"M1, A1, false, 250",
	"M1, A2, true, 200",
	"M1, A2, false, 250",
	"M1, A0, true, 100",
	"M1, A0, false, 150",
	
	"M2, A3, true, 500",
	"M2, A3, false, 550",
	"M2, A1, true, 400",
	"M2, A1, false, 450",
	"M2, A2, true, 400",
	"M2, A2, false, 450",
	"M2, A0, true, 300",
	"M2, A0, false, 350",
	
	"M3, A3, true, 600",
	"M3, A3, false, 650",
	"M3, A1, true, 500",
	"M3, A1, false, 550",
	"M3, A1, true, 500",
	"M3, A1, false, 550",
	"M3, A0, true, 400",
	"M3, A0, false, 450",
	
	"M0, A0, false, 0",
	"M4, A3, true, 0",
	"M5, A1, true, 0",
	})
	void test_Extended_Entry_Decision_Table(String mainPackage, String additionalPackage, boolean discount, double totalPrice) {
		boolean offline_watching = false;
		boolean live_service = false;
		TVPackage selectedPackage = null;
		
		if (mainPackage.equals("M1")) {
			selectedPackage = TVPackage.STANDARD;
		}else if (mainPackage.equals("M2")) {
			selectedPackage = TVPackage.PREMIUM;
		}else if (mainPackage.equals("M3")) {
			selectedPackage = TVPackage.FAMILY;
		}
		
		if (additionalPackage.equals("A1")) {
			offline_watching = true;
		}else if (additionalPackage.equals("A2")) {
			live_service = true;
		}else if (additionalPackage.equals("A3")) {
			offline_watching = true;
			live_service = true;
		}
		
		test = new TVPlan(offline_watching, live_service, discount);
		assertEquals(totalPrice, test.pricePerMonth(selectedPackage));
	}

}
