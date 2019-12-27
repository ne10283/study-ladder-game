package com.nhnglobal.study.lunch.executor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nhnglobal.study.lunch.core.GhostLegService;
import com.nhnglobal.study.lunch.core.config.ConfigLoader;
import com.nhnglobal.study.lunch.core.config.loader.FileConfigLoader;
import com.nhnglobal.study.lunch.core.config.parser.JsonParser;
import com.nhnglobal.study.lunch.core.model.GameRequest;
import com.nhnglobal.study.lunch.executor.factory.GhostLegServiceFactory;
import com.nhnglobal.study.lunch.gui.LadderGameGui;

public class StandaloneGameExecutor {
	
	private static Logger log = LoggerFactory.getLogger(StandaloneGameExecutor.class);
			
	public static void main(String[] args) {
		
		log.debug("start~~");
		
		String jsonFilePath = "/request.json";
		ConfigLoader loader = new FileConfigLoader(jsonFilePath, new JsonParser());
		GameRequest request = loader.getRequest();
		
		GhostLegServiceFactory factory = GhostLegServiceFactory.getFactory(); 
		GhostLegService ghostLegService = factory.getService("default");
		List<String> winners = ghostLegService.bet(request);
		
		for(String name : winners) {
			log.info("congratulation : " + name);
		}
	}

}
