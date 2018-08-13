package com.project.restsearcher.Model.User;

public class UserView {

    public static class Public { }
    public static class ExtendedPublic extends Public{ }
    public static class Internal extends ExtendedPublic { }
    public static class Secretly extends Public{ }
}
