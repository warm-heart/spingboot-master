package com.example.mybatis.ReflectEntity;

import com.example.mybatis.entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-11-05 19:55
 */

public class Main {
    //用于测试的方法
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, ClassNotFoundException {
        Connection conn = DbUtils.getConn();
        ResultSet rs = null;
        PreparedStatement psmt = null;
        System.out.println(conn);
        try {
            psmt = conn.prepareStatement("select * from company");
            rs = psmt.executeQuery();
            List list = DbUtils.populate(rs, Company.class);
            for (int i = 0; i < list.size(); i++) {
                Company company = (Company) list.get(i);
               /* System.out.println("company : id = " + company.getCompanyId() + "" +
                        " name := " + company.getCompanyName());*/
                System.out.println("实体为:  "+company);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                psmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }

    }

}

