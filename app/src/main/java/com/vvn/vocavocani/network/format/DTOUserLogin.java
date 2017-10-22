package com.vvn.vocavocani.network.format;

/**
 * Created by soo13 on 2017-10-23.
 */

public class DTOUserLogin {
    public boolean status;
    public String message;
    public Result result;

    class Result {
        public Profile profile;
        public String token;
    }

    class Profile {
        public String id;
        public String username;
    }
}