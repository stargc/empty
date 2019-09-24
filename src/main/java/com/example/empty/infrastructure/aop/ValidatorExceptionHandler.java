package com.example.empty.infrastructure.aop;

import com.example.empty.business.common.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author guanchen
 * @version $Id GlobalExceptionHandler.java, v 0.1 2019-04-01 11:00 star Exp $$
 */

@Slf4j
@ControllerAdvice
public class ValidatorExceptionHandler {
    /***
     * 处理传参为 @RequestParam且Validator验证参数错误时 抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Object handleParmValidationException(HttpServletRequest request, ConstraintViolationException e) {
        StringBuilder errorMsg = new StringBuilder("请求参数异常：");
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> item : violations) {
            errorMsg.append(item.getMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        return getFailedResponse(BaseResponse.FAILED, errorMsg.toString());
    }

    /***
     * 处理传参为 @RequestBody且 Validator验证参数错误时 抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Object handleParmValidationException(HttpServletRequest request, BindException e) {
        BindingResult result = e.getBindingResult();
        return getFailedResponse(BaseResponse.FAILED, getErrorMsg(result));
    }

    /***
     * 处理传参为 @RequestBody且Validator验证参数错误时 抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object handleParmValidationException(HttpServletRequest request, MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        return getFailedResponse(BaseResponse.FAILED, getErrorMsg(result));
    }

    private String getErrorMsg(BindingResult result){
        StringBuilder errorMsg = new StringBuilder("请求参数异常：");
        for (ObjectError error : result.getAllErrors()) {
            errorMsg.append(error.getDefaultMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        return errorMsg.toString();
    }

    private BaseResponse getFailedResponse(String code, String msg) {
        BaseResponse response = new BaseResponse();
        response.setResultCode(code);
        response.setResultMsg(msg);
        return response;
    }

}
