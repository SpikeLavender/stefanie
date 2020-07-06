package com.natsumes.stefanie.service;

import com.natsumes.stefanie.entity.form.WxMessageForm;
import com.natsumes.stefanie.wechat.AesException;

public interface CustomerService {

    boolean checkSignature(String signature, String timestamp, String nonce);

    String handleMessage(WxMessageForm wxMessageForm) throws AesException;
}
