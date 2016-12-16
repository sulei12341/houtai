package code.tianmao.h5.dao;

import code.tianmao.h5.domain.business.Items;
import code.tianmao.h5.dto.ItemsDto;
import code.tianmao.h5.sysconfig.mybatis.mapper.ExpandMapper;

/**
 * @author Junpeng.Su
 * @date 2016/12/13
 */
public interface ItemsDao extends ExpandMapper<Items, ItemsDto>{
}
