package spring.bean.injection;

import org.springframework.beans.factory.annotation.Autowired;

public class Ship {

    private Helm helm;

    public Ship() {
        helm = new Helm();
    }

    @Autowired
    public Ship(Helm helm) {
        this.helm = helm;
    }


    public void setHelm(Helm helm) {
        this.helm = helm;
    }

    public Helm getHelm() {
        return this.helm;
    }
}
