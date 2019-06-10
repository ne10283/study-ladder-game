package com.nhnglobal.study.lunch.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nhnglobal.study.lunch.core.model.GameRequest;


public abstract class ConfigLoader {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	abstract public GameRequest getRequest();

}
