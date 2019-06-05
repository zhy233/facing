package com.zhy.facing.aop;

import com.zhy.facing.common.util.JsonUtils;
import com.zhy.facing.dto.OutputDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Component
@Aspect
public class OperationLogs {
    private static Logger logger = LoggerFactory.getLogger(OperationLogs.class);

    @Value("${publicconfig.openlog}")
    private int isOpen;

    @Pointcut("execution(public * com.*.*.controller..*(..))")
    public void pointcut1(){}

    @Before(value = "pointcut1()")
    public void beforMethod(JoinPoint point) throws Exception {

        LogRemark methodRemark = getMethodRemark(point);
        if(methodRemark !=null && isOpen == 1){
            String opType = methodRemark.printType();
            if("pref".equals(opType) || "all".equals(opType)){
                HttpServletRequest request = getRequest(point);
                String params = getParam(request);
                logger.info("================请求路径:"+request.getRequestURI());
                logger.info("================请求参数:"+params);
            }
        }
    }


    @AfterReturning(returning = "result",pointcut = "pointcut1()")
    public void doAfterReturning(JoinPoint point, Object result) throws Throwable {
        LogRemark methodRemark = getMethodRemark(point);
        if(methodRemark !=null && isOpen == 1){
            String opType = methodRemark.printType();
            if("pref".equals(opType) || "all".equals(opType)){
                HttpServletRequest request = getRequest(point);
                //判断当前操作是否成功
                OutputDto outputDto=(OutputDto) result;
                if(outputDto.getStatus() == 1){
                    logger.info("================响应请求:"+request.getRequestURI());
                    logger.info("================响应参数:"+JsonUtils.object2JsonString(outputDto));
                }else{
                    logger.info("================响应请求:"+request.getRequestURI());
                    logger.info("================这里有一个bug!:"+JsonUtils.object2JsonString(outputDto));
                }

            }
        }
    }



    private LogRemark getMethodRemark(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        Class targetClass = Class.forName(targetName);
        Method[] method = targetClass.getMethods();
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    LogRemark methodCache = m.getAnnotation(LogRemark.class);
                    if (methodCache != null && !("").equals(methodCache.printType())) {
                        return methodCache;
                    }
                    break;
                }
            }
        }
        return null;
    }

    private HttpServletRequest getRequest(JoinPoint point) {
        Object[] args = point.getArgs();
        for (Object obj : args) {
            if (obj instanceof HttpServletRequest)
                return (HttpServletRequest) obj;
        }
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }

    private String getRequestIP(HttpServletRequest request) {
        String ip = null;
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        }else{
            ip = request.getHeader("x-forwarded-for");
        }
        return ip;
    }

    private String getParam(HttpServletRequest request) {
        Map properties = request.getParameterMap();
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            value = null;
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    if (value == null)
                        value = (values[i] == null ? "" : values[i]);
                    else
                        value += "," + (values[i] == null ? "" : values[i]);
                }
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return JsonUtils.map2JsonString(returnMap);
    }

//    private String getCurrentUser(){
//        return SecurityContextHolder.getContext().getAuthentication().getName();
//    }
}
