package com.ashitha.nashtechhomework.samplepatterncall.serviceimpl;

import com.ashitha.nashtechhomework.samplepatterncall.service.PatternCallService;

/**
 * 
 * This class provides a implementation of the PatternCallService,
 * allowing it to be instantiated and utilized within other components of the
 * system.
 */
public class PatternCallServiceImpl implements PatternCallService{

	private int patternId;
	private String patternName;
	private String patternFilePath;
	private boolean isPatternCalled;

	public PatternCallServiceImpl(int patternId, String patternName, String patternFilePath, boolean isPatternCalled) {
		this.patternId = patternId;
		this.patternName = patternName;
		this.patternFilePath = patternFilePath;
		this.isPatternCalled = isPatternCalled;
	}

	@Override
	public int getPatternCallId() {
		return patternId;
	}

	@Override
	public String getPatternCallName() {
		return patternName;
	}

	@Override
	public String getPatternCallFilePath() {
		return patternFilePath;
	}

	@Override
	public boolean isPatternCalled() {
		return isPatternCalled;
	}

	@Override
	public String toString() {
	    return getPatternCallId() + ", " + getPatternCallName() + ", " + getPatternCallFilePath() + ", " + isPatternCalled();
	}
}
