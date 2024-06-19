package com.example.pavel2.Quest;

import com.example.pavel2.Quest.Character;
import com.example.pavel2.Quest.Situation;

public class Story {
    private Situation start;
    private Situation current;
    private Character character;

    public Story(Character character) {
        this.character = character;
        this.current = this.start = new Situation(
                "Первая сделка",
                "Только вы начали работать и тут же удача! Вы нашли клиента и продаете ему партию \n ПО МС Виндовс. Ему в принципе достаточно взять 100 коробок версии HOME.\n" +
                        "1 - у клиента денег много, а у меня нет - вы выпишете ему счет на 120 коробок \\n ULTIMATE по 50тр\"); \n" +
                        "2 - чуть дороже сделаем, кто там заметит - вы выпишете ему счет на 100 коробок \\n PRO по 10тр\"); \n" +
                        "3 - как надо так и сделаем - вы выпишете ему счет на 100 коробок HOME по 5тр",

                0, 0, 0, 3
        );
        this.start.getDirections()[0] = new Situation("я продал все за 120", "клиент очень зол, меня уволили", -1, -50, 120000, 0);
        this.start.getDirections()[1] = new Situation("я продал все за 100", "сделка прошла успешно", 1, 0, 100000, 0);
        this.start.getDirections()[2] = new Situation("я продал все за 50", "клиент очень доволен, всем рекомендует", 0, 10, 50000, 0);
    }

    public void go(int answer) {
        if (answer <= current.getDirections().length && answer > 0) {
            current = current.getDirections()[answer - 1];
            this.character.setA(this.character.getA() + current.getdA());
            this.character.setR(this.character.getR() + current.getdR());
            this.character.setK(this.character.getK() + current.getdK());
        } else {
            System.out.println("Введи правильный ответ");
        }
    }

    public boolean isEnd() {
        return current.getDirections().length == 0;
    }

    public Situation getStart() {
        return start;
    }

    public void setStart(Situation start) {
        this.start = start;
    }

    public Situation getCurrent() {
        return current;
    }

    public void setCurrent(Situation current) {
        this.current = current;
    }
}
