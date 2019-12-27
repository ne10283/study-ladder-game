package com.nhnglobal.study.lunch.core.config.loader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.nhnglobal.study.lunch.core.config.ConfigLoader;
import com.nhnglobal.study.lunch.core.config.parser.Parser;
import com.nhnglobal.study.lunch.core.model.GameRequest;

public class FileConfigLoader extends ConfigLoader {
	
	private GameRequest request;

	public FileConfigLoader(String filePath, Parser parser) {

		try (
			InputStreamReader isr = new InputStreamReader(this.getClass().getResourceAsStream(filePath));
		    BufferedReader r = new BufferedReader(isr)
        ) {
			
			StringBuilder jsonString = new StringBuilder();
			String line;
			while((line = r.readLine()) != null) {
				jsonString.append(line);
			}
			
			log.debug("json string : {} ", jsonString.toString());
			
			request = parser.parse(jsonString.toString());
			
		} catch (Exception ignored){
			
		}
	}

	@Override
	public GameRequest getRequest() {
		return this.request;
	}

}
