package com.ehualu.data.common.model;

/**
 * 引用规范易华录微服务开发规范[V0.1]
 * 
 */
public class Message<T> {
	public static final class Code {

		public static final int OK = 0;
		public static final int ERROR = 9;
		public static final int ERRORCODE = 22001;

	}

	// 状态码
	private int status;
	// 返回数据
	private T data;
	// 错误码
	private int errorCode;
	// 标准错误
	private String error;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
