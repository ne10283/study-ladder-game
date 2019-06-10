package com.nhnglobal.study.lunch.config.loader;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nhnglobal.study.lunch.core.config.ConfigLoader;
import com.nhnglobal.study.lunch.core.config.loader.FileConfigLoader;
import com.nhnglobal.study.lunch.core.config.parser.JsonParser;
import com.nhnglobal.study.lunch.core.model.GameRequest;


public class RequestConfigLoader {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Test 
	public void json_config_loader() {
		
		String jsonFilePath = "/request.json";
		ConfigLoader loader = new FileConfigLoader(jsonFilePath, new JsonParser());
		GameRequest resuest = loader.getRequest();
		
		Assert.assertNotNull(resuest);
		
		log.debug(resuest.toString());
		
		Assert.assertFalse(0 == resuest.getParticipants().size());
		Assert.assertFalse(0 == resuest.getWinner());
		
	}

}
