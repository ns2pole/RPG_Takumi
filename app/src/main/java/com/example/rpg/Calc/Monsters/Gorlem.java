package com.example.rpg.Calc.Monsters;

import com.example.rpg.Calc.skill.Hit;
import com.example.rpg.Calc.skill.Throw;

import java.io.Serializable;

public class Gorlem extends Monster2  implements Serializable {
    public Gorlem(){
        this.limit_hp=9000;
        this.limit_mp=300000;
        this.defence=0;
        this.up_leberu=0;
        this.leberu = 1;
        this.hp=9000;
        this.attack=70000;
        this.mp=300000;
        this.judge_sente=10;
        this.name="ゴ－レム";
        this.seibetu="なし";
        this.is_alive=true;
        this.fellow=true;
        this.can_get_experince_point = 3000;
        this.need_experince_point = 300;
        this.all_skill.add(new Hit());
        this.all_skill.add(new Throw());
    }
    public static String look(Monster2 monster){
        return monster.name;
    }
}
