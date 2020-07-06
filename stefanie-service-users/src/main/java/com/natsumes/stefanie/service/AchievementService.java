package com.natsumes.stefanie.service;

import com.github.pagehelper.PageInfo;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.vo.AchievementVo;
import com.natsumes.stefanie.entity.vo.ProfitVo;
import org.springframework.stereotype.Service;

@Service
public interface AchievementService {

    /**
     * 用户业绩查询
     *
     * @param uId
     * @return
     */
    Response<AchievementVo> list(Integer uId);

    Response<ProfitVo> profit(Integer uId);

    Response<PageInfo> detail(Integer uId, Integer pageNum, Integer pageSize);

}
