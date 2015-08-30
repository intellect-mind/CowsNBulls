package com.intellectminds.cowsnbulls;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by enaamon on 2015-08-29.
 */
public class GameDictionary {

    public Dictionary<Integer,String> addWords() {

        Dictionary<Integer,String> dict = new Hashtable<Integer,String>();

        dict.put(1, "help");
        dict.put(2, "corn");
        dict.put(3, "bare");
        dict.put(4, "game");
        dict.put(5, "fate");
        dict.put(6, "fake");
        dict.put(7, "acne");
        dict.put(8, "horn");
        dict.put(9, "hero");
        dict.put(10, "mine");
        dict.put(0, "cape");
        return dict;

    }
}
