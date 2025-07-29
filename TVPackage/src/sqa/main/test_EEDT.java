package sqa.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.TVPlan.TVPackage;

class test_EEDT {
	TVPlan test;

	@ParameterizedTest
	@CsvSource({
	"STANDARD, 3, true, 300",
	"STANDARD, 3, false, 350",
	"STANDARD, 1, true, 200",
	"STANDARD, 1, false, 250",
	"STANDARD, 2, true, 200",
	"STANDARD, 2, false, 250",
	"STANDARD, 0, true, 100",
	"STANDARD, 0, false, 150",
	
	"PREMIUM, 3, true, 500",
	"PREMIUM, 3, false, 550",
	"PREMIUM, 1, true, 400",
	"PREMIUM, 1, false, 450",
	"PREMIUM, 2, true, 400",
	"PREMIUM, 2, false, 450",
	"PREMIUM, 0, true, 300",
	"PREMIUM, 0, false, 350",
	
	"FAMILY, 3, true, 600",
	"FAMILY, 3, false, 650",
	"FAMILY, 1, true, 500",
	"FAMILY, 1, false, 550",
	"FAMILY, 1, true, 500",
	"FAMILY, 1, false, 550",
	"FAMILY, 0, true, 400",
	"FAMILY, 0, false, 450"
	})
	void testWithCsvSource(TVPackage selectedPackage, int add_on, boolean discount, double totalPrice) {
		boolean offline_watching = false;
		boolean live_service = false;
		if (add_on == 1) {
			offline_watching = true;
		}else if (add_on == 2) {
			live_service = true;
		}else if (add_on == 3) {
			offline_watching = true;
			live_service = true;
		}
		test = new TVPlan(offline_watching, live_service, discount);
		assertEquals(totalPrice, test.pricePerMonth(selectedPackage));
	}

}
