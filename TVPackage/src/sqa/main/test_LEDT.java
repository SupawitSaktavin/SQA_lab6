package sqa.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.TVPlan.TVPackage;

class test_LEDT {
	TVPlan test;

	@ParameterizedTest
	@CsvSource({
	"STANDARD, true, true, true, 300",
	"STANDARD, true, true, false, 350",
	"STANDARD, true, false, true, 200",
	"STANDARD, true, false, false, 250",
	"STANDARD, false, true, true, 200",
	"STANDARD, false, true, false, 250",
	"STANDARD, false, false, true, 100",
	"STANDARD, false, false, false, 150",
	
	"PREMIUM, true, true, true, 500",
	"PREMIUM, true, true, false, 550",
	"PREMIUM, true, false, true, 400",
	"PREMIUM, true, false, false, 450",
	"PREMIUM, false, true, true, 400",
	"PREMIUM, false, true, false, 450",
	"PREMIUM, false, false, true, 300",
	"PREMIUM, false, false, false, 350",
	
	"FAMILY, true, true, true, 600",
	"FAMILY, true, true, false, 650",
	"FAMILY, true, false, true, 500",
	"FAMILY, true, false, false, 550",
	"FAMILY, false, true, true, 500",
	"FAMILY, false, true, false, 550",
	"FAMILY, false, false, true, 400",
	"FAMILY, false, false, false, 450"
	})
	void testWithCsvSource(TVPackage selectedPackage, boolean offline_watching, boolean live_service, boolean discount, double totalPrice) {
		test = new TVPlan(offline_watching, live_service, discount);
		assertEquals(totalPrice, test.pricePerMonth(selectedPackage));
	}

}
