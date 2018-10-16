package com.example.rocketmq.dao;

/**
 * @author wangqianlong
 * @create 2018-10-16 18:36
 */

public class OrderDemo {
    private Long OrderId;
    private String Desc;

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    @Override
    public String toString() {
        return "OrderDemo{" +
                "OrderId=" + OrderId +
                ", Desc='" + Desc + '\'' +
                '}';
    }
}
