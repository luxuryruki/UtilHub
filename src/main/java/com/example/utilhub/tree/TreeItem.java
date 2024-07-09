package com.example.utilhub.tree;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TreeItem {
    private String id = "";
    private String name = "";
    private String upperId = "";
    private List<Map<String,Object>> subList = new ArrayList<>();
    private List<Map<String, Object>> children = new ArrayList<>();

    public TreeItem(Map<String,Object> map) {
        this.id = (String) map.get("id");
        this.name = (String) map.get("name");
        this.upperId = (String )map.get("upperId");
    }

    public List<Map<String,Object>> getSubList() {
        return subList;
    }

    public void setSubList(List<Map<String,Object>> subList) {
        this.subList = subList;
    }

    public List<Map<String, Object>> getChildren() {
        return children;
    }

    public void setChildren(List<Map<String, Object>> children) {
        this.children = children;
    }

    public void addChildren(Map<String, Object> map) {
        this.children.add(map);
    }

    public boolean isRoot() {
        return StringUtils.equals(this.upperId, "root");
    }


    public Map<String, Object> toMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", this.id);
        map.put("name", this.name);
        if (children.size() > 0) {
            map.put("children", this.children);
        }
        return map;
    }

}
