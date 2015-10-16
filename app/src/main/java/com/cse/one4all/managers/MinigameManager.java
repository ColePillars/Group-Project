package com.cse.one4all.managers;

import com.cse.one4all.base.BaseMinigame;
import com.cse.one4all.minigame.TestMinigame;
import com.cse.one4all.minigame.TestMinigame2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MinigameManager {

    private static final MinigameManager INSTANCE = new MinigameManager();

    private Random random = new Random();
    private List<BaseMinigame> minigames = new ArrayList<>();
    private BaseMinigame currentMinigame;

    public MinigameManager(){
        minigames.add(new TestMinigame());
        minigames.add(new TestMinigame2());
    }

    public void setRandomMinigame(){
        setMinigame(getRandomMinigame());
    }

    public void setMinigame(BaseMinigame minigame){
        minigame.createScene();
        currentMinigame = minigame;
        SceneManager.getInstance().setScene(minigame.getScene());
    }

    public BaseMinigame getRandomMinigame(){
        List<BaseMinigame> minigameScenes = new ArrayList<>(minigames);
        if(currentMinigame != null){
            //minigameScenes.remove(currentMinigame);
        }
        return minigameScenes.get(random.nextInt(minigameScenes.size()));
    }

    public void loadResources(){
        for (BaseMinigame m : minigames) {
            m.loadResources();
        }
    }

    public static MinigameManager getInstance(){
        return INSTANCE;
    }


}