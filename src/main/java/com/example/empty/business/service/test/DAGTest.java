package com.example.empty.business.service.test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/***
 * Java解析 有关无向图
 *
 * 1.1
 *      > 2.1
 * 1.2
 *
 *                 >   3.1
 *
 * 1.3 -  2.2
 *                                             5.1
 *                                  > 4.1   <        > 6.1
 *                                             5.2
 * 1.4 -  2.3
 *
 *
 *
 */
public class DAGTest {
    public static void main(String[] args) {

        List<DAGNode> nodeList = new ArrayList<>();
        nodeList.add(new DAGNode("1.1",5));
        nodeList.add(new DAGNode("1.2",5));
        nodeList.add(new DAGNode("1.3",3));
        nodeList.add(new DAGNode("1.4",2));
        nodeList.add(new DAGNode("2.1",5));
        nodeList.add(new DAGNode("2.2",3));
        nodeList.add(new DAGNode("2.3",2));
        nodeList.add(new DAGNode("3.1",5));
        nodeList.add(new DAGNode("4.1",5));
        nodeList.add(new DAGNode("5.1",5));
        nodeList.add(new DAGNode("5.2",6));
        nodeList.add(new DAGNode("6.1",1));

        List<DAGEdge> edgeList = new ArrayList<>();
        edgeList.add(new DAGEdge("1.1","2.1"));
        edgeList.add(new DAGEdge("1.2","2.1"));
        edgeList.add(new DAGEdge("1.3","2.2"));
        edgeList.add(new DAGEdge("1.4","2.3"));
        edgeList.add(new DAGEdge("2.1","3.1"));
        edgeList.add(new DAGEdge("2.2","3.1"));
        edgeList.add(new DAGEdge("3.1","4.1"));
        edgeList.add(new DAGEdge("2.3","4.1"));
        edgeList.add(new DAGEdge("4.1","5.1"));
        edgeList.add(new DAGEdge("4.1","5.2"));
        edgeList.add(new DAGEdge("5.1","6.1"));
        edgeList.add(new DAGEdge("5.2","6.1"));

        Map<String ,DAGNode> nodeMap = new HashMap<>();
        for (DAGNode node : nodeList) {
            nodeMap.put(node.getName(),node);
        }
        Map<String ,List<DAGEdge>> endMap = new HashMap<>();
        for (DAGEdge edge : edgeList) {
            String end = edge.getEnd();
            if(!endMap.containsKey(end)){
                endMap.put(end,new ArrayList<>());
            }
            endMap.get(end).add(edge);
        }
        Map<String ,List<DAGEdge>> startMap = new HashMap<>();
        for (DAGEdge edge : edgeList) {
            String start = edge.getStart();
            if(!startMap.containsKey(start)){
                startMap.put(start,new ArrayList<>());
            }
            startMap.get(start).add(edge);
        }
        for (DAGNode node : nodeList) {
            String name = node.getName();
            if(endMap.containsKey(name)){
                node.setStartCondition(new CountDownLatch(endMap.get(name).size()));
            }
        }
        for (DAGNode node : nodeList) {
            String name = node.getName();
            if(startMap.containsKey(name)){
                for (DAGEdge dagEdge : startMap.get(name)) {
                    node.addEndCondition(nodeMap.get(dagEdge.getEnd()).startCondition);
                }
            }
        }
        List<Thread> threads = new ArrayList<>();
        for (DAGNode node : nodeList) {
            threads.add(new Thread(node));
        }
        for (Thread thread : threads) {
            thread.start();
        }

    }
    //连线
    static class DAGEdge{
        private String start;
        private String end;

        public DAGEdge(String start, String end) {
            this.start = start;
            this.end = end;
        }

        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }
    }
    //节点
    static class DAGNode implements Runnable{
        private String name;
        private int sleep;
        private CountDownLatch startCondition;
        private List<CountDownLatch> endConditions = new ArrayList<>();

        public DAGNode(String name,int sleep) {
            this.name = name;
            this.sleep = sleep;
        }

        @Override
        public void run() {
            try {
                if(startCondition != null){
//                    System.out.println(MessageFormat.format("节点[{0}]等待运行",name));
                    startCondition.await();
                }
                System.out.println(MessageFormat.format("节点[{0}]开始运行",name));
                //TODO
                TimeUnit.SECONDS.sleep(sleep);
                System.out.println(MessageFormat.format("节点[{0}]运行结束",name));
            }catch (InterruptedException e){
                System.out.println(MessageFormat.format("节点[{0}]被中断",name));
            } finally {
                if(endConditions != null && !endConditions.isEmpty() ){
                    for (CountDownLatch endCondition : endConditions) {
                        endCondition.countDown();
                    }
                }
            }
        }

        public void setStartCondition(CountDownLatch startCondition) {
            this.startCondition = startCondition;
        }

        public void addEndCondition(CountDownLatch endCondition) {
            this.endConditions.add(endCondition);
        }

        public String getName() {
            return name;
        }
    }
}
