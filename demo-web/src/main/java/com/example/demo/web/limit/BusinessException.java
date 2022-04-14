package com.example.demo.web.limit;

import lombok.Data;

/**
 * @author : wangjun
 * @date : 2022/4/14  14:16
 */
@Data
public class BusinessException extends RuntimeException {

    /**
     * 错误代码，参考《adapter规范.pdf》
     * 章节：2.6
     */
    private String errorCode;

    /**
     * 错误消息 --对应rtn_tip(即返回展示前端页面信息)
     */
    private String errorMsg;

    /**
     * 异常信息
     */
    private String exceptionMsg;


    public BusinessException() {
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
        this.exceptionMsg = errorMsg;
    }

    public BusinessException(String errorMsg, String exceptionMsg) {
        super(exceptionMsg);
        this.errorMsg = errorMsg;
    }

    public BusinessException(String errorCode, String errorMsg, String exceptionMsg) {
        super(exceptionMsg);
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
        this.exceptionMsg = exceptionMsg;
    }

}
