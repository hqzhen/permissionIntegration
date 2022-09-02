package com.zhq.permission.common.components.easyexcel.validator.errors;

/**
 * @author zhq
 * @create 2022/9/2 21:52
 * @desc
 **/
public class DefaultExcelValidFieldError extends DefaultExcelObjectError implements ExcelValidFieldError {

    private Integer column;

    public DefaultExcelValidFieldError(Integer row, Integer column, String message) {
        super(row, message);
        this.column = column;
    }

    @Override
    public Integer getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "DefaultExcelValidFieldError{" +
                "column=" + column +
                '}';
    }
}
