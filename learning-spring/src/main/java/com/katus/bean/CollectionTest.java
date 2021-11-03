package com.katus.bean;

import lombok.Data;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-25
 */
@Data
public class CollectionTest {
    private String[] array;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;
    private List<Dept> deptList;
    private Properties properties;
}
