package com.simple.commonlibrary.event;

import java.io.Serializable;

/**
 *
 * Created by hych on 2017/4/18 16:02.
 */

public class BottomBarEvent {

    private boolean showBottomBar;

    public BottomBarEvent(boolean showBottomBar) {
        this.showBottomBar = showBottomBar;
    }

    public boolean isShowBottomBar() {
        return showBottomBar;
    }
}
