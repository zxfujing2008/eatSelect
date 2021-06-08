package cn.yangyy.jx3.common.enums;

/**
 * 删除枚举
 */
public enum DelFlagEnum {

    NORMAL("0","正常"),
    DELETED("1","已删除"),
    ;

    DelFlagEnum(String code,String text) {
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
