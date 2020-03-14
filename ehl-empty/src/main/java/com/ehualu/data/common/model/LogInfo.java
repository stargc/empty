package com.ehualu.data.common.model;

public class LogInfo {
	private String id;
	private String datasetid;
	private String startTime;
	private String endTime;
	private String runStatus;
	private String runLog;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDatasetid() {
		return datasetid;
	}

	public void setDatasetid(String datasetid) {
		this.datasetid = datasetid;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	public String getRunLog() {
		return runLog;
	}

	public void setRunLog(String runLog) {
		this.runLog = runLog;
	}

}
