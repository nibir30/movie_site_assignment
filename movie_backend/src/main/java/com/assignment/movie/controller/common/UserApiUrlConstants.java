package com.assignment.movie.controller.common;

public class UserApiUrlConstants {
    public final static String API_URI_PREFIX = "/api/v1";

    // USER
    public final static String USER = API_URI_PREFIX + "/user";
    public final static String REGISTER = USER + "/register";

    // movies
    public final static String MOVIES = API_URI_PREFIX + "/movies";
    public final static String BYCATEGORY = MOVIES + "/by-category";

}
