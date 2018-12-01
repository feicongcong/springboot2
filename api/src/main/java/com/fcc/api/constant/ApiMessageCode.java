package com.fcc.api.constant;

/**
 * @Description:常量码
 * @Author: J.W
 * @Date: 下午8:29 2018/1/6
 */
public class ApiMessageCode {

    /**
     * 系统异常码
     */
    public static final String ERROR_SYSTEM = "ERROR_SYSTEM";
    public static final String ERROR_SYSTEM_PARAM_FORMAT = "ERROR_SYSTEM_PARAM_FORMAT";
    public static final String ERROR_DATA_MISS = "ERROR_DATA_MISS";
    public static final String ERROR_OPERATE_FAIL = "ERROR_OPERATE_FAIL";

    /**
     * 加密解密
     */
    public static final String ERROR_ENCODE = "ERROR_ENCODE";
    public static final String ERROR_DECODE = "ERROR_DECODE";

    /**
     * 文件服务器Oss
     */
    public static final String ERROR_FILE_SERVER_UPLOAD = "ERROR_FILE_SERVER_UPLOAD";
    public static final String ERROR_FILE_SERVER_UPLOAD_SIZE_EXCEED = "ERROR_FILE_SERVER_UPLOAD_SIZE_EXCEED";
    public static final String ERROR_FILE_SERVER_GENERATE_URL = "ERROR_FILE_SERVER_GENERATE_URL";
    public static final String ERROR_FILE_SERVER_DOWNLOAD = "ERROR_FILE_SERVER_DOWNLOAD";

    /**
     * 鉴权
     */
    public static final String ERROR_ACCESS_NEED_AUTH = "ERROR_ACCESS_NEED_AUTH";
    public static final String ERROR_ACCESS_DENIED = "ERROR_ACCESS_DENIED";
    public static final String ERROR_ACCESS_PRINCIPAL_CHECK = "ERROR_ACCESS_PRINCIPAL_CHECK";
    public static final String ERROR_ACCESS_TOKEN_NOT_EXIST = "ERROR_ACCESS_TOKEN_NOT_EXIST";

    /**
     * 账户信息校验
     */
    public static final String ERROR_ACCOUNT_MOBILE_FORMAT = "ERROR_ACCOUNT_MOBILE_FORMAT";
    public static final String ERROR_ACCOUNT_PASSWORD_FORMAT = "ERROR_ACCOUNT_PASSWORD_FORMAT";
    public static final String ERROR_ACCOUNT_PASSWORD_NOT_MATCH = "ERROR_ACCOUNT_PASSWORD_NOT_MATCH";
    public static final String ERROR_ACCOUNT_USER_NOT_EXISTS = "ERROR_ACCOUNT_USER_NOT_EXISTS";
    public static final String ERROR_ACCOUNT_USER_IS_CANCEL = "ERROR_ACCOUNT_USER_IS_CANCEL";
    public static final String ERROR_ACCOUNT_USER_IS_FREEZE = "ERROR_ACCOUNT_USER_IS_FREEZE";
    public static final String ERROR_ACCOUNT_MOBILE_HAS_EXISTS = "ERROR_ACCOUNT_MOBILE_HAS_EXISTS";
    public static final String ERROR_ACCOUNT_ROLE_IS_USEING = "ERROR_ACCOUNT_ROLE_IS_USEING";
    public static final String ERROR_ACCOUNT_USER_NOT_ASSET = "ERROR_ACCOUNT_USER_NOT_ASSET";


    /**
     * 菜单不存在
     */
    public static final String ERROR_ACCOUNT_AUTHORITY_MENU_NOT_EXISTS = "ERROR_ACCOUNT_AUTHORITY_MENU_NOT_EXISTS";
    public static final String ERROR_ACCOUNT_AUTHORITY_MENU_IN_USER = "ERROR_ACCOUNT_AUTHORITY_MENU_IN_USER";
    public static final String ERROR_ACCOUNT_AUTHORITY_PERMISSION_IN_USER = "ERROR_ACCOUNT_AUTHORITY_PERMISSION_IN_USER";

    /**
     * 角色
     */
    public static final String ERROR_ACCOUNT_AUTHORITY_ROLE_NOT_EXIST = "ERROR_ACCOUNT_AUTHORITY_ROLE_NOT_EXIST";

    /**
     * 业务类型配置
     */
    public static final String ERROR_BUSINESS_TYPE_NOT_EXIST = "ERROR_BUSINESS_TYPE_NOT_EXIST";
    public static final String ERROR_PRODUCT_TYPE_NOT_EXIST = "ERROR_PRODUCT_TYPE_NOT_EXIST";
    public static final String ERROR_PRODUCT_TYPE_CONFIG_HAS_EXIST = "ERROR_PRODUCT_TYPE_CONFIG_HAS_EXIST";
    public static final String ERROR_PRODUCT_TYPE_CONFIG_NOT_EXIST = "ERROR_PRODUCT_TYPE_CONFIG_NOT_EXIST";
    /**
     * 资产端商户
     */
    public static final String ERROR_PLATFORM_MERCHANT_ASSET_NOT_EXISTS = "ERROR_PLATFORM_MERCHANT_ASSET_NOT_EXISTS";
    public static final String ERROR_PLATFORM_MERCHANT_ASSET_NOT_AUDITED = "ERROR_PLATFORM_MERCHANT_ASSET_NOT_AUDITED";

    /**
     * 资金端商户
     */
    public static final String ERROR_PLATFORM_MERCHANT_CAPITAL_NOT_EXISTS = "ERROR_PLATFORM_MERCHANT_CAPITAL_NOT_EXISTS";

    /**
     * 标的
     */
    public static final String ERROR_ASSET_BID_NOT_EXISTS = "ERROR_ASSET_BID_NOT_EXISTS";

    /**
     * 平台已接收标的
     */
    public static final String ERROR_PLATFORM_BID_NOT_EXIST = "ERROR_PLATFORM_BID_NOT_EXIST";
    public static final String ERROR_PLATFORM_BID_STATUS_RECTIFY = "ERROR_PLATFORM_BID_STATUS_RECTIFY";

    /**
     * EXCEL导入
     */
    public static final String ERROR_FILE_EXCEL_EXT = "ERROR_FILE_EXCEL_EXT";

    /**
     * 借款人
     */
    public static final String ERROR_BOWWOWER_PERSONAL_NOT_EXIST = "ERROR_BOWWOWER_PERSONAL_NOT_EXIST";
    public static final String ERROR_BOWWOWER_ENTERPRISE_NOT_EXIST = "ERROR_BOWWOWER_ENTERPRISE_NOT_EXIST";
}
