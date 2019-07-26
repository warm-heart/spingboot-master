package Jdkproxy;



/**
 * @author wangqianlong
 * @create 2019-07-26 15:00
 */

public class Bmw implements Bus {

    @Override
    public String move(String s) {
        return s;
    }

    @Override
    public String go(String s,String a) {
        return a;
    }
}
