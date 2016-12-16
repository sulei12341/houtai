package code.tianmao.h5.domain.business;

import code.tianmao.h5.domain.base.BaseDomain;

import javax.persistence.Table;

/**
 * @author Junpeng.Su
 * @date 2016/12/13
 */
@Table(name = "items")
public class Items extends BaseDomain<Long, Long> {

    private static final long serialVersionUID = 4212044701058803049L;

    private String name;

    private Float price;

    private String itemsCode ;

    private String pic;

    private String detail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getItemsCode() {
        return itemsCode;
    }

    public void setItemsCode(String itemsCode) {
        this.itemsCode = itemsCode;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
