package com.example.demo.rule;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhenghongquan
 * @Program: wos-api
 * @Description: 规则执行者
 * @date 2022-08-01 11:46
 */
@Slf4j
public class RuleExecutor {

    private Map<Integer, List<BaseRule>> ruleGroups = new HashMap<>();

    private static final int AND = 1;

    private static final int OR = 0;

    public static RuleExecutor create() {
        return new RuleExecutor();
    }


    public RuleExecutor and(List<BaseRule> ruleList) {
        ruleGroups.put(AND, ruleList);
        return this;
    }

    public RuleExecutor or(List<BaseRule> ruleList) {
        ruleGroups.put(OR, ruleList);
        return this;
    }

    public boolean execute(RuleData ruleData) {
        for (Map.Entry<Integer, List<BaseRule>> item : ruleGroups.entrySet()) {
            List<BaseRule> ruleList = item.getValue();
            switch (item.getKey()) {
                case AND:
                    log.info("and 关系，同步执行");
                    if (!and(ruleData, ruleList)) {
                        return false;
                    }
                    break;
                case OR:
                    log.info("or 关系，并行执行");
                    if (!or(ruleData, ruleList)) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    private boolean and(RuleData ruleData, List<BaseRule> ruleList) {
        for (BaseRule rule : ruleList) {
            boolean execute = rule.execute(ruleData);
            if (!execute) {
                return false;
            }
        }
        return true;
    }

    private boolean or(RuleData ruleData, List<BaseRule> ruleList) {
        for (BaseRule rule : ruleList) {
            boolean execute = rule.execute(ruleData);
            if (execute) {
                return true;
            }
        }
        return false;
    }
}
