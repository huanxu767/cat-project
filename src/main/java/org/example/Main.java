package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {

    public static final String SQL = "select * from t_test ";

    public static void main(String[] args) {

        List<Map> list = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL);
            while (rs.next()) {
                Map map = new HashMap();
                map.put("id",rs.getLong("id"));
                map.put("name",rs.getString("name"));
                list.add(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(rs, statement, connection);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}