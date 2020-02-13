package com.wenliang.demo.common.mode.response;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/1/29
 */
@Data
@ToString
public class QueryResultResponse extends ResponseResult {

    QueryResult queryResult;

    public QueryResultResponse(QueryResult queryResult) {
        this.queryResult = queryResult;
    }

    public QueryResultResponse(ResultCode resultCode, QueryResult queryResult) {
        super(resultCode);
        this.queryResult = queryResult;
    }
}
