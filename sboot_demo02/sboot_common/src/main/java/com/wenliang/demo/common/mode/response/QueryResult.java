package com.wenliang.demo.common.mode.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/1/29
 */
@Data
@ToString
public class QueryResult<T> {

    List<T> list;

    int total;

    public QueryResult() {
    }

    public QueryResult(List<T> list, int total) {
        this.list = list;
        this.total = total;
    }
}
