package com.wenliang.demo.common.mode.response;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/11
 */
@Data
@ToString
public class QueryPageResponseResult extends ResponseResult {
    QueryPageResult queryPageResult;

    public QueryPageResponseResult(ResultCode resultCode, QueryPageResult queryPageResult) {
        super(resultCode);
        this.queryPageResult = queryPageResult;
    }
}
