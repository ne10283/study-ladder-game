package com.nhnglobal.study.lunch.executor;

import com.nhnglobal.study.lunch.core.TestClass;
import com.nhnglobal.study.lunch.core.impl.TestClassImpl;

public class StandaloneGameExecutor {
	
	public static void main(String[] args) {
		
		System.out.println("start~~");
		
		TestClass testClass = new TestClassImpl();
		testClass.test();
	}

}
