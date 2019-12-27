package com.nhnglobal.study.lunch.executor;

import com.nhnglobal.study.lunch.core.config.ConfigLoader;
import com.nhnglobal.study.lunch.core.config.loader.FileConfigLoader;
import com.nhnglobal.study.lunch.core.config.parser.JsonParser;
import com.nhnglobal.study.lunch.gui.LadderGameGui;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandaloneGuiGameExecutor {

    private static Logger log = LoggerFactory.getLogger(StandaloneGuiGameExecutor.class);

    public static void main(String[] args) {

        log.debug("start~~");

        String jsonFilePath = "/request.json";
        ConfigLoader loader = new FileConfigLoader(jsonFilePath, new JsonParser());

        LadderGameGui gui = new LadderGameGui();
        gui.execute(loader.getRequest().getParticipants(), loader.getRequest().getWinner());
    }
}
