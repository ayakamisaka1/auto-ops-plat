package xsj.auto.ops.plat.api.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class ResultBody<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    // 返回状态码
    private String code;
    // 返回体
    private T data;
    // 返回信息
    private String msg;

    public static <T> ResultBody<T> ok() {
        return returnResult(CommonEnum.SUCCESS.getCode(), null, CommonEnum.SUCCESS.getDesc());
    }

    public static <T> ResultBody<T> ok(T data) {
        return returnResult(CommonEnum.SUCCESS.getCode(), data, CommonEnum.SUCCESS.getDesc());
    }

    public static <T> ResultBody<T> ok(T data, String msg) {
        return returnResult(CommonEnum.SUCCESS.getCode(), data, msg);
    }

    public static <T> ResultBody<T> fail() {
        return returnResult(CommonEnum.FAIL.getCode(), null, CommonEnum.FAIL.getDesc());
    }

    public static <T> ResultBody<T> fail(T data) {
        return returnResult(CommonEnum.FAIL.getCode(), data, CommonEnum.FAIL.getDesc());
    }

    public static <T> ResultBody<T> fail(T data, String msg) {
        return returnResult(CommonEnum.FAIL.getCode(), data, msg);
    }

    // 统一返回信息
    public static <T> ResultBody<T> returnResult(String code, T data, String msg) {
        final ResultBody<T> result = new ResultBody<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
}
