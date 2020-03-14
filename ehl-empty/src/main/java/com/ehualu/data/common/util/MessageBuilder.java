package com.ehualu.data.common.util;

import com.ehualu.data.common.model.Message;

public class MessageBuilder {
	public static class Builder<T> {
		private Message<T> message;

		public Builder() {
			message = new Message<T>();
		}

		public Builder<T> setStatus(int status) {
			message.setStatus(status);
			return this;
		}

		public Builder<T> setData(T data) {
			message.setData(data);
			return this;
		}

		public Builder<T> setErrorCode(int errorCode) {
			message.setErrorCode(errorCode);
			return this;
		}

		public Builder<T> setError(String error) {
			message.setError(error);
			return this;
		}

		public Message<T> builder() {
			return message;
		}
	}

}
