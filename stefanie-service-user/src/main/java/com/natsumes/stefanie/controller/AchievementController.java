package com.natsumes.stefanie.controller;

import com.github.pagehelper.PageInfo;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.vo.AchievementVo;
import com.natsumes.stefanie.entity.vo.ProfitVo;
import com.natsumes.stefanie.pojo.User;
import com.natsumes.stefanie.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.natsumes.stefanie.consts.StefanieConst.CURRENT_USER;


@RestController
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping("/achievement")
    public Response<AchievementVo> list(HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return achievementService.list(user.getId());
    }

    @GetMapping("/achievement/profit")
    public Response<ProfitVo> profit(HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return achievementService.profit(user.getId());
    }

    @GetMapping("/achievement/detail")
    public Response<PageInfo> detail(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                     HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return achievementService.detail(user.getId(), pageNum, pageSize);
    }

//    @GetMapping("/achievement/paid")
//    public ResponseVo<PageInfo> paid(Integer id, HttpSession session) {
//        User user = (User) session.getAttribute(CURRENT_USER);
//        return achievementService.detail(user.getId(), pageNum, pageSize);
//    }
}
