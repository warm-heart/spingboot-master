package cn.jiayao.myjwt.jwts.common;

/**
 * 类 名: Header
 * 描 述: 定义加密算法
 * 作 者: 黄加耀
 * 创 建: 2019/4/30 : 9:25
 * 邮 箱: huangjy19940202@gmail.com
 *
 * @author: jiaYao
 */
public enum Header {

    SM3("sm3","国密3加密算法,其算法不可逆，类似于MD5"),
    SM4("sm4","国密4加密算法，对称加密"),
    AES("aes","AES加密算法，对称加密");

    private String code;

    private String details;

    Header(String code, String details) {
        this.code = code;
        this.details = details;
    }

}
