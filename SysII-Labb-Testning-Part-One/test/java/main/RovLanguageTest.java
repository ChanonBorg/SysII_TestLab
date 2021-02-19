package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

/**
 * @author Chanon Borgström and Sofia Hallberg
 * @created 05/02/2021
 * @project SysII-Labb-Testning
 */
public class RovLanguageTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Testing null")
    void enRovNull() {
        Assert.assertNull(RovLanguage.enRovLang(null));
           }

    @Test
    @DisplayName("Testing small letters")
    void enRovSmall() {
        Assert.assertEquals("abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovwowxoxyzozåäö", RovLanguage.enRovLang("abcdefghijklmnopqrstuvwxyzåäö"));
    }

    @Test
    @DisplayName("Testing big letters")
    void enRovBig() {
        Assert.assertEquals("ABOBCOCDODEFOFGOGHOHIJOJKOKLOLMOMNONOPOPQOQRORSOSTOTUVOVWOWXOXYZOZÅÄÖ", RovLanguage.enRovLang("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"));
    }

    @Test
    @DisplayName("Testing signs")
    void enRovSigns() {
        Assert.assertEquals("!#€%&/()=?@0123456789",RovLanguage.enRovLang("!#€%&/()=?@0123456789"));
    }

    @Test
    @DisplayName("Testing empty string")
    void enRovEmptyString() {
        Assert.assertEquals("",RovLanguage.enRovLang(""));
    }

    @Test
    @DisplayName("Testing null")
    void deRovNull() {
        Assert.assertNull(RovLanguage.deRovLang(null));
    }

    @Test
    @DisplayName("Testing small letters")
    void deRovSmall() {
        Assert.assertEquals(RovLanguage.deRovLang("abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovwowxoxyzozåäö"),"abcdefghijklmnopqrstuvwxyzåäö");
    }

    @Test
    @DisplayName("Testing big")
    void deRovBig() {
        Assert.assertEquals(RovLanguage.deRovLang("ABOBCOCDODEFOFGOGHOHIJOJKOKLOLMOMNONOPOPQOQRORSOSTOTUVOVWOWXOXYZOZÅÄÖ"),"ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ");
    }

    @Test
    @DisplayName("Testing signs")
    void deRovSigns() {
        Assert.assertEquals(RovLanguage.enRovLang("!#€%&/()=?@0123456789"),"!#€%&/()=?@0123456789");
    }

    @Test
    @DisplayName("Testing empty string")
    void deRov() {
        Assert.assertEquals("",RovLanguage.enRovLang(""));
    }
}