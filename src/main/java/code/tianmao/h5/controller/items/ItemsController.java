package code.tianmao.h5.controller.items;

import code.tianmao.h5.dto.ItemsDto;
import code.tianmao.h5.dto.queryDto.ItemsQueryDto;
import code.tianmao.h5.service.ItemsService;
import code.tianmao.h5.sysconfig.mybatis.Page.PageResultVo;
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
@Controller
public class ItemsController {

    @Resource
    private ItemsService itemsService;

    //商品信息方法
    @RequestMapping("/findItemsPage")
    @RequiresPermissions("item:query")//执行queryItems需要"item:query"权限
    public String findItemsPage(ItemsQueryDto itemsQueryDto, Model model) throws Exception {
        //调用service查询商品列表
        PageResultVo<ItemsDto> itemsPage = itemsService.findItemsPage(itemsQueryDto);

        model.addAttribute("itemsList", itemsPage.getList());

        HashMap<String, String> itemsType = new HashMap<String, String>();
        itemsType.put("", "全部");
        itemsType.put("001", "台式机");
        itemsType.put("002", "笔记本");
        itemsType.put("003", "背包");
        model.addAttribute("itemsType", itemsType);
        return "itemsList";
    }

    @RequestMapping("/addItemsInit")
    public String addItemsInit() throws Exception {
        return "editItem";
    }

    @RequestMapping("/addItems")
    public String addItems(ItemsDto itemsDto) throws Exception {
        itemsService.addItems(itemsDto);
        return "itemsList";
    }


    @RequestMapping("/editItemsInit")
    public String editItemsInit(Long itemsId, Model model) throws Exception {
        ItemsDto itemsDto = itemsService.findItemsById(itemsId);
        model.addAttribute("itemsDto",itemsDto);
        return "editItem";
    }

    @RequestMapping("/editItems")
    public String editItems(ItemsDto itemsDto) throws Exception {
        itemsService.editItems(itemsDto);
        return "itemsList";
    }



}
