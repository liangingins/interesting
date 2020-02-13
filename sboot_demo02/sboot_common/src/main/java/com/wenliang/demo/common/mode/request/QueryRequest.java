package com.wenliang.demo.common.mode.request;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/3
 */
@Data
@ToString
public class QueryRequest {

    int page;

    int size;

    Map<String,String> map;
}
