package com.sc.app.controller.menu;

import com.sc.model.entity.menu.vo.MenuCreateReqVO;
import com.sc.model.entity.menu.vo.MenuResVO;
import com.sc.app.service.menu.IAdminMenuService;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@Slf4j
@RequiredArgsConstructor
public class MenuController {
    private final IAdminMenuService adminMenuService;

    /**
     * 添加菜单
     * @param menuCreateReqVO
     * @return
     */
    @RequestMapping("/add")
    public Result<MenuResVO> addMenu(@RequestBody MenuCreateReqVO menuCreateReqVO){
        return ResultUtils.success(adminMenuService.addMenu(menuCreateReqVO));
    }

}
