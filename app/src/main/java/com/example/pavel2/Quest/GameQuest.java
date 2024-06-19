package com.example.pavel2.Quest;

import java.util.Scanner;

public class GameQuest {
    private Character character;
    private Story story;

    public GameQuest(String name) {
        this.character = new Character();
        character.setName(name);
        this.story = new Story(character);
    }
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public void start() {
        while (true)            {
            System.out.println(this.character);
            System.out.println(this.story.getCurrent().getDescription());
            if (this.story.isEnd()) {
                break;

            }
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            this.story.go(answer);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your name");
        GameQuest game = new GameQuest(scanner.nextLine());
        game.start();
    }
}
