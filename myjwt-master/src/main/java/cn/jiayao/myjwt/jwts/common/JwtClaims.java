package cn.jiayao.myjwt.jwts.common;

import java.util.HashMap;
import java.util.Objects;

/**
 * 类 名: JwtClaims
 * 描 述:
 * 作 者: 黄加耀
 * 创 建: 2019/4/30 : 9:24
 * 邮 箱: huangjy19940202@gmail.com
 *
 * @author: jiaYao
 */
public class JwtClaims extends HashMap {

    public JwtClaims() {
        this.put(ID, null);
        this.put(NAME, null);
        this.put(PHONE, null);
        this.put(FAILURETIME, null);
    }

    String ID = "id";
    String NAME = "name";
    String PHONE = "phone";
    /**
     * 有效期
     */
    String FAILURETIME = "failureTime";

    public JwtClaims put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 重写hashCode方法
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this);
    }
}
