package cn.yangyy.jx3.common.enums;

/**
 * 网络类型枚举
 */
public enum NetworkTypesEnum {

    DOUBLE("double","双线"),
    TELECOM("telecom","电信"),
    NETCOM("netcom","网通"),

    ;


    NetworkTypesEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

    private String code;

    private String text;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
