package KS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JSselect {
    private Connection conn = Data.getConn();
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public static void closeServ(PreparedStatement p, ResultSet r) {
        try {
            p.close();
            r.close();
        }
        catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    public List<JS> queryALLjxlykjs(String text) {
        String sql = "select * from js where jxlbh = '" + text + "' and sfsy = '1'";
        List<JS> list = new ArrayList<JS>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(ps.toString());
            while(rs.next()) {
                JS newJS = new JS();
                newJS.setJSBH(rs.getString(1));
                newJS.setJXLBH(rs.getString(2));
                newJS.setKJ(rs.getString(3));
                newJS.setSFSY(rs.getString(4));
                newJS.setRNRS(rs.getString(5));
                list.add(newJS);
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        finally {
            closeServ(ps, rs);
        }
        return list;
    }
    public List<JS> queryALLjxlwkjs(String text) {
        String sql = "select * from js where jxlbh = '" + text + "' and sfsy = '0'";
        List<JS> list = new ArrayList<JS>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(ps.toString());
            while(rs.next()) {
                JS newJS = new JS();
                newJS.setJSBH(rs.getString(1));
                newJS.setJXLBH(rs.getString(2));
                newJS.setKJ(rs.getString(3));
                newJS.setSFSY(rs.getString(4));
                newJS.setRNRS(rs.getString(5));
                list.add(newJS);
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        finally {
            closeServ(ps, rs);
        }
        return list;
    }
    public List<JS> queryALLkjykjs(String text) {
        String sql = "select * from js where kj = '" + text + "' and sfsy = '1'";
        List<JS> list = new ArrayList<JS>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(ps.toString());
            while(rs.next()) {
                JS newJS = new JS();
                newJS.setJSBH(rs.getString(1));
                newJS.setJXLBH(rs.getString(2));
                newJS.setKJ(rs.getString(3));
                newJS.setSFSY(rs.getString(4));
                newJS.setRNRS(rs.getString(5));
                list.add(newJS);
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        finally {
            closeServ(ps, rs);
        }
        return list;
    }
    public List<JS> queryALLkjwkjs(String text) {
        String sql = "select * from js where kj = '" + text +"' and sfsy = '0'";
        List<JS> list = new ArrayList<JS>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(ps.toString());
            while(rs.next()) {
                JS newJS = new JS();
                newJS.setJSBH(rs.getString(1));
                newJS.setJXLBH(rs.getString(2));
                newJS.setKJ(rs.getString(3));
                newJS.setSFSY(rs.getString(4));
                newJS.setRNRS(rs.getString(5));
                list.add(newJS);
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        finally {
            closeServ(ps, rs);
        }
        return list;
    }
    public List<JS> queryALLwkjs() {
        String sql = "select * from js where sfsy = '0'";
        List<JS> list = new ArrayList<JS>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(ps.toString());
            while(rs.next()) {
                JS newJS = new JS();
                newJS.setJSBH(rs.getString(1));
                newJS.setJXLBH(rs.getString(2));
                newJS.setKJ(rs.getString(3));
                newJS.setSFSY(rs.getString(4));
                newJS.setRNRS(rs.getString(5));
                list.add(newJS);
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        finally {
            closeServ(ps, rs);
        }
        return list;
    }
}
