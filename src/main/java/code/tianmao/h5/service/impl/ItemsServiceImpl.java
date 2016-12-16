package code.tianmao.h5.service.impl;


import code.tianmao.h5.dao.ItemsDao;
import code.tianmao.h5.domain.business.Items;
import code.tianmao.h5.dto.ItemsDto;
import code.tianmao.h5.dto.queryDto.ItemsQueryDto;
import code.tianmao.h5.service.ItemsService;
import code.tianmao.h5.sysconfig.exception.BusinessException;
import code.tianmao.h5.sysconfig.mybatis.Page.PageResultVo;
import code.tianmao.h5.utils.BeanUtilPlus;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsDao itemsDao;

	@Override
	public void deleleItems(Integer id) throws Exception {

	}

	//商品查询列表
	@Override
	public PageResultVo<ItemsDto> findItemsPage(ItemsQueryDto itemQueryDto) throws Exception {
        Items items = BeanUtilPlus.copyAs(itemQueryDto, Items.class);
        Page<ItemsDto> itemsDtos = itemsDao.selectPage(items);
        return new PageResultVo<ItemsDto>(itemsDtos);
	}

	@Override
	public void addItems(ItemsDto itemsDto) {
		Items items = BeanUtilPlus.copyAs(itemsDto, Items.class);
		itemsDao.insert(items);
	}

	@Override
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
