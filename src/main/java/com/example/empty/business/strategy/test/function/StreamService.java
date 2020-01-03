package com.example.empty.business.strategy.test.function;

import com.example.empty.business.strategy.test.vo.BigBean;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author created by guanchen on 2020/1/3 16:08
 */
@Service
public class StreamService {
    @Test
    public void mapDo(){
        List<BigBean> beanList = Arrays.asList(BigBean.build("a", "aa")
                , BigBean.build("b", "bb")
                , BigBean.build("c", "cc"));

        beanList.stream()
                .map(BigBean::getName)
                .forEach(System.out::println);

        System.out.println("------------------");

        String[] words = new String[]{"Hello","World"};
        List<String[]> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        a.forEach(System.out::println);

        System.out.println("------------------");

        List<String> b = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        b.forEach(System.out::println);
    }

    @Test
    public void list2Map(){
        List<BigBean> beanList = Arrays.asList(BigBean.build("a", "aa")
                , BigBean.build("a", "bb")
                , BigBean.build("c", "cc"));
        Map<String, BigBean.Project> map = beanList.stream().collect(Collectors.toMap(BigBean::getName, bean -> bean.getProject(),(k1, k2)->k1));

        map.forEach((k,v) -> {
            System.out.println(String.format("key = %s,value=%s",k,v.getDiscoverCenter().getDiscoverName()));
        });

        System.out.println("------------------");

        Map<String, String> a = new HashMap<String, String>() {{
            put("name", "a");
            put("code", "aa");
        }};

        Map<String, String> b = new HashMap<String, String>() {{
            put("name", "b");
            put("code", "bb");
        }};

        List<Map<String,String>> mapList = Arrays.asList(a,b);
        Map<String, String> map2 = mapList.stream().collect(Collectors.toMap(p -> p.get("name"), p -> p.get("code"),(k1, k2)->k1));

        map2.forEach((k,v) -> System.out.println(String.format("key = %s,value=%s",k,v)));

    }

    @Test
    public void threadDo(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        numbers.stream().forEach(i -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now().toString() + "=" + i);
        });

        System.out.println("------------------");
        numbers.stream().filter( i -> i > 3).forEach(a -> {
            System.out.println(a);
        });
        System.out.println("------------------");
        numbers.stream().sorted().forEach(a -> {
            System.out.println(a);
        });
    }
}
