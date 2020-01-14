package com.example.empty.business.strategy.test.function;

import com.example.empty.business.strategy.test.vo.BigBean;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author created by guanchen on 2020/1/3 15:11
 */
public class OptionalService {

    @Test
    public void testNestedMap(){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> project = new HashMap<>();
        project.put("Nacos","discover");

        Map<String,Object> alibaba = new HashMap<>();
        alibaba.put("project",project);

        Map<String,Object> org = new HashMap<>();
        org.put("alibaba",alibaba);

        map.put("org",org);
        Object o1 = Optional.ofNullable(map)
                .map(m -> m.get("org"))
                .map(o -> ((Map) o).get("alibaba"))
                .map(a -> ((Map) a).get("project"))
                .map(p -> ((Map) p).get("Nacos"))
                .orElse("default value");

        System.out.println(o1);
    }
    @Test
    public void isNull(){
        BigBean bean = BigBean.build("Alibaba", "Nacos");
        BigBean bean2 = BigBean.buildEmpty("Alibaba", "Nacos");

        String s = Optional.ofNullable(bean2)
                .map(o -> o.getProject())
                .map(p -> p.getDiscoverCenter())
                .map(d -> d.getDiscoverName())
                .orElse("default value");
        System.out.println(s);

        Optional.ofNullable(bean).ifPresent(u -> {
            System.out.println(u.getName());
        });
    }
}
