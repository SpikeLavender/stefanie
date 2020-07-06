package com.natsumes.stefanie.controller;

import com.github.pagehelper.PageInfo;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.vo.AchievementVo;
import com.natsumes.stefanie.entity.vo.ProfitVo;
import com.natsumes.stefanie.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping("/{userId}/achievement")
    public Response<AchievementVo> list(@PathVariable Integer userId) {
        return achievementService.list(userId);
    }

    @GetMapping("/{userId}/achievement/profit")
    public Response<ProfitVo> profit(@PathVariable Integer userId) {
        return achievementService.profit(userId);
    }

    @GetMapping("/{userId}/achievement/detail")
    public Response<PageInfo> detail(@PathVariable Integer userId,
                                     @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return achievementService.detail(userId, pageNum, pageSize);
    }

}
