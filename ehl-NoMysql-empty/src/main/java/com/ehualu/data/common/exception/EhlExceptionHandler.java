package com.ehualu.data.common.exception;

import com.ehualu.data.common.model.Message;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 定制异常处理逻辑
 */
@ControllerAdvice
@RestController
public class EhlExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(EhlExceptionHandler.class);

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Message<String> handleException(HttpServletRequest requset, Exception e) {
		logger.error(ExceptionUtils.getStackTrace(e));

		Message<String> message = new Message<>();
		message.setStatus(Message.Code.ERROR);
		message.setErrorCode(Message.Code.ERROR);
		message.setError(e.toString());
		return message;
	}

	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Object handleBindException(HttpServletRequest request, BindException e) {
		logger.error(ExceptionUtils.getStackTrace(e));
		BindingResult result = e.getBindingResult();
		Message<String> message = new Message<>();
		message.setStatus(Message.Code.ERROR);
		message.setErrorCode(Message.Code.ERRORCODE);
		message.setError(getErrorMsg(result));
		return message;
	}
	/***
	 * 处理传参为 @RequestBody且 Validator验证参数错误时 抛出的异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public Object handleParmValidationException(HttpServletRequest request, MethodArgumentNotValidException e) {
		logger.error(ExceptionUtils.getStackTrace(e));
		BindingResult result = e.getBindingResult();
		Message<String> message = new Message<>();
		message.setStatus(Message.Code.ERROR);
		message.setErrorCode(Message.Code.ERRORCODE);
		message.setError(getErrorMsg(result));
		return message;
	}

	@ExceptionHandler(com.example.empty.infrastructure.exception.ValParmException.class)
	@ResponseBody
	public Object handleValParmException(HttpServletRequest request, com.example.empty.infrastructure.exception.ValParmException e) {
		Message<String> message = new Message<>();
		message.setStatus(Message.Code.ERROR);
		message.setErrorCode(Message.Code.ERRORCODE);
		message.setError(e.getMessage());
		return message;
	}

	@ExceptionHandler(com.example.empty.infrastructure.exception.ThirdPatryException.class)
	@ResponseBody
	public Object handleThirdPatryException(HttpServletRequest request, com.example.empty.infrastructure.exception.ThirdPatryException e) {
		Message<String> message = new Message<>();
		message.setStatus(Message.Code.ERROR);
		message.setErrorCode(Message.Code.ERRORCODE);
		message.setError(e.getMessage());
		return message;
	}

	private String getErrorMsg(BindingResult result){
		StringBuilder errorMsg = new StringBuilder("请求参数异常：");
		for (ObjectError error : result.getAllErrors()) {
			errorMsg.append(error.getDefaultMessage()).append(",");
		}
		errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
		return errorMsg.toString();
	}

}