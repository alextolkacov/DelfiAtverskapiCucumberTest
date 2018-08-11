package homeworkAtverskapiDelfi;

import homeworkAtverskapiDelfi.Pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class HomeworkAtverskapiDelfi {
    BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "http://atverskapi.delfi.lv/lv/style";
    private final Logger LOGGER = LogManager.getLogger(HomeworkAtverskapiDelfi.class);

    @Test
    public void checkBlackShoes() {
        baseFunc.openPage(HOME_PAGE);
        LOGGER.info("Opening home page");

        HomePage homePage = new HomePage(baseFunc);
        DropdownToggle dropdownToggle = homePage.clickDropdownToggle();

        dropdownToggle.clickToApavi();
        LOGGER.info("Clicked to APAVI");

        MenShoes menShoes = new MenShoes(baseFunc);
        menShoes.clickToShoes();
        menShoes.clickToBlack();
        menShoes.clickToJauns();
        LOGGER.info("Selected new black shoes");

        menShoes.clickSubmit("Filtrēt");
        LOGGER.info("Clicked SUBMIT BTN");

        for (int id = 0; id < 5; id++) {
            ArticlePage articlePage = menShoes.openArticlePage(id);
            articlePage.compareNewAndBlack();
            LOGGER.info("Back after assert" + id);
        }
    }
}
