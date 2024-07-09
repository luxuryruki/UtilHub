package com.example.utilhub.tree;

import org.apache.commons.lang3.StringUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tree {
    private List<Map<String,Object>> list = new ArrayList<>();
    private final List<Map<String, Object>> items = new ArrayList<>();
    private String upperId = "";

    public Tree(List<Map<String,Object>> list) {
        this.list = list;
    }

    public Tree(List<Map<String,Object>> list, String upperId) {
        this.list = list;
        this.upperId = upperId;
    }

    public List<Map<String, Object>> getResult() {
        if (StringUtils.isEmpty(upperId)) {
            this.upperId = "0";
        }
        for (Map<String,Object> top : getSubList(upperId)) {
            TreeItem treeItem = new TreeItem(top);
            treeItem.setSubList(getSubList((String) top.get("id")));
            findChildren(treeItem);
            items.add(treeItem.toMap());
        }
        return this.items;
    }

    private void findChildren(TreeItem parent) {
        if (parent.getSubList().size() == 0) {
            return;
        }

        for (Map<String,Object> map : parent.getSubList()) {
            TreeItem treeItem = new TreeItem(map);
            List<Map<String,Object>> subList = getSubList((String)map.get("id"));
            if (subList.size() != 0) {
                treeItem.setSubList(subList);
                findChildren(treeItem);
            }
            parent.addChildren(treeItem.toMap());
        }
    }

    private List<Map<String,Object>> getSubList(String upperId) {
        return list.stream().filter(map -> StringUtils.equals((String)map.get("upperId"), upperId)).collect(Collectors.toList());
    }
}


