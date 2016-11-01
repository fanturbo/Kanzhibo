package pub.kanzhibo.app.model;

import java.io.Serializable;

/**
 * Created by turbo on 2016/11/1.
 * 一般情况下会用到这个基类，因为服务器会返回统一的格式,但是这儿因为多个平台返回格式并不统一，所以没有用到
 */

public class BaseResponse<T> implements Serializable {
    int code;
    int msg;
    T data;
}
