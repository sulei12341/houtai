package code.tianmao.h5.service;


import code.tianmao.h5.dto.ItemsDto;
import code.tianmao.h5.dto.queryDto.ItemsQueryDto;
import code.tianmao.h5.sysconfig.exception.BusinessException;
import code.tianmao.h5.sysconfig.mybatis.Page.PageResultVo;

/**
 * 
 * <p>Title: ItemsService</p>
 * <p>Description:商品service接口 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-20下午3:02:15
 * @version 1.0
 */
public interface ItemsService {
	
	//删除商品信息
	public void deleleItems(Integer id) throws Exception;
	
	//商品查询列表
	PageResultVo<ItemsDto> findItemsPage(ItemsQueryDto itemQueryDto) throws Exception;
	
	void addItems(ItemsDto itemsDto);

	void editItems(ItemsDto itemsDto) throws BusinessException;

	ItemsDto findItemsById(Long itemsId);
}
