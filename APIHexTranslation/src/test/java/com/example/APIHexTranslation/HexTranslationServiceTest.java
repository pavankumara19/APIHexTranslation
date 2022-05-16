package com.example.APIHexTranslation;

import com.example.APIHexTranslation.model.RequestData;
import com.example.APIHexTranslation.service.HexTranslationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class HexTranslationServiceTest {
	@Autowired HexTranslationService hexTranslationService;

	@Test public void testFirstCase() {
		RequestData requestData = new RequestData();
		requestData.setKey("0000001");
		requestData.setValue("00");
		Map<String, Object> response = hexTranslationService
				.getParsedObject(requestData);
		Assert.assertTrue(response.containsKey("door_status"));
		Assert.assertTrue(response.containsValue("Closed"));
	}

	@Test public void testThirdCase() {
		RequestData requestData = new RequestData();
		requestData.setKey("0000004");
		requestData.setValue("00000190000004B000000000");
		Map<String, Object> response = hexTranslationService
				.getParsedObject(requestData);
		Assert.assertTrue(response.containsKey("temperature"));
		Assert.assertTrue(response.containsValue(400));
	}

	@Test public void testSecondCase() {
		RequestData requestData = new RequestData();
		requestData.setKey("0000002");
		requestData.setValue("02");
		Map<String, Object> response = hexTranslationService
				.getParsedObject(requestData);
		Assert.assertTrue(response.containsKey("cooking_notifications"));
		Assert.assertTrue(response.containsValue("Cooking Started"));
	}
}
