package com.zhy.facing.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class JsonUtils {

    private static Logger log = LoggerFactory.getLogger(JsonUtils.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static String map2JsonString(Map<String,Object> map){
        String ret = null;
        if(map!=null){
            try {
                ret = mapper.writeValueAsString(map);
            } catch (JsonProcessingException e) {
                log.error("exception catched in map converting to json string! {}",e.toString());
            }
        }else{
            log.error("invalid jsonmap!");
        }
        return ret;
    }

    public static String maplist2JsonString(List<Map<String,Object>> mapList){
        String ret = null;
        if(mapList!=null){
            try {
                ret = mapper.writeValueAsString(mapList);
            } catch (JsonProcessingException e) {
                log.error("exception catched in maplist converting to json string! {}",e.toString());
            }
        }else{
            log.error("invalid maplist!");
        }
        return ret;
    }

    public static String beanlist2JsonString(List beanList){
        String ret = null;
        if(beanList!=null){
            try {
                ret = mapper.writeValueAsString(beanList);
            } catch (JsonProcessingException e) {
                log.error("exception catched in beanlist converting to json string! {}",e.toString());
            }
        }else{
            log.error("invalid beanlist!");
        }

        return ret;
    }

    public static String object2JsonString(Object obj){
        String ret = null;

        try {
                ret = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
                log.error("exception catched in beanlist converting to json string! {}",e.toString());
        }

        return ret;
    }
}
