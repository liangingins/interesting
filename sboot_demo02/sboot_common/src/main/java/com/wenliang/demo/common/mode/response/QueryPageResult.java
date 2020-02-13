package com.wenliang.demo.common.mode.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;
/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/11
 */
@Data
@ToString
public class QueryPageResult {

    /**
    当前页码
    */
    int pageNum;

    /**
    每页数量
    */
    int pageSize;

    /**
     * 总记录数
     */
    long totalSize;

    /**
     * 总页数
     */
    int toatalPages;

    /**
     *   数据模型
     */
    List<?> content;


}
