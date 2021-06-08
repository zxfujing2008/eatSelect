package cn.yangyy.jx3.common.enums;

/**
 * 三方交易平台
 * @author zhaox
 * @version v1.0.0 2018-10-29 14:07
 */
public enum TrdPlatform {

    TAOBAO("taobao","淘宝"),
    PLATFORM_5173("5173","5173网站"),
    GAME("game","游戏内担保交易"),
    ;


    TrdPlatform(String code, String text) {
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
