package code.tianmao.h5.sysconfig.mybatis.Page;

/**
 * @author Junpeng.Su
 * @date 2016/12/18
 */
public class PageModel {

    private int page = 1;
    private int pageSize = 10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
