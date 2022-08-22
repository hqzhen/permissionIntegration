package com.permission.zhq.controller;

import com.permission.zhq.dto.UserActiveDataDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author demo
 * @Program: demo
 * @Description:
 * @date 2021-12-29 15:38
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    private UserActiveDataDto getData() {
        return new UserActiveDataDto(
                Arrays.asList("2021-12-20", "2021-12-21", "2021-12-22"),
                Arrays.asList(120, 132, 101),
                Arrays.asList(220, 182, 191),
                Arrays.asList(150, 232, 201)
        );
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{7, 8, 9};
        int[] nums2 = new int[]{5};
        String aa = "223 3 #d 的 是个很__  EEE=+";
        aa = aa.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(aa);  //输出为   2233d的是个很EEE
        Set<Integer> cache=new HashSet();
        // replaceAll("[\\s*|\t|\r|\n]", "");
        String[] strs=new String[]{"reflower","flow","flight"};
        //rotate(nums, 3);
        // System.out.println(longestCommonPrefix(strs));
    }


}
