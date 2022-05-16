package com.example.APIHexTranslation.controller;

import com.example.APIHexTranslation.model.RequestData;
import com.example.APIHexTranslation.service.HexTranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController @RequestMapping("parse") public class HexTranslationController {
	@Autowired HexTranslationService hexTranslationService;

	@PostMapping public ResponseEntity<Map<String, Object>> parse(
			@RequestBody RequestData requestData) {

		Map<String, Object> response = hexTranslationService
				.getParsedObject(requestData);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
