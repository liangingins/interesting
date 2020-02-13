package com.wenliang.demo.common.utils;

import com.github.pagehelper.PageInfo;
import com.wenliang.demo.common.mode.response.QueryPageResult;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/11
 */
public class PageUtils {

    public static QueryPageResult getQueryPageResult(PageInfo pageInfo){
        QueryPageResult queryPageResult = new QueryPageResult();
        queryPageResult = new QueryPageResult();
        queryPageResult.setPageNum(pageInfo.getPageNum());
        queryPageResult.setPageSize(pageInfo.getPageSize());
        queryPageResult.setToatalPages(pageInfo.getPages());
        queryPageResult.setTotalSize(pageInfo.getTotal());
        queryPageResult.setContent(pageInfo.getList());
        return queryPageResult;
    }


}
