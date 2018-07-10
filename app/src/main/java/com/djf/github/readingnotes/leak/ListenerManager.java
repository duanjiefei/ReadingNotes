package com.djf.github.readingnotes.leak;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sky000 on 2018/6/28.
 */

public class ListenerManager {
    private List<SampleListener> listeners = new ArrayList<>();
    private static ListenerManager mListenerManager;
    public ListenerManager() {
    }

    public static ListenerManager getInstance(){
        if (mListenerManager == null){
            mListenerManager = new ListenerManager();
        }
        return mListenerManager;
    }

    public void addListener(SampleListener sampleListener){
        listeners.add(sampleListener);
    }
    public void removeListener(SampleListener sampleListener){
        listeners.remove(sampleListener);
    }
}
