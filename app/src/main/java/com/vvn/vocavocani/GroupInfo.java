package com.vvn.vocavocani;

/**
 * Created by soo13 on 2017-07-28.
 */

public class GroupInfo {
    private int groupImg;
    private String groupName;
    private boolean newGroup = true;

    public GroupInfo(int groupImg, String groupName) {
        this.groupImg = groupImg;
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean isNew() {
        return newGroup;
    }
}
