package com.nhnglobal.study.lunch.core.config.parser;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnglobal.study.lunch.core.model.GameRequest;

public class JsonParser implements Parser {

	@Override
	public GameRequest parse(String jsonString) {

		ObjectMapper mapper = new ObjectMapper();
		GameRequest request = null;
		try {
			request = mapper.readValue(jsonString, GameRequest.class);
		} catch (IOException ignored) {
		}

		return request;
	}

}
