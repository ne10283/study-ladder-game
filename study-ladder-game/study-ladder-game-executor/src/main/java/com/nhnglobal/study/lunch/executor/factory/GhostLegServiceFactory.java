package com.nhnglobal.study.lunch.executor.factory;

import com.nhnglobal.study.lunch.core.GhostLegService;
import com.nhnglobal.study.lunch.core.impl.GhostLegServiceImpl;
import com.nhnglobal.study.lunch.core.algorithm.selector.*;

public class GhostLegServiceFactory {
	public GhostLegService getService(String selector) {
		if (selector.equals("brian")) {
			return new GhostLegServiceImpl(new BrianSelector());
		}
		else if (selector.equals("default")) {
			return new GhostLegServiceImpl(new DefaultSelector());
		}
		else {
			return new GhostLegServiceImpl(new DefaultSelector());
		}
	}
}
