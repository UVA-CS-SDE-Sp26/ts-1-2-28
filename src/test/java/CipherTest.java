import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

class CipherTest {

    @Test
    void testDecrypt_DefaultKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String result = Cipher.decrypt(data);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_lowercaseKeyOnly() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "abcdefghijklmnopqrstuvwxyz/nbcdefghijklmnopqrstuvwxyza";
        String result = Cipher.decrypt(data, key);
        assertEquals("Pbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nYOUR MOTHER WAS A HAMSTER AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309", result);
    }
    @Test
    void testDecrypt_uppercaseKeyOnly() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ/nBCDEFGHIJKLMNOPQRSTUVWXYZA";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qay no attention to the man behind the curtain./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n8675309", result);
    }
    @Test
    void testDecrypt_numbersKeyOnly() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "1234567890/n2345678901";
        String result = Cipher.decrypt(data, key);
        assertEquals("Pay no attention to the man behind the curtain./nYOUR MOTHER WAS " +
                "A HAMSTER AND YOUR FATHER SMELT OF ELDERBERRIES!/n9786410", result);
    }
    @Test
    void testDecrypt_upper_lowerKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz/nBCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzA";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n8675309", result);
    }
    @Test
    void testDecrypt_lower_upperKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/nbcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZa";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n8675309", result);
    }
    @Test
    void testDecrypt_numbers_lowerKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "1234567890abcdefghijklmnopqrstuvwxyz/n234567890abcdefghijklmnopqrstuvwxyz1";
        String result = Cipher.decrypt(data, key);
        assertEquals("Pbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nYOUR MOTHER WAS " +
                "A HAMSTER AND YOUR FATHER SMELT OF ELDERBERRIES!/n97864a0", result);
    }
    @Test
    void testDecrypt_numbers_upperKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ/n234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ1";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qay no attention to the man behind the curtain./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864A0", result);
    }
    @Test
    void testDecrypt_lower_numbersKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "abcdefghijklmnopqrstuvwxyz1234567890/nbcdefghijklmnopqrstuvwxyz1234567890a";
        String result = Cipher.decrypt(data, key);
        assertEquals("Pbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nYOUR MOTHER WAS " +
                "A HAMSTER AND YOUR FATHER SMELT OF ELDERBERRIES!/n97864a0", result);
    }
    @Test
    void testDecrypt_upper_numbersKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890/nBCDEFGHIJKLMNOPQRSTUVWXYZ1234567890A";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qay no attention to the man behind the curtain./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864A0", result);
    }
    @Test
    void testDecrypt_upper_numbers_lowerKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz/nBCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyzA";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_upper_lower_numbersKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890/nBCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890A";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864A0", result);
    }
    @Test
    void testDecrypt_lower_numbers_upperKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ/nbcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZa";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864A0", result);
    }
    @Test
    void testDecrypt_lower_upper_numbersKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890/nbcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890a";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_numbers_lower_upperKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/n234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_numbers_upper_lowerKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz/n234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864A0", result);
    }
    @Test
    void testDecrypt_keyWithoutNewline() {//should use default key
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "1234567890";
        String result = Cipher.decrypt(data, key);
        assertEquals("Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A " +
                "HAMSTER AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309", result);
    }
    @Test
    void testDecrypt_complicatedKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "1234567890/n6789012345";
        String result = Cipher.decrypt(data, key);
        assertEquals("Pay no attention to the man behind the curtain./nYOUR MOTHER WAS " +
                "A HAMSTER AND YOUR FATHER SMELT OF ELDERBERRIES!/n3120854", result);
    }
    @Test
    void testDecrypt_charactersNotInKey() {
        String data = "/n !@#/n$ %^/n";
        String key = "1234567890/n2345678901";
        String result = Cipher.decrypt(data, key);
        assertEquals("/n !@#/n$ %^/n", result);
    }
    /*Boilerplate test
    @Test
    void testDecrypt() {
        String data = "";
        String key = "";
        String result = Cipher.decrypt(data, key);
        assertEquals(, result);
     */

}