package code.tianmao.h5.service;


import code.tianmao.h5.dto.ItemsDto;
import code.tianmao.h5.dto.queryDto.ItemsQueryDto;
import code.tianmao.h5.sysconfig.exception.BusinessException;
import code.tianmao.h5.sysconfig.mybatis.Page.PageModel;
import com.github.pagehelper.PageInfo;

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

	/**
	 * 查询商品列表
	 *
	 * @param itemQueryDto 查询条件
	 * @return 分页结果
     */
	PageInfo<ItemsDto> findItemsPage(ItemsQueryDto itemQueryDto, PageModel pageModel) throws Exception;

	/**
	 * 新增商品
	 *
	 * @param itemsDto 商品信息
     */
	void addItems(ItemsDto itemsDto) throws BusinessException;

	/**
	 * 编辑商品
	 *
	 * @param itemsDto 商品信息
     */
	void editItems(ItemsDto itemsDto) throws BusinessException;

	/**
	 * 查询商品信息
	 *
	 * @param itemsId 商品ID
	 * @return  商品信息
     */
	ItemsDto findItemsById(Long itemsId);
}
