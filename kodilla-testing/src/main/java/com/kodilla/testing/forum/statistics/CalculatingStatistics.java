package com.kodilla.testing.forum.statistics;

public class CalculatingStatistics {
    private Statistics statistics;
    private double numberOfUsers;
    private double numberOfPosts;
    private double numberOfComments;
    private double averageNumberOfPostsPerUser;
    private double averageNumberOfCommentsPerUser;
    private double averageNumberOfCommentsPerPost;

    public CalculatingStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
        if(numberOfUsers == 0) {
            averageNumberOfPostsPerUser = 0;
            averageNumberOfCommentsPerUser = 0;
        } else {
            averageNumberOfPostsPerUser = numberOfPosts / numberOfUsers;
            averageNumberOfCommentsPerUser = numberOfComments / numberOfUsers;
        }
        if(numberOfComments == 0) {
            averageNumberOfCommentsPerPost = 0;
        } else {
            averageNumberOfCommentsPerPost = numberOfComments / numberOfPosts;
        }
    }

    public double getNumberOfUsers() {
        return numberOfUsers;
    }

    public double getNumberOfPosts() {
        return numberOfPosts;
    }

    public double getNumberOfComments() {
        return numberOfComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }

    public void showStatistics() {
        System.out.println("Out statistics{" +
                "number of users=" + numberOfUsers +
                ", number of posts=" + numberOfPosts +
                ", number of comments=" + numberOfComments +
                ", average number of posts per user=" + averageNumberOfPostsPerUser +
                ", average number of comments per user=" + averageNumberOfCommentsPerUser +
                ", average number of comments per post=" + averageNumberOfCommentsPerPost +
                '}');
    }
}
