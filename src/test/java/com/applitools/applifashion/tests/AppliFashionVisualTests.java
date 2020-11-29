package com.applitools.applifashion.tests;

import com.applitools.applifashion.pages.AppliFashionApp;
import com.applitools.applifashion.pages.MainPage;
import com.applitools.applifashion.utils.EyesManager;
import com.applitools.eyes.TestResultsSummary;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppliFashionVisualTests {

	private static EyesManager eyesManager;
	private MainPage mainPage;

	@BeforeAll
	public static void suiteSetup() {
		eyesManager = new EyesManager();
	}

	@BeforeEach
	public void methodSetUp() {
		mainPage = AppliFashionApp.openOnMainPage();
	}

	@Test @Order(1)
	public void verifyMainPage() {
		eyesManager.validateWindowFully("Test 1", "main page");
	}

	@Test @Order(2)
	public void verifyFilteredProductGrid() {
		mainPage.filterBy("Black");
		eyesManager.validateRegion("Test 2", "filter by color", mainPage.productGrid());
	}

	@Test @Order(3)
	public void verifyProductDetails() {
		mainPage.productGrid().selectItemByName("Appli Air x Night");
		eyesManager.validateWindowFully("Test 3", "product details");
	}

	@AfterEach
	public void tearDown() {
		AppliFashionApp.close();
	}

	@AfterAll
	public static void suiteTearDown() {
		TestResultsSummary allTestResults = eyesManager.getAllTestResults(false);
		System.out.println(allTestResults);
	}

}
