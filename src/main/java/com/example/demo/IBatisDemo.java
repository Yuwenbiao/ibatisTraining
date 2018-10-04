package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.util.ParameterMap;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * ibatis使用示例
 *
 * @author yuwb@corp.21cn.com
 * @date 2018/10/4 12:41
 */
public class IBatisDemo {
    private SqlMapClient sqlMap;

    public static void main(String[] args) throws IOException, SQLException {

    }

    public void doAction() throws IOException {
        String config = "SqlMapConfig.xml";
        Reader reader = Resources.getResourceAsReader(config);
        sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
    }

    /**
     * 删除操作
     */
    private int delete() throws SQLException {
        return sqlMap.delete("deleteUser", 2);
    }

    /**
     * 更新操作
     */
    private int update() throws SQLException {
        return sqlMap.update("updateUser");
    }

    /**
     * 插入操作
     */
    private int insert() throws SQLException {
        ParameterMap parameterMap = new ParameterMap("userName", "zs", "password", "123", "mobile", "1", "email", "@");
        return sqlMap.update("addUser", parameterMap);
    }

    /**
     * 多参数查询
     */
    private void selectByParameters() throws SQLException {
        ParameterMap parameterMap = new ParameterMap("username", "ywb", "mobile", "19927672430");
        System.out.println((HashMap) sqlMap.queryForObject("getUserByRealNameAndMobile", parameterMap));
    }

    /**
     * 单个参数查询
     */
    private void selectByParameter() throws SQLException {
        HashMap list = (HashMap) sqlMap.queryForObject("getUserByName", "ywb");
        System.out.println(list);
    }

    /**
     * 查询
     * 查询结果为HashMap
     */
    private void selectAll() throws SQLException {
        List<HashMap> list = sqlMap.queryForList("getAllUsers1");
        for (HashMap user : list) {
            System.out.println(user);
        }
    }

    /**
     * 查询
     * 查询结果为User
     */
    private void selectAllUser() throws SQLException {
        List<User> list = sqlMap.queryForList("getAllUsers");
        for (User user : list) {
            System.out.println(user);
        }
    }
}
