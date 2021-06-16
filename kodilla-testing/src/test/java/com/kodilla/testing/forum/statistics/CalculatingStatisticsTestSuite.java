package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatingStatisticsTestSuite {
    @Mock
    private Statistics statisticsMock;
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    class TestsForPostsWithMock {
        @Test
        void testWhen0Post() {
            //Given
            List<String> usersNames = new ArrayList<>();
            usersNames.add("Josefa");
            usersNames.add("Timothy");
            usersNames.add("Michelle");
            usersNames.add("Kevin");
            usersNames.add("Claire");
            when(statisticsMock.usersNames()).thenReturn(usersNames);
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(0);
            CalculatingStatistics calculatingStatistics = new CalculatingStatistics(statisticsMock);

            //When
            calculatingStatistics.calculateAdvStatistics(statisticsMock);
            double numberOfUsers = calculatingStatistics.getNumberOfUsers();
            double numberOfPosts = calculatingStatistics.getNumberOfPosts();
            double numberOfComments = calculatingStatistics.getNumberOfComments();
            double averageNumberOfPostsPerUser = calculatingStatistics.getAverageNumberOfPostsPerUser();
            double averageNumberOfCommentsPerUser = calculatingStatistics.getAverageNumberOfCommentsPerUser();
            double averageNumberOfCommentsPerPost = calculatingStatistics.getAverageNumberOfCommentsPerPost();

            //Then
            assertEquals(5, numberOfUsers);
            assertEquals(0, numberOfPosts);
            assertEquals(0, numberOfComments);
            assertEquals(0, averageNumberOfPostsPerUser,0.1);
            assertEquals(0, averageNumberOfCommentsPerUser,0.1);
            assertEquals(0, averageNumberOfCommentsPerPost, 0.1);
        }

        @Test
        void testWhen1000Post() {
            //Given
            List<String> usersNames = new ArrayList<>();
            usersNames.add("Josefa");
            usersNames.add("Timothy");
            usersNames.add("Michelle");
            usersNames.add("Kevin");
            usersNames.add("Claire");
            when(statisticsMock.usersNames()).thenReturn(usersNames);
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(2340);
            CalculatingStatistics calculatingStatistics = new CalculatingStatistics(statisticsMock);

            //When
            calculatingStatistics.calculateAdvStatistics(statisticsMock);
            double numberOfUsers = calculatingStatistics.getNumberOfUsers();
            double numberOfPosts = calculatingStatistics.getNumberOfPosts();
            double numberOfComments = calculatingStatistics.getNumberOfComments();
            double averageNumberOfPostsPerUser = calculatingStatistics.getAverageNumberOfPostsPerUser();
            double averageNumberOfCommentsPerUser = calculatingStatistics.getAverageNumberOfCommentsPerUser();
            double averageNumberOfCommentsPerPost = calculatingStatistics.getAverageNumberOfCommentsPerPost();

            //Then
            assertEquals(5, numberOfUsers);
            assertEquals(1000, numberOfPosts);
            assertEquals(2340, numberOfComments);
            assertEquals(200, averageNumberOfPostsPerUser,0.1);
            assertEquals(468, averageNumberOfCommentsPerUser,0.1);
            assertEquals(2.34, averageNumberOfCommentsPerPost, 0.1);
        }
    }

    @Nested
    class TestsForCommentsWithMock {
        @Test
        void testWhen0Comments() {
            //Given
            List<String> usersNames = new ArrayList<>();
            usersNames.add("Josefa");
            usersNames.add("Timothy");
            usersNames.add("Michelle");
            usersNames.add("Kevin");
            usersNames.add("Claire");
            when(statisticsMock.usersNames()).thenReturn(usersNames);
            when(statisticsMock.postsCount()).thenReturn(550);
            when(statisticsMock.commentsCount()).thenReturn(0);
            CalculatingStatistics calculatingStatistics = new CalculatingStatistics(statisticsMock);

            //When
            calculatingStatistics.calculateAdvStatistics(statisticsMock);
            double numberOfUsers = calculatingStatistics.getNumberOfUsers();
            double numberOfPosts = calculatingStatistics.getNumberOfPosts();
            double numberOfComments = calculatingStatistics.getNumberOfComments();
            double averageNumberOfPostsPerUser = calculatingStatistics.getAverageNumberOfPostsPerUser();
            double averageNumberOfCommentsPerUser = calculatingStatistics.getAverageNumberOfCommentsPerUser();
            double averageNumberOfCommentsPerPost = calculatingStatistics.getAverageNumberOfCommentsPerPost();

            //Then
            assertEquals(5, numberOfUsers);
            assertEquals(550, numberOfPosts);
            assertEquals(0, numberOfComments);
            assertEquals(110, averageNumberOfPostsPerUser, 0.1);
            assertEquals(0, averageNumberOfCommentsPerUser, 0.1);
            assertEquals(0, averageNumberOfCommentsPerPost, 0.1);
        }

        @Test
        void testWhenMorePostsThanComments() {
            //Given
            List<String> usersNames = new ArrayList<>();
            usersNames.add("Josefa");
            usersNames.add("Timothy");
            usersNames.add("Michelle");
            usersNames.add("Kevin");
            usersNames.add("Claire");
            when(statisticsMock.usersNames()).thenReturn(usersNames);
            when(statisticsMock.postsCount()).thenReturn(341);
            when(statisticsMock.commentsCount()).thenReturn(340);
            CalculatingStatistics calculatingStatistics = new CalculatingStatistics(statisticsMock);

            //When
            calculatingStatistics.calculateAdvStatistics(statisticsMock);
            double numberOfUsers = calculatingStatistics.getNumberOfUsers();
            double numberOfPosts = calculatingStatistics.getNumberOfPosts();
            double numberOfComments = calculatingStatistics.getNumberOfComments();
            double averageNumberOfPostsPerUser = calculatingStatistics.getAverageNumberOfPostsPerUser();
            double averageNumberOfCommentsPerUser = calculatingStatistics.getAverageNumberOfCommentsPerUser();
            double averageNumberOfCommentsPerPost = calculatingStatistics.getAverageNumberOfCommentsPerPost();

            //Then
            assertEquals(5, numberOfUsers);
            assertEquals(341, numberOfPosts);
            assertEquals(340, numberOfComments);
            assertEquals(68.2, averageNumberOfPostsPerUser, 0.1);
            assertEquals(68, averageNumberOfCommentsPerUser, 0.1);
            assertEquals(0.99, averageNumberOfCommentsPerPost, 0.1);
        }

        @Test
        void testWhenMoreCommentsThanPosts() {
            //Given
            List<String> usersNames = new ArrayList<>();
            usersNames.add("Josefa");
            usersNames.add("Timothy");
            usersNames.add("Michelle");
            usersNames.add("Kevin");
            usersNames.add("Claire");
            when(statisticsMock.usersNames()).thenReturn(usersNames);
            when(statisticsMock.postsCount()).thenReturn(120);
            when(statisticsMock.commentsCount()).thenReturn(500);
            CalculatingStatistics calculatingStatistics = new CalculatingStatistics(statisticsMock);

            //When
            calculatingStatistics.calculateAdvStatistics(statisticsMock);
            double numberOfUsers = calculatingStatistics.getNumberOfUsers();
            double numberOfPosts = calculatingStatistics.getNumberOfPosts();
            double numberOfComments = calculatingStatistics.getNumberOfComments();
            double averageNumberOfPostsPerUser = calculatingStatistics.getAverageNumberOfPostsPerUser();
            double averageNumberOfCommentsPerUser = calculatingStatistics.getAverageNumberOfCommentsPerUser();
            double averageNumberOfCommentsPerPost = calculatingStatistics.getAverageNumberOfCommentsPerPost();

            //Then
            assertEquals(5, numberOfUsers);
            assertEquals(120, numberOfPosts);
            assertEquals(500, numberOfComments);
            assertEquals(24, averageNumberOfPostsPerUser, 0.1);
            assertEquals(100, averageNumberOfCommentsPerUser, 0.1);
            assertEquals(4.17, averageNumberOfCommentsPerPost, 0.1);
        }
    }

    @Nested
    class TestsForUsersWithMock {
        @Test
        void testWhen0Users() {
            //Given
            List<String> usersNames = new ArrayList<>();
            when(statisticsMock.usersNames()).thenReturn(usersNames);
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(0);
            CalculatingStatistics calculatingStatistics = new CalculatingStatistics(statisticsMock);

            //When
            calculatingStatistics.calculateAdvStatistics(statisticsMock);
            double numberOfUsers = calculatingStatistics.getNumberOfUsers();
            double numberOfPosts = calculatingStatistics.getNumberOfPosts();
            double numberOfComments = calculatingStatistics.getNumberOfComments();
            double averageNumberOfPostsPerUser = calculatingStatistics.getAverageNumberOfPostsPerUser();
            double averageNumberOfCommentsPerUser = calculatingStatistics.getAverageNumberOfCommentsPerUser();
            double averageNumberOfCommentsPerPost = calculatingStatistics.getAverageNumberOfCommentsPerPost();

            //Then
            assertEquals(0, numberOfUsers);
            assertEquals(0, numberOfPosts);
            assertEquals(0, numberOfComments);
            assertEquals(0, averageNumberOfPostsPerUser, 0.1);
            assertEquals(0, averageNumberOfCommentsPerUser, 0.1);
            assertEquals(0, averageNumberOfCommentsPerPost, 0.1);
        }

        @Test
        void testWhen100Users() {
            //Given
            List<String> usersNames = new ArrayList<>();
            for(int n = 0; n < 100; n++) {
                usersNames.add("user" + n );
            }
            when(statisticsMock.usersNames()).thenReturn(usersNames);
            when(statisticsMock.postsCount()).thenReturn(290);
            when(statisticsMock.commentsCount()).thenReturn(560);
            CalculatingStatistics calculatingStatistics = new CalculatingStatistics(statisticsMock);

            //When
            calculatingStatistics.calculateAdvStatistics(statisticsMock);
            double numberOfUsers = calculatingStatistics.getNumberOfUsers();
            double numberOfPosts = calculatingStatistics.getNumberOfPosts();
            double numberOfComments = calculatingStatistics.getNumberOfComments();
            double averageNumberOfPostsPerUser = calculatingStatistics.getAverageNumberOfPostsPerUser();
            double averageNumberOfCommentsPerUser = calculatingStatistics.getAverageNumberOfCommentsPerUser();
            double averageNumberOfCommentsPerPost = calculatingStatistics.getAverageNumberOfCommentsPerPost();

            //Then
            assertEquals(100, numberOfUsers);
            assertEquals(290, numberOfPosts);
            assertEquals(560, numberOfComments);
            assertEquals(2.9, averageNumberOfPostsPerUser, 0.1);
            assertEquals(5.6, averageNumberOfCommentsPerUser, 0.1);
            assertEquals(1.93, averageNumberOfCommentsPerPost, 0.1);
        }
    }

}