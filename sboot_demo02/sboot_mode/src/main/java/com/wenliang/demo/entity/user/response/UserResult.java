package com.wenliang.demo.entity.user.response;

import com.wenliang.demo.entity.user.User;
import lombok.Data;
import lombok.ToString;
import com.wenliang.demo.common.mode.response.ResponseResult;
import com.wenliang.demo.common.mode.response.ResultCode;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/1/31
 */
@Data
@ToString
public class UserResult extends ResponseResult {

    User user;

    public UserResult(ResultCode resultCode, User user) {
        super(resultCode);
        this.user = user;
    }
}
