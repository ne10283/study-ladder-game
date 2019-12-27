package com.nhnglobal.study.lunch.core.config.parser;

import com.nhnglobal.study.lunch.core.model.GameRequest;

public interface Parser {

	GameRequest parse(String string);

}
