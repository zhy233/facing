package com.zhy.facing.dto;

import com.zhy.facing.common.domain.StatusEnum;
import com.zhy.facing.common.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OutputDto<T> {

    private static Logger logger = LoggerFactory.getLogger(OutputDto.class);
    String messgae;
    int status = 0;
    T data;
    List<T> dataList;

    int page = 0;	//当前页数
    int totalRecords = 0;	//全件数
    int totalPages = 0;  //全页数

    int errorLevel;//错误样式

    public static void printLog(OutputDto outputDto){
        logger.info("------------------------------------------------返回数据------------------------------------------------");
        logger.info(JsonUtils.object2JsonString(outputDto));
    }

    public static OutputDto ok(){
        OutputDto<Object> outputDto = new OutputDto<>();
        outputDto.setStatus(1);
        printLog(outputDto);
        return outputDto;
    }

    public static <T> OutputDto<T> ok(String message){
        OutputDto<T> outputDto = new OutputDto<>();
        outputDto.setStatus(1);
        outputDto.setMessgae(message);
        printLog(outputDto);
        return outputDto;
    }

    public static <T> OutputDto<T> ok(String message, T data) {
        OutputDto<T> outputDto = new OutputDto<>();
        outputDto.setStatus(1);
        outputDto.setMessgae(message);
        outputDto.setData(data);
        printLog(outputDto);
        return outputDto;
    }

    public static OutputDto error(String message){
        OutputDto<Object> outputDto = new OutputDto<>();
        outputDto.setStatus(0);
        outputDto.setMessgae(message);
        return outputDto;
    }

    public static OutputDto error(StatusEnum status){
        OutputDto<Object> outputDto = new OutputDto<>();
        outputDto.setStatus(status.getCode());
        outputDto.setMessgae(status.getMssage());
        printLog(outputDto);
        return outputDto;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(int errorLevel) {
        this.errorLevel = errorLevel;
    }
}
