package homework6;

import org.junit.jupiter.api.*;
public class LJTest extends BaseTest {

    @Test
    void newPostTest(){
       mainPage.clickSignInButton()
                .login("TatianaSenichka", "Z/x.c,vmbn2022")
                .toWright()
                .newPost("Всем привет");
       Assertions.assertTrue(driver.getCurrentUrl().contains("tatianasenichka"));

    }

    @Test
    void editPostTest(){
        mainPage.clickSignInButton()
                .login("TatianaSenichka", "Z/x.c,vmbn2022")
                .navigationBlock.freshPosts()
                .openPost("6701")
                .editPost("Всем пока");
        Assertions.assertFalse(driver.getCurrentUrl().contains("draft"));
    }

    @Test
    void deletePostTest(){
        mainPage.clickSignInButton()
                .login("TatianaSenichka", "Z/x.c,vmbn2022")
                .navigationBlock.freshPosts()
                .openPost("8190")
                .deletePost();
        Assertions.assertFalse(driver.getCurrentUrl().contains("draft"));

    }

    @Test
    void statMyguestsTest(){
        mainPage.clickSignInButton()
                .login("TatianaSenichka", "Z/x.c,vmbn2022")
                .navigationBlock.hoverProfileMenuAndClickStat()
                .statTabs();
        Assertions.assertTrue(driver.getCurrentUrl().contains("guests"));
    }

    @Test
    void searchTest() throws InterruptedException {
        mainPage.searchFromMain("рецепты");
        String urlPress = "https://www.livejournal.com/rsearch?q=%D1%80%D0%B5%D1%86%D0%B5%D0%BF%D1%82%D1%8B&sort=_score&searchArea=post";
        Assertions.assertEquals(urlPress, driver.getCurrentUrl());

    }


}

