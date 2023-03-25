package com.sc.admin.controller.item;

import com.sc.admin.service.item.AdminItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class AdminItemController {
    private final AdminItemService scjAdminItemService;

}
