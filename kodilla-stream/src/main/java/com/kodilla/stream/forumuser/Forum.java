package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum() {
        theForumUserList.add(new ForumUser(23, "Karol", 'M', 2001, 10, 5, 2));
        theForumUserList.add(new ForumUser(24, "Karolina", 'F', 1999, 6, 6, 5));
        theForumUserList.add(new ForumUser(25, "Julian", 'M', 1987, 7, 2, 7));
        theForumUserList.add(new ForumUser(26, "Julia", 'F', 1985, 2, 14, 0));
        theForumUserList.add(new ForumUser(27, "Wojciech", 'M', 2002, 12, 12, 9));
        theForumUserList.add(new ForumUser(28, "Greta", 'F', 2001, 3, 12, 29));
        theForumUserList.add(new ForumUser(29, "Adam", 'M', 2000, 4, 15, 0));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theForumUserList);
    }
}
