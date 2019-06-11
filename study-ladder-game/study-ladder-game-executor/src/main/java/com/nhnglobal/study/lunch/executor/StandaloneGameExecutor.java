package com.nhnglobal.study.lunch.executor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nhnglobal.study.lunch.core.GhostLegService;
import com.nhnglobal.study.lunch.core.algorithm.selector.BrianSelector;
import com.nhnglobal.study.lunch.core.config.ConfigLoader;
import com.nhnglobal.study.lunch.core.config.loader.FileConfigLoader;
import com.nhnglobal.study.lunch.core.config.parser.JsonParser;
import com.nhnglobal.study.lunch.core.impl.GhostLegServiceImpl;
import com.nhnglobal.study.lunch.core.model.GameRequest;

public class StandaloneGameExecutor {
	
	private static Logger log = LoggerFactory.getLogger(StandaloneGameExecutor.class);
			
	public static void main(String[] args) {
		
		log.debug("start~~");
		
//		TestClass testClass = new TestClassImpl();
//		testClass.test();
		
		String jsonFilePath = "/request.json";
		ConfigLoader loader = new FileConfigLoader(jsonFilePath, new JsonParser());
		GameRequest request = loader.getRequest();
		
//		LadderAlgorithm ladderAlgorithm = new BrianSelector();
//		GhostLegService ghostLegService = new GhostLegServiceImpl(ladderAlgorithm);
		
//		GhostLegService ghostLegService = new GhostLegServiceImpl(new BrianSelector());
		GhostLegService ghostLegService = new GhostLegServiceImpl();
		List<String> winners = ghostLegService.bet(request);
		
		for(String name : winners) {
			log.info("congratulation : " + name);
		}
	}

}
