package com.nhnglobal.study.lunch.core.config.parser;

import com.nhnglobal.study.lunch.core.model.GameRequest;

public interface Parser {

	public GameRequest parse(String string);

}
