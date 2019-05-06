package cn.jiayao.myjwt.modular.tools;

/**
 * 统一结果状态码
 * 系统统一状态码使用 200至500
 */
public class Apistatus {

    public static final Apistatus CODE_200 = new Apistatus(200, "成功");
    public static final Apistatus CODE_400 = new Apistatus(400, "错误的请求");
    public static final Apistatus CODE_401 = new Apistatus(401, "令牌已失效，请重新登录~");
    public static final Apistatus CODE_412 = new Apistatus(412, "参数错误");
    public static final Apistatus CODE_403 = new Apistatus(403, "当前用户未登录");
    public static final Apistatus CODE_500 = new Apistatus(500, "服务器错误");
    /**
     * 状态码
     */
    private int code;
    /**
     * 状态信息
     */
    private String msg;

    public Apistatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
