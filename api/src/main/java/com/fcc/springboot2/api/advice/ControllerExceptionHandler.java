package com.fcc.springboot2.api.advice;

import com.fcc.springboot2.api.constant.ApiMessageCode;
import com.fcc.springboot2.api.pojo.dto.out.ResultDto;
import com.fcc.springboot2.api.tools.WebTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

/**
 * controller异常处理
 * @author
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    /**
     * 通用异常捕获
     *
     * @param ex 通用异常
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResultDto handleException(Exception ex) {
        HttpServletRequest request = null;
        try {
            request = WebTools.getCurrentRequest();
        } catch (Exception e) {
            log.error("获取当前request失败!", e);
        }
        if (request == null) {
            log.error("api接口访问异常!", ex);
        } else {
            log.error("api接口访问异常! url={}", request.getRequestURI(), ex);
        }
        if (ex.getClass().equals(MissingServletRequestParameterException.class)
                || ex.getClass().equals(MethodArgumentTypeMismatchException.class)
                || ex.getClass().equals(HttpMessageNotReadableException.class)) {
            // 接口入参缺失或者格式不正确
            return ResultDto.build(ApiMessageCode.ERROR_SYSTEM_PARAM_FORMAT);
        }
        return ResultDto.build(ApiMessageCode.ERROR_SYSTEM);
    }

    /**
     * 无权访问异常捕获
     *
     * @param ex 无权异常
     * @return
     */
    @ExceptionHandler({AccessDeniedException.class})
    public ResultDto handleAccessDeniedException(Exception ex) {
        log.error("该帐户不允许访问当前api接口!", ex);
        return ResultDto.build(ApiMessageCode.ERROR_ACCESS_DENIED);
    }

    /**
     * 上传文件过大异常捕获
     *
     * @param ex 上传文件过大异常
     * @return
     */
    @ExceptionHandler({MaxUploadSizeExceededException.class})
    public ResultDto handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
        log.error("上传文件过大!", ex);
        return ResultDto.build(ApiMessageCode.ERROR_FILE_SERVER_UPLOAD_SIZE_EXCEED);
    }

}