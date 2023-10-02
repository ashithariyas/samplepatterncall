package com.ashitha.nashtechhomework.samplepatterncall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ashitha.nashtechhomework.samplepatterncall.handlers.PatternCallHandler;
import com.ashitha.nashtechhomework.samplepatterncall.service.PatternCallService;
import com.ashitha.nashtechhomework.samplepatterncall.serviceimpl.PatternCallServiceImpl;

/**
 * Unit tests for the {@link PatternCallHandler} class. This class contains test
 * methods for various functionalities of the {@link PatternCallHandler}.
 */
public class PatternCallHandlerTest {

	private PatternCallHandler handler;

	/**
	 * Setup method to initialize common test objects.
	 */
	@Before
	public void setUp() {
		handler = new PatternCallHandler();
	}

	/**
	 * Test for adding a pattern call to the handler.
	 */
	@Test
	public void testAddPatternCall() {
		PatternCallService patternCall = new PatternCallServiceImpl(1, "TestPattern", "src/patterns/Test.txt", true);
		handler.addPatternCall(patternCall);
		List<PatternCallService> allPatterns = handler.getAllPatterns();
		assertEquals(1, allPatterns.size());
		assertEquals(patternCall, allPatterns.get(0));
	}

	/**
	 * Test for retrieving a pattern call by its identifier.
	 */
	@Test
	public void testGetPatternCallById() {
		PatternCallService patternCall = new PatternCallServiceImpl(1, "TestPattern", "src/patterns/Test.txt", true);
		handler.addPatternCall(patternCall);
		PatternCallService retrievedPatternCall = handler.getPatternCallById(1);
		assertEquals(patternCall, retrievedPatternCall);
	}

	/**
	 * Test for retrieving pattern calls by their name.
	 */
	@Test
	public void testGetPatternCallsByName() {
		PatternCallService patternCall1 = new PatternCallServiceImpl(1, "TestPattern1", "src/patterns/Test.txt", true);
		PatternCallService patternCall2 = new PatternCallServiceImpl(2, "TestPattern2", "src/patterns/Test1.txt", false);
		handler.addPatternCall(patternCall1);
		handler.addPatternCall(patternCall2);

		List<PatternCallService> result = handler.getPatternCallsByName("TestPattern1");

		assertEquals(1, result.size());
		assertTrue(result.contains(patternCall1));
	}

	/**
	 * Test for retrieving pattern calls by name when there's no match.
	 */

	@Test
	public void testGetPatternCallsByName_NoMatch() {
		List<PatternCallService> result = handler.getPatternCallsByName("NonExistentPattern");
		assertTrue(result.isEmpty());
	}

	/**
	 * Test for retrieving pattern calls by their file path.
	 */
	@Test
	public void testGetPatternCallsByFilePath() {
		PatternCallService patternCall1 = new PatternCallServiceImpl(1, "TestPattern1", "src/patterns/Test.txt", true);
		PatternCallService patternCall2 = new PatternCallServiceImpl(2, "TestPattern2", "src/patterns/Test1.txt", false);
		handler.addPatternCall(patternCall1);
		handler.addPatternCall(patternCall2);

		List<PatternCallService> result = handler.getPatternCallsByFilePath("src/patterns/Test.txt");

		assertEquals(1, result.size());
		assertTrue(result.contains(patternCall1));
	}

	/**
	 * Test for retrieving pattern calls by file path when there's no match.
	 */
	@Test
	public void testGetPatternCallsByFilePath_NoMatch() {
		List<PatternCallService> result = handler.getPatternCallsByFilePath("src/patterns/NonExistent.txt");
		assertTrue(result.isEmpty());
	}

	/**
	 * Test for retrieving all called pattern calls.
	 */
	@Test
	public void testGetCalledPatterns() {
		PatternCallService calledPattern = new PatternCallServiceImpl(1, "TestPattern", "src/patterns/Test.txt", true);
		handler.addPatternCall(calledPattern);

		List<PatternCallService> result = handler.getCalledPatterns();

		assertEquals(1, result.size());
		assertTrue(result.contains(calledPattern));
	}

	/**
	 * Test for retrieving all skipped pattern calls.
	 */
	@Test
	public void testGetSkippedPatterns() {
		PatternCallService skippedPattern = new PatternCallServiceImpl(1, "TestPattern", "src/patterns/Test.txt",
				false);
		handler.addPatternCall(skippedPattern);

		List<PatternCallService> result = handler.getSkippedPatterns();

		assertEquals(1, result.size());
		assertTrue(result.contains(skippedPattern));
	}
}
