package com.wenliang.demo.entity.dishes.response;

import com.wenliang.demo.entity.dishes.Menu;
import lombok.Data;
import lombok.ToString;
import com.wenliang.demo.common.mode.response.ResponseResult;
import com.wenliang.demo.common.mode.response.ResultCode;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/3
 */
@Data
@ToString
public class MenuResult extends ResponseResult {

    Menu menu;

    public MenuResult(ResultCode resultCode, Menu menu) {
        super(resultCode);
        this.menu = menu;
    }
}
