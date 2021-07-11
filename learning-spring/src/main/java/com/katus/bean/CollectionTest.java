package com.katus.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-25
 */
public class CollectionTest {
    private String[] array;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;
    private List<Dept> deptList;

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }

    @Override
    public String toString() {
        return "CollectionTest{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", deptList=" + deptList +
                '}';
    }
}
