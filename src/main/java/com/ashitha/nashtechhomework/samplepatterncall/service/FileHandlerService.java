package com.ashitha.nashtechhomework.samplepatterncall.service;

import java.io.IOException;
import java.util.List;

/**
 * The FileHandlerService interface defines methods for saving and loading
 * pattern calls to and from a file.
 */
public interface FileHandlerService {

	/**
	 * Saves a list of pattern calls to a specified file.
	 *
	 * @param patternCalls The list of pattern calls to be saved.
	 * @param filePath     The path to the file where pattern calls should be saved.
	 * @throws IOException If an I/O error occurs while saving the data to the file.
	 */
	void savePatternCallsToFile(List<PatternCallService> patternCalls, String filePath) throws IOException;

	/**
	 * Loads a list of pattern calls from a specified file.
	 *
	 * @param filePath The path to the file from which pattern calls should be
	 *                 loaded.
	 * @return A list of loaded PatternCallService objects.
	 * @throws IOException If an I/O error occurs while loading the data from the
	 *                     file.
	 */
	List<PatternCallService> loadPatternCallsFromFile(String filePath) throws IOException;
}
