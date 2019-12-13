package com.design.behavior;

public class Strategy {
    public static void main(String[] args) {
        Content content0 = new Content(new BikeStrategy());
        content0.toSchool();

        Content content1 = new Content(new BusStrategy());
        content1.toSchool();
    }
}


class Content {

    IStrategy iStrategy;

    /**
     * 聚合具体的策略
     *
     * @param iStrategy 策略接口
     *
     */

    Content(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void toSchool() {
        iStrategy.toSchool();
    }
}


/**
 *策略接口
 */
interface IStrategy {
    /**
     * 上学
     */
    void toSchool();
}



class BusStrategy implements IStrategy {
    public void toSchool() {
        System.out.println("坐公交车");
    }
}

class BikeStrategy implements IStrategy {
    public void toSchool() {
        System.out.println("骑自行车");
    }
}
