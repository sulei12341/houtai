package code.tianmao.h5.service.impl;


import code.tianmao.h5.dao.ItemsDao;
import code.tianmao.h5.dao.query.ItemsExample;
import code.tianmao.h5.domain.business.Items;
import code.tianmao.h5.dto.ItemsDto;
import code.tianmao.h5.dto.queryDto.ItemsQueryDto;
import code.tianmao.h5.service.ItemsService;
import code.tianmao.h5.sysconfig.exception.BusinessException;
import code.tianmao.h5.sysconfig.mybatis.Page.PageModel;
import code.tianmao.h5.utils.BeanUtilPlus;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsDao itemsDao;

	@Override
	public void deleleItems(Integer id) throws Exception {

	}

	//商品查询列表
	@Override
	public PageInfo<ItemsDto> findItemsPage(ItemsQueryDto itemQueryDto, PageModel pageModel) throws Exception {
//        Items items = BeanUtilPlus.copyAs(itemQueryDto, Items.class);
//        example.orderBy("itemsCode").asc();
        Example example = ItemsExample.getExample(itemQueryDto, pageModel);
        List<Items> itemsList = itemsDao.selectByExample(example);
        List<ItemsDto> itemsDtoList = new ArrayList<>();
        for (Items items : itemsList  ) {
            ItemsDto itemsDto = BeanUtilPlus.copyAs(items, ItemsDto.class);
            itemsDtoList.add(itemsDto);
        }
        //TODO 留作备份
        //       Page<Items> itemses = itemsDao.selectPage(items);
        //        return new PageResultVo<Items>(itemses);

        return new PageInfo(itemsDtoList);
	}

	@Override
    @Transactional(rollbackFor = BusinessException.class)
	public void addItems(ItemsDto itemsDto) throws BusinessException {
        Items item = new Items();
        item.setName("lllllll");
        item.setPrice(11F);
        itemsDao.insert(item);

		Items items = BeanUtilPlus.copyAs(itemsDto, Items.class);
//        throw new BusinessException("产品不存在");

        itemsDao.insert(items);
	}

	@Override
    @Transactional(rollbackFor = BusinessException.class)
    public void editItems(ItemsDto itemsDto) throws BusinessException {
        Items items = itemsDao.selectByPrimaryKey(itemsDto.getId());
        if(items == null){
            throw new BusinessException("产品不存在");
        }
        BeanUtilPlus.copyNotNullProperties(itemsDto, items);
        itemsDao.updateByPrimaryKey(items);
    }

    @Override
    public ItemsDto findItemsById(Long itemsId) {
        Items items = itemsDao.selectByPrimaryKey(itemsId);
        return BeanUtilPlus.copyAs(items, ItemsDto.class);
    }
}
