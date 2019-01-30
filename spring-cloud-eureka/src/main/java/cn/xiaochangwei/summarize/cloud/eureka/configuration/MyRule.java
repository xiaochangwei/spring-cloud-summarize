package cn.xiaochangwei.summarize.cloud.eureka.configuration;

import com.netflix.loadbalancer.*;

public class MyRule implements IRule {
    public static void main(String[] args) {
        new RoundRobinRule();
        new WeightedResponseTimeRule();
    }


    @Override
    public Server choose(Object o) {
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {

    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return null;
    }
}
