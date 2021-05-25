package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {

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
    @DisplayName("Tests for posts")
    class TestPost {
        @Test // Test 1: sprawdzający, czy po dodaniu nowego postu liczba postów wynosi 1.
        void testAddPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");

            //When
            forumUser.addPost("mrsmith",
                    "Hello everyone, this is my first contribution here!");

            //Then
            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }

        @Test // Test 3: sprawdzający, czy post pobrany z klasy ForumUser jest taki sam, jak post, który był wstawiany do klasy.
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            //When
            ForumPost retrievedPost;
            retrievedPost = forumUser.getPost(0);

            //Then
            Assertions.assertEquals(thePost, retrievedPost);
        }

        @Test // Test 5: sprawdzający, czy próba usunięcia nieistniejącego posta skończy się zwróceniem wyniku false.
        void testRemovePostNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");

            //When
            boolean result = forumUser.removePost(thePost);

            //Then
            Assertions.assertFalse(result);
        }

        @Test // Test 7: weryfikujący, czy udało się usunąć wybrany post z klasy.
        void testRemovePost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            //When
            boolean result = forumUser.removePost(thePost);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for comment")
    class TestComment {
        @Test
            // Test 2: sprawdzający, czy po dodaniu nowego komentarza liczba komentarzy wynosi 1.
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");

            //When
            forumUser.addComment(thePost, "mrsmith", "Thank you for all good words!");

            //Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        @Test
            // Test 4: sprawdzający, czy komentarz pobrany z klasy ForumUser jest taki sam, jak komentarz, który był wstawiany do klasy.
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());

            //When
            ForumComment retrievedComment = forumUser.getComment(0);

            //Then
            Assertions.assertEquals(theComment, retrievedComment);
        }

        @Test
            // Test 6: sprawdzający, czy próba usunięcia nieistniejącego komentarza skończy się zwróceniem wyniku false.
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
            // Test 8: weryfikujący, czy udało się usunąć wybrany komentarz z klasy.
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}
