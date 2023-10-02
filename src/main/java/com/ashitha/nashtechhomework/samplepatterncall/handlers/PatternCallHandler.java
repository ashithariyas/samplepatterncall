package com.ashitha.nashtechhomework.samplepatterncall.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ashitha.nashtechhomework.samplepatterncall.service.PatternCallService;

/**
 * The PatternCallHandler class manages PatternCallService instances. It
 * organizes the pattern calls by their id, name, file path, and whether they
 * are called or skipped, providing various query methods to access these
 * organized pattern calls.
 */
public class PatternCallHandler {
	// Maps for organizing pattern calls by id, name, and file path
	private final Map<Integer, PatternCallService> patternById = new HashMap<>();
	private final Map<String, List<PatternCallService>> patternByName = new HashMap<>();
	private final Map<String, List<PatternCallService>> patternByFile = new HashMap<>();

	// Lists for organizing pattern calls based on whether they are called or
	// skipped
	private final List<PatternCallService> calledPatterns = new ArrayList<>();
	private final List<PatternCallService> skippedPatterns = new ArrayList<>();

	/**
	 * Adds a new pattern call to the handler. Organizes the pattern call in maps
	 * and lists for easy querying later.
	 * 
	 * @param patternCall The pattern call to be added.
	 */
	public void addPatternCall(PatternCallService patternCall) {
		patternById.put(patternCall.getPatternCallId(), patternCall);
		patternByName.computeIfAbsent(patternCall.getPatternCallName(), k -> new ArrayList<>()).add(patternCall);
		patternByFile.computeIfAbsent(patternCall.getPatternCallFilePath(), k -> new ArrayList<>()).add(patternCall);
		if (patternCall.isPatternCalled()) {
			calledPatterns.add(patternCall);
		} else {
			skippedPatterns.add(patternCall);
		}
	}

	/**
	 * Retrieves all pattern calls as an unmodifiable list.
	 * 
	 * @return An unmodifiable list containing all pattern calls.
	 */
	public List<PatternCallService> getAllPatterns() {
		List<PatternCallService> allPatterns = new ArrayList<>();
		allPatterns.addAll(calledPatterns);
		allPatterns.addAll(skippedPatterns);
		return Collections.unmodifiableList(allPatterns);
	}

	/**
	 * Retrieves a pattern call by its identifier.
	 * 
	 * @param id The identifier of the pattern call.
	 * @return The pattern call with the specified identifier, or null if not found.
	 */
	public PatternCallService getPatternCallById(int id) {
		return patternById.get(id);
	}

	/**
	 * Retrieves pattern calls by their name.
	 * 
	 * @param name The name of the pattern calls.
	 * @return An unmodifiable list containing pattern calls with the specified
	 *         name.
	 */
	public List<PatternCallService> getPatternCallsByName(String name) {
		return Collections.unmodifiableList(patternByName.getOrDefault(name, new ArrayList<>()));
	}

	/**
	 * Retrieves pattern calls by their file path.
	 * 
	 * @param patternFile The file path of the pattern calls.
	 * @return An unmodifiable list containing pattern calls with the specified file
	 *         path.
	 */
	public List<PatternCallService> getPatternCallsByFilePath(String patternFilePath) {
		return Collections.unmodifiableList(patternByFile.getOrDefault(patternFilePath, new ArrayList<>()));
	}

	/**
	 * Retrieves all called pattern calls.
	 * 
	 * @return An unmodifiable list containing all called pattern calls.
	 */
	public List<PatternCallService> getCalledPatterns() {
		return Collections.unmodifiableList(calledPatterns);
	}

	/**
	 * Retrieves all skipped pattern calls.
	 * 
	 * @return An unmodifiable list containing all skipped pattern calls.
	 */
	public List<PatternCallService> getSkippedPatterns() {
		return Collections.unmodifiableList(skippedPatterns);
	}
}
