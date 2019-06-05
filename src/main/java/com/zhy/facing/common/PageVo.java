package com.zhy.facing.common;

public class PageVo {
    private int pageno;//当前页
    private int pagesize;//每页显示数量
    private int totalrow;//总记录数
    private int totalpage;//总行数

    public PageVo(int pageno, int pagesize, int totalrow, int totalpage) {
        this.pageno = pageno;
        this.pagesize = pagesize;
        this.totalrow = totalrow;
        this.totalpage = totalpage;
    }

    public static String getLimitSql(int pageNo, int pageSie) {
        int num = pageSie * (pageNo - 1);
        return " limit " + num + "," + pageSie;
    }

    public static int getTotalPage(int pagesize, int totalrow) {
        int size = totalrow / pagesize;//总条数/每页显示的条数=总页数
        int mod = totalrow % pagesize;//最后一页的条数
        if (mod != 0)
            size++;
        return totalrow == 0 ? 1 : size;

    }


    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalrow() {
        return totalrow;
    }

    public void setTotalrow(int totalrow) {
        this.totalrow = totalrow;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

}
