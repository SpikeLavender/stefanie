package com.natsumes.stefanie.service;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.pojo.PayInfo;

import java.math.BigDecimal;

public interface PayService {
    /**
     * 创建/发起支付
     *
     * @param orderId
     * @param amount
     */
    Response<PayResponse> create(Integer userId, String orderId, String openId, BigDecimal amount, BestPayTypeEnum payTypeEnum);


    /**
     * 异步通知
     *
     * @param notifyData
     * @return
     */
    String asyncNotify(String notifyData);

    /**
     * 查询支付记录（通过订单ID）
     *
     * @param orderId
     * @return
     */
    PayInfo queryByOrderId(String orderId);
}
