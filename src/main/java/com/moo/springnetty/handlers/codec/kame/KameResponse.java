package com.moo.springnetty.handlers.codec.kame;

/**
 * Created with IntelliJ IDEA.
 * User: zheng
 * Date: 14-3-4
 * Time: 下午9:15
 */
public class KameResponse {

    private byte encode;// 数据编码格式。
    private byte encrypt;// 加密类型。0表示不加密
    private byte extend1;// 用于扩展协议
    private byte extend2;// 用于扩展协议
    private int sessionId;// 会话ID
    private int result;// 结果码

    public byte getEncode() {
        return encode;
    }

    public void setEncode(byte encode) {
        this.encode = encode;
    }

    public byte getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(byte encrypt) {
        this.encrypt = encrypt;
    }

    public byte getExtend1() {
        return extend1;
    }

    public void setExtend1(byte extend1) {
        this.extend1 = extend1;
    }

    public byte getExtend2() {
        return extend2;
    }

    public void setExtend2(byte extend2) {
        this.extend2 = extend2;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "XLResponse [encode=" + encode + ", encrypt=" + encrypt + ", extend1=" + extend1 + ", extend2=" + extend2
                + ", sessionid=" + sessionId + ", result=" + result + "]";
    }


}
