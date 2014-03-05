package com.moo.springnetty.handlers.codec.kame;

/**
 * Kame Request Data
 * 协议内容
 * 编码方式(1byte)
 * 加密(1byte)
 * 扩展1(1byte)
 * 扩展2(1byte)
 * 会话ID(4byte)
 * 命令(4byte)
 * 包长(4byte)
 */
public class KameRequest {

    private byte encode; //编码格式
    private byte encrypt; //加密类型
    private byte extend1;
    private byte extend2;
    private int sessionId;
    private int command;


    // 默认构造函数
    public KameRequest() {
    }

    public KameRequest(int command, int sessionId, byte extend1, byte extend2, byte encrypt, byte encode) {

        this.command = command;
        this.sessionId = sessionId;
        this.extend2 = extend2;
        this.extend1 = extend1;
        this.encrypt = encrypt;
        this.encode = encode;
    }

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

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "XLRequest [encode=" + encode + ", encrypt=" + encrypt + ", extend1=" + extend1 + ", extend2=" + extend2
                + ", sessionid=" + sessionId + ", command=" + command + "]";
    }

}
