package code.tianmao.h5.controller.items;

import code.tianmao.h5.dto.ItemsDto;
import code.tianmao.h5.dto.queryDto.ItemsQueryDto;
import code.tianmao.h5.service.ItemsService;
import code.tianmao.h5.sysconfig.mybatis.Page.PageResultVo;
import code.tianmao.h5.sysconfig.mybatis.Page.PageModel;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author Junpeng.Su
 * @date 2016/12/13
 */
@Controller()
@RequestMapping("/items")
public class ItemsController {

    @Resource
    private ItemsService itemsService;

    /**
     * 查询商品列表
     *
     * @param itemsQueryDto 查询条件
     * @param model         模型
     * @return 返回结果
     */
    @RequestMapping("/findItemsPage")
    @RequiresPermissions("item:query")//执行queryItems需要"item:query"权限
    public String findItemsPage(ItemsQueryDto itemsQueryDto, PageModel pageModel, Model model) throws Exception {
        //调用service查询商品列表
        PageResultVo<ItemsDto> itemsPage = itemsService.findItemsPage(itemsQueryDto, pageModel);

        model.addAttribute("itemsList", itemsPage.getList());

        HashMap<String, String> itemsType = new HashMap<String, String>();
        itemsType.put("", "全部");
        itemsType.put("001", "台式机");
        itemsType.put("002", "笔记本");
        itemsType.put("003", "背包");
        model.addAttribute("itemsType", itemsType);
        return "itemsList";
    }

    /**
     * 跳转新增页面
     *
     * @return 新增页面
     */
    @RequestMapping("/addItemsInit")
    @RequiresPermissions("item:create")//执行queryItems需要"item:query"权限
    public String addItemsInit() throws Exception {
        return "editItem";
    }

    /**
     * 新增商品
     *
     * @param itemsDto 商品信息
     * @return 跳转列表页面
     */
    @RequestMapping("/addItems")
    public String addItems(ItemsDto itemsDto) throws Exception {
        itemsService.addItems(itemsDto);
        return "itemsList";
    }

    /**
     * 编辑商品页面跳转
     *
     * @param itemsId 商品信息
     * @param model   模型
     * @return 编辑商品页面
     */
    @RequestMapping("/editItemsInit")
    public String editItemsInit(Long itemsId, Model model) throws Exception {
        ItemsDto itemsDto = itemsService.findItemsById(itemsId);
        model.addAttribute("itemsDto", itemsDto);
        return "editItem";
    }

    /**
     * 编辑商品
     *
     * @param itemsDto 商品信息
     * @return 跳转列表页面
     */
    @RequestMapping("/editItems")
    public String editItems(ItemsDto itemsDto) throws Exception {
        itemsService.editItems(itemsDto);
        return "itemsList";
    }


}
