package com.ashitha.nashtechhomework.samplepatterncall.utils;

import java.nio.file.Paths;

public final class FileUtil {

	/**
	 * Constructs a file path by combining a predefined directory with a given file
	 * name. The current implementation uses the user's current directory, but this
	 * may change in the future, allowing users to specify a different path.
	 * 
	 * @param fileName the name of the file (e.g., "example.txt")
	 * @return the full path to the file as a String
	 */
	public static String getFilePath(String fileName) {
		String resourcesDirectory = "resources";
		String projectRoot = System.getProperty("user.dir");
		resourcesDirectory = Paths.get(projectRoot, resourcesDirectory).toString();
		return Paths.get(resourcesDirectory, fileName).toString();
	}
}
