package com.example.utilhub.tree;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeService {

    public List<Map<String, Object>> tree(){
        List<Map<String,Object>> list = new ArrayList<>();

        //임시 데이터
        int target = 5;
        for(int i = 0 ; i <target ; i++){
            for(int j = 0; j >= i; j++){
                Map<String,Object> data = new HashMap<>();
                data.put("id", i);
                data.put("title", i + " - " + j);
                list.add(data);
            }
        }

        String root = "0";
        Tree tree = new Tree(list,root);
        return tree.getResult();
    }
}
