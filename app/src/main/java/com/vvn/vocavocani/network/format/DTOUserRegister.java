package com.vvn.vocavocani.network.format;

/**
 * Created by soo13 on 2017-10-23.
 */

public class DTOUserRegister {
    int user_idx;
    String user_id;
    String user_nickname;
    String user_img;
    String user_created_at;

    @Override
    public String toString() {
        return "[" + user_idx + "]" + user_id + "/"+user_nickname+" ("+user_img+") "+user_created_at;
    }
}




