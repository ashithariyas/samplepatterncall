package com.ashitha.nashtechhomework.samplepatterncall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ashitha.nashtechhomework.samplepatterncall.service.FileHandlerService;
import com.ashitha.nashtechhomework.samplepatterncall.service.PatternCallService;
import com.ashitha.nashtechhomework.samplepatterncall.serviceimpl.FileHandlerImpl;
import com.ashitha.nashtechhomework.samplepatterncall.serviceimpl.PatternCallServiceImpl;

/**
 * Unit tests for the FileHandlerService {@link PatternCallServiceImpl} class.
 */
public class FileHandlerTest {

	private FileHandlerService fileHandler;
	List<PatternCallService> patternCalls;

	/**
	 * Setup method to initialize common test objects.
	 */
	@Before
	public void setUp() {
		fileHandler = new FileHandlerImpl();
		patternCalls = new ArrayList<>();
	}

	/**
	 * Tests the savePatternCallsToFile method.
	 *
	 * @throws IOException If an I/O error occurs during the test.
	 */
	@Test
	public void testSavePatternCallsToFile() throws IOException {
		patternCalls.add(new PatternCallServiceImpl(1, "TestPattern", "src/patterns/Test.txt", true));

		String filePath = "temp.txt";

		fileHandler.savePatternCallsToFile(patternCalls, filePath);

		// Verify the file exists and cleanup
		assertTrue(Files.exists(Paths.get(filePath)));
		Files.deleteIfExists(Paths.get(filePath));
	}

	/**
	 * Tests the loadPatternCallsFromFile method.
	 *
	 * @throws IOException If an I/O error occurs during the test.
	 */

	@Test
	public void testLoadPatternCallsFromFile() throws IOException {
		patternCalls.add(new PatternCallServiceImpl(1, "TestPattern", "src/patterns/Test.txt", true));

		String filePath = "temp.txt";

		fileHandler.savePatternCallsToFile(patternCalls, filePath);
		List<PatternCallService> loadedPatternCalls = fileHandler.loadPatternCallsFromFile(filePath);

		assertEquals(patternCalls.size(), loadedPatternCalls.size());
		assertEquals(patternCalls.get(0).getPatternCallName(), loadedPatternCalls.get(0).getPatternCallName());

		// Cleanup
		Files.deleteIfExists(Paths.get(filePath));
	}
}
