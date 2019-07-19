package com.nhnglobal.study.lunch.executor.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.nhnglobal.study.lunch.core.GhostLegService;
import com.nhnglobal.study.lunch.core.impl.GhostLegServiceImpl;
import com.nhnglobal.study.lunch.core.algorithm.LadderAlgorithm;
import com.nhnglobal.study.lunch.core.algorithm.selector.*;

public class GhostLegServiceFactory {
	private static GhostLegServiceFactory factory = new GhostLegServiceFactory();
	private Map<String, LadderAlgorithm> selectorMap = new HashMap<>();;
	
	private GhostLegServiceFactory() {
		selectorMap.put("brian", new BrianSelector());
		selectorMap.put("default", new DefaultSelector());
	}
	
	public static GhostLegServiceFactory getFactory() {
		return factory;
	}
	
	public GhostLegService getService(String selector) {
		return new GhostLegServiceImpl(Optional.ofNullable(selectorMap.get(selector)).orElseThrow(() -> new NoSuchElementException()));
		
	}
}
