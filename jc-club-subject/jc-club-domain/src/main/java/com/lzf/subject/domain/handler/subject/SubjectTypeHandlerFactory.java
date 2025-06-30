package com.lzf.subject.domain.handler.subject;

import com.lzf.subject.common.enums.SubjectInfoTypeEnum;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.naming.spi.InitialContextFactoryBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目类型工厂
 * @author luozhifeng
 * @version 1.0
 * @date 2025/6/30
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {
    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerList;

    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();//这个初始化有很多种方式
    //直接注入也是可以的

    public SubjectTypeHandler getHandler(int subjectType){
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getByCode(subjectType);
        return handlerMap.get(subjectInfoTypeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for(SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerList){
            handlerMap.put(subjectTypeHandler.getHandlerType(), subjectTypeHandler);
        }
    }
}
