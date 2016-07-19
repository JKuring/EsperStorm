package com.eastcom.data.map;

import com.eastcom.data.EsperData;

import java.util.HashMap;

/**
 * Created by linghang.kong on 2016/7/19.
 */
public class CustomMap extends HashMap implements EsperData {

    @Override
    public String getDataType() {
        return this.getClass().getName();
    }

}
