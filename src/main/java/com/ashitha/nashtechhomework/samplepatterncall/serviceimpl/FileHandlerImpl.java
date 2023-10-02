package com.ashitha.nashtechhomework.samplepatterncall.serviceimpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ashitha.nashtechhomework.samplepatterncall.service.FileHandlerService;
import com.ashitha.nashtechhomework.samplepatterncall.service.PatternCallService;



/**
 * The FileHandler class provides methods to read pattern call data from a file
 * and write pattern call data to a file. 
 */
public class FileHandlerImpl implements FileHandlerService {

	/**
	 * Saves a list of pattern calls to a specified file. Each pattern call is
	 * written on a new line.
	 *
	 * @param patternCalls The list of pattern calls to be saved.
	 * @param filePath     The path to the file where the pattern calls should be
	 *                     saved.
	 * @throws IOException If an I/O error occurs during the file writing process.
	 */
	@Override
	public void savePatternCallsToFile(List<PatternCallService> patternCalls, String filePath) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (PatternCallService patternCall : patternCalls) {
				writer.write(patternCall.toString());
				writer.newLine();
			}
		}
	}

	/**
	 * Loads a list of pattern calls from a specified file. Each line in the file
	 * represents a pattern call and is parsed into a PatternCallService object.
	 *
	 * @param filePath The path to the file from which the pattern calls should be
	 *                 loaded.
	 * @return A list of pattern calls loaded from the file.
	 * @throws IOException If an I/O error occurs during the file reading process.
	 */
	@Override
	public List<PatternCallService> loadPatternCallsFromFile(String filePath) throws IOException {
		List<PatternCallService> patternCalls = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(", ");
				int id = Integer.parseInt(parts[0]);
				String name = parts[1].replace("\"", "");
				String patternFile = parts[2];
				boolean called = Boolean.parseBoolean(parts[3]);
				patternCalls.add(new PatternCallServiceImpl(id, name, patternFile, called));
			}
		}
		return Collections.unmodifiableList(patternCalls);
	}
}