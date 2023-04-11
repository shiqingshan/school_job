package com.sc.web.controller.item;

import com.sc.model.entity.item.vo.ItemCreateReqVO;
import com.sc.model.entity.item.vo.ItemResVO;
import com.sc.app.service.item.IAdminItemService;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class AdminItemController {
    private final IAdminItemService adminItemService;

    /**
     * 添加菜单项
     */
    @RequestMapping("/add")
    public Result<ItemResVO> addItem(@RequestBody ItemCreateReqVO itemCreateReqVO){
        return ResultUtils.success(adminItemService.addItem(itemCreateReqVO));
    }
}
