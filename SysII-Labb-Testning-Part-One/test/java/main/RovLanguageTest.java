package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

/**
 * @author Chanon Borgström
 * @created 05/02/2021
 * @project SysII-Labb-Testning
 */
public class RovLanguageTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void enRov() {
        Assert.assertNull(RovLanguage.enRovLang(null));
        Assert.assertEquals("abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovwowxoxyzozåäö", RovLanguage.enRovLang("abcdefghijklmnopqrstuvwxyzåäö"));
        Assert.assertEquals("ABOBCOCDODEFOFGOGHOHIJOJKOKLOLMOMNONOPOPQOQRORSOSTOTUVOVWOWXOXYZOZÅÄÖ", RovLanguage.enRovLang("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"));
        Assert.assertEquals("!#€%&/()=?@0123456789",RovLanguage.enRovLang("!#€%&/()=?@0123456789"));
        Assert.assertEquals("",RovLanguage.enRovLang(""));
    }

    //ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ
    //abcdefghijklmnopqrstuvwxyzåäö

    @Test
    void deRov() {
        Assert.assertNull(RovLanguage.deRovLang(null));
        Assert.assertEquals(RovLanguage.deRovLang("abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovwowxoxyzozåäö"),"abcdefghijklmnopqrstuvwxyzåäö");
        Assert.assertEquals(RovLanguage.deRovLang("ABOBCOCDODEFOFGOGHOHIJOJKOKLOLMOMNONOPOPQOQRORSOSTOTUVOVWOWXOXYZOZÅÄÖ"),"ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ");
        Assert.assertEquals(RovLanguage.enRovLang("!#€%&/()=?@0123456789"),"!#€%&/()=?@0123456789");
        Assert.assertEquals("",RovLanguage.enRovLang(""));

    }
}