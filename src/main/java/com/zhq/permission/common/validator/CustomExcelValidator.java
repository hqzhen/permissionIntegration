package com.zhq.permission.common.validator;

import com.zhq.permission.common.components.easyexcel.validator.ExcelValidator;
import com.zhq.permission.common.components.easyexcel.validator.ReadRow;
import com.zhq.permission.common.components.easyexcel.validator.ReadRows;
import com.zhq.permission.common.components.easyexcel.validator.errors.DefaultExcelObjectError;
import com.zhq.permission.common.components.easyexcel.validator.errors.ExcelValidErrors;
import com.zhq.permission.common.pojo.dto.DemoData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhq
 * @create 2022/9/2 22:05
 * @desc
 **/
@Component
public class CustomExcelValidator implements ExcelValidator<DemoData> {
    @Override
    public ExcelValidErrors validate(ReadRows<DemoData> readRows) {
        ExcelValidErrors errors = new ExcelValidErrors();

        Map<Integer, List<ReadRow<DemoData>>> group = readRows.getRows().stream()
                .collect(Collectors.groupingBy(item -> item.getData().getInteger()));

        for (Map.Entry<Integer, List<ReadRow<DemoData>>> entry : group.entrySet()) {
            if (entry.getValue().size() > 1) {
                for (ReadRow<DemoData> readRow : entry.getValue()) {
                    errors.addError(new DefaultExcelObjectError(readRow.getRowIndex() + 1, "参数重复"));
                }
            }
        }
        return errors;
    }
}
