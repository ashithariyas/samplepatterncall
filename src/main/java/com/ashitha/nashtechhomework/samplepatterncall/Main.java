package com.ashitha.nashtechhomework.samplepatterncall;

import java.io.IOException;
import java.util.List;

import com.ashitha.nashtechhomework.samplepatterncall.handlers.PatternCallHandler;
import com.ashitha.nashtechhomework.samplepatterncall.service.FileHandlerService;
import com.ashitha.nashtechhomework.samplepatterncall.service.PatternCallService;
import com.ashitha.nashtechhomework.samplepatterncall.serviceimpl.FileHandlerImpl;
import com.ashitha.nashtechhomework.samplepatterncall.serviceimpl.PatternCallServiceImpl;
import com.ashitha.nashtechhomework.samplepatterncall.utils.FileUtil;

/**
 * Main class to demonstrate the pattern call handling logic.
 */
public class Main {

	public static void main(String[] args) {

		PatternCallHandler patternHandler = new PatternCallHandler();
		FileHandlerService fileHandler = new FileHandlerImpl();

		// Load initial pattern calls from the inputpatterns.txt file
		try {
			List<PatternCallService> initialPatternCalls = fileHandler
					.loadPatternCallsFromFile(FileUtil.getFilePath("initialpatterns.txt"));
			for (PatternCallService patternCall : initialPatternCalls) {
				patternHandler.addPatternCall(patternCall);
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		// Define an array of dummy pattern data
        String[] dummyPatterns = {
            "dummyPattern0",
            "dummyPattern1",
            "dummyPattern2",
            "dummyPattern3",
            "dummyPattern4",
        };

        // Iterate over the array and add pattern tuples with dummy data
        for (int i = 0; i < dummyPatterns.length; i++) {
            int id = 61 + i; 
            String name = dummyPatterns[i];
            String patternFile = "src/patterns/Dummy.txt";
            // Alternate between true and false for "called"
            boolean called = i % 2 == 0; 
            PatternCallService pattern = new PatternCallServiceImpl(id, name, patternFile, called);
            patternHandler.addPatternCall(pattern);
        }
        
        // Saves the added pattern calls to the output.txt file
		try {
	        fileHandler.savePatternCallsToFile(patternHandler.getAllPatterns(), FileUtil.getFilePath("output.txt"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

        // Retrieve a pattern call by its identifier (e.g., 43)
		PatternCallService patternCallById = patternHandler.getPatternCallById(43);
		
		// Retrieve all pattern calls with the specified name (e.g., "myPattern")
		List<PatternCallService> patternCallsByName = patternHandler.getPatternCallsByName("dummyPattern1");
		
		// Retrieve all pattern calls with the specified file path (e.g., "src/patterns/Dummy.txt")
		List<PatternCallService> patternCallsByFile = patternHandler
				.getPatternCallsByFilePath("src/patterns/Dummy.txt");
		
		// Retrieve all called patterns
		List<PatternCallService> calledPatterns = patternHandler.getCalledPatterns();
		
		// Retrieve all skipped patterns
		List<PatternCallService> skippedPatterns = patternHandler.getSkippedPatterns();

		// Print the results
		System.out.println("Pattern Calls by Id: " + patternCallById);
		System.out.println("Pattern Calls by Name: " + patternCallsByName);
		System.out.println("Pattern Calls by File: " + patternCallsByFile);
		System.out.println("Called Patterns: " + calledPatterns);
		System.out.println("Skipped Patterns: " + skippedPatterns);
	}
}
