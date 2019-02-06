package main;

import java.sql.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.sql.*;
//import oracle.jdbc.OracleDriver;

public class Main{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url="jdbc:oracle:thin:@//localhost:1523/orcl.sigma.sbrf.ru";
        String username="SRVPRJCTCNNCTN";
        String password="SRVPRJCTCNNCTN";
        Class.forName("oracle.jdbc.OracleDriver");
        Connection conn = DriverManager.getConnection(url,username,password);
        try {
            Statement stmt = conn.createStatement();
            try {
                ResultSet rset = stmt.executeQuery("select * from SRVPRJCT.TBL");
                try {
                    String[] collumnNames = {"id", "name"};
                    while (rset.next()) {
                        StringBuilder res = new StringBuilder("[" + rset.getRow() + "]");
                        for (String colName : collumnNames) {
                            res.append(" ");
                            res.append(colName);
                            res.append(":");
                            res.append(rset.getString(colName));
                        }
                        System.out.println(res.toString());
                    }
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

}

