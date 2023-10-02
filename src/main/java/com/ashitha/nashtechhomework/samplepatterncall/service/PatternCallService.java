package com.ashitha.nashtechhomework.samplepatterncall.service;

/**
 * The PatternCallInterface defines the contract for a Pattern Call object.
 * A Pattern Call object is characterized by a unique identifier, a name, a file path,
 * and a flag indicating whether the pattern is called or not.
 * 
 * This interface provides methods to access these properties of a Pattern Call object.
 */
public interface PatternCallService {

	/**
     * Retrieves the unique identifier of this pattern call.
     * 
     * @return The unique identifier of the pattern call.
     */
	int getPatternCallId();

	/**
     * Retrieves the name of this pattern call.
     * 
     * @return The name of the pattern call.
     */
	String getPatternCallName();

	/**
     * Retrieves the file path associated with this pattern call.
     * 
     * @return The file path of the pattern call.
     */
	String getPatternCallFilePath();

	/**
     * Checks if this pattern call is marked as called.
     * 
     * @return true if the pattern call is marked as called, false otherwise.
     */
	boolean isPatternCalled();
}
