package com.yupi.springbootinit.manager;

import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 季 雷
 * @version 1.0
 * @Date 2023/07/23/20:07
 */
@Service
public class AiManager {
    @Resource
    private YuCongMingClient congMingClient;

    public String doChat(long modelId, String message) {
        DevChatRequest devChatRequest = new DevChatRequest();
        //鱼聪明平台模型id
        devChatRequest.setModelId(modelId);
        devChatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = congMingClient.doChat(devChatRequest);
        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI响应错误");
        }
        return response.getData().getContent();
    }
}
