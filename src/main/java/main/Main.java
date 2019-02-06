package main;

import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.HashMap;
//import java.util.Map;
//import java.sql.*;
//import oracle.jdbc.OracleDriver;

public class Main{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        for(String str:testJDBC()) {
            System.out.println(str);
        }
        for(String str:testHiber()){
            System.out.println(str);
        }

    }


    public static List<String> testJDBC() throws ClassNotFoundException, SQLException {
            String url="jdbc:oracle:thin:@//localhost:1523/orcl.sigma.sbrf.ru";
            String username="SRVPRJCTCNNCTN";
            String password="SRVPRJCTCNNCTN";
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection(url,username,password);
            List<String> strings = new ArrayList<String>();
            try {
                Statement stmt = conn.createStatement();
                try {
                    ResultSet rset = stmt.executeQuery("select * from SRVPRJCT.TBL");
                    try {
                        String[] collumnNames = {"id", "name"};
                        while (rset.next()) {
                            StringBuilder buffer = new StringBuilder("[" + rset.getRow() + "]");
                            for (String colName : collumnNames) {
                                buffer.append(" ");
                                buffer.append(colName);
                                buffer.append(":");
                                buffer.append(rset.getString(colName));
                            }
                            strings.add(buffer.toString());
                        }
                        return strings;
                    }
                    finally {
                        try { rset.close(); } catch (Exception ignore) {}
                    }
                }
                finally {
                    try { stmt.close(); } catch (Exception ignore) {}
                }
            }
            finally {
                try { conn.close(); } catch (Exception ignore) {}
            }
    }

    public static List<String> testHiber(){
        Configuration configuration=new Configuration();
        configuration.setProperty("hibernate.dialect","org.hibernate.dialect.OracleDialect");
        return null;
    }
}

