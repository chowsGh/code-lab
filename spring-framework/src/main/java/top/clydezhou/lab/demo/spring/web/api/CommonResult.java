package top.clydezhou.lab.demo.spring.web.api;

import java.io.Serializable;

/**
 * @author clyde
 * @date 2020-07-02 23:33
 */
public class CommonResult<T> extends SimpleResult implements Serializable {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
