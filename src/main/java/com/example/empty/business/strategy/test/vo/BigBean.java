package com.example.empty.business.strategy.test.vo;

import lombok.Data;

/**
 * @author created by guanchen on 2020/1/3 15:12
 */
@Data
public class BigBean {
    private String name;
    private Project project;
    @Data
    public static class Project {
        private DiscoverCenter discoverCenter;
    }

    @Data
    public static class DiscoverCenter {
        private String discoverName;
    }

    public static BigBean build(String name,String discoverName){
        DiscoverCenter discoverCenter = new DiscoverCenter();
        discoverCenter.setDiscoverName(discoverName);

        Project project = new Project();
        project.setDiscoverCenter(discoverCenter);

        BigBean bean = new BigBean();
        bean.setProject(project);
        bean.setName(name);

        return bean;
    }

    public static BigBean buildEmpty(String name,String discoverName){

        BigBean bean = new BigBean();
        bean.setName(name);

        return bean;
    }
}
