package code.tianmao.h5.dao.query;

import code.tianmao.h5.domain.business.Items;
import code.tianmao.h5.dto.queryDto.ItemsQueryDto;
import code.tianmao.h5.sysconfig.mybatis.Page.PageModel;
import code.tianmao.h5.utils.SqlFilter;
import code.tianmao.h5.utils.StringUtilPlus;
import com.github.pagehelper.PageHelper;
import tk.mybatis.mapper.entity.Example;

/**
 * @author Junpeng.Su
 * @date 2016/12/19
 */
public class ItemsExample {
    /**
     * 组装查询条件
     *
     * @param itemQueryDto 查询条件
     * @param pageModel 分页信息
     * @return 组装结果
     */
    public static Example getExample(ItemsQueryDto itemQueryDto, PageModel pageModel){
        PageHelper.startPage(pageModel.getPage(),pageModel.getPageSize());
        Example example = new Example(Items.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtilPlus.isNotEmpty(itemQueryDto.getName())){
            String inputName = SqlFilter.filterForLike(itemQueryDto.getName().toUpperCase());
            criteria.andLike("name", inputName);
        }
        if(itemQueryDto.getPrice() != null){
            criteria.andGreaterThanOrEqualTo("price", itemQueryDto.getPrice());
        }
        example.orderBy("id").desc();
        return example ;
    }
}
