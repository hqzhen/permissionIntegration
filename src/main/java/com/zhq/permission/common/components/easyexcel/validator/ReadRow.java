package com.zhq.permission.common.components.easyexcel.validator;

/**
 * @author zhq
 * @create 2022/9/2 21:48
 * @desc
 **/
public class ReadRow<T> {

    /**
     * Returns row index of a row in the sheet that contains this cell.Start form 0.
     */
    private final Integer rowIndex;

    private final T data;


    public ReadRow(Integer rowIndex, T data) {
        this.rowIndex = rowIndex;
        this.data = data;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ReadRow{" +
                "rowIndex=" + rowIndex +
                ", data=" + data +
                '}';
    }
}
