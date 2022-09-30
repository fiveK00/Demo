package com.example.common;

import java.util.List;

/**
 * @author dc.wang <dc.wang@idiaoyan.com>
 * @version V1.0
 * @date 2022/9/16 15:58
 */
public interface DynamicExcelSupporter<T> {
    /**
     * excel heads
     *
     * @return
     */
    List<String> getHeads();

    /**
     * excel row
     *
     * @return
     */
    List<String> getRow(T t);
}
