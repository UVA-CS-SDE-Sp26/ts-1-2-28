import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
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
        String key = "abcdefghijklmnopqrsturvwxyz/nbcdefghijklmnopqrsturvwxyza";
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
                "A HAMSTER AND YOUR FATHER SMELT OF ELDERBERRIES!/n97864a0", result);
    }
    @Test
    void testDecrypt_upper_lowerKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrsturvwxyz/nBCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrsturvwxyzA";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n8675309", result);
    }
    @Test
    void testDecrypt_lower_upperKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "abcdefghijklmnopqrsturvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/nbcdefghijklmnopqrsturvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZa";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n8675309", result);
    }
    @Test
    void testDecrypt_numbers_lowerKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "1234567890abcdefghijklmnopqrsturvwxyz/n234567890abcdefghijklmnopqrsturvwxyz1";
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
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_lower_numbersKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "abcdefghijklmnopqrsturvwxyz1234567890/nbcdefghijklmnopqrsturvwxyz1234567890a";
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
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_upper_numbers_lowerKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrsturvwxyz/nBCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrsturvwxyzA";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_upper_lower_numbersKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrsturvwxyz1234567890/nBCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrsturvwxyz1234567890A";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_lower_numbers_upperKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "abcdefghijklmnopqrsturvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ/nbcdefghijklmnopqrsturvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZa";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_lower_upper_numbersKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "abcdefghijklmnopqrsturvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890/nbcdefghijklmnopqrsturvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890a";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_numbers_lower_upperKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "1234567890abcdefghijklmnopqrsturvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/n234567890abcdefghijklmnopqrsturvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_numbers_upper_lowerKey() {
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrsturvwxyz/n234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrsturvwxyz1";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
    }
    @Test
    void testDecrypt_keyWithoutNewline() {//should use default key
        String data = "Pay no attention to the man behind the curtain./nYOUR MOTHER WAS A HAMSTER " +
                "AND YOUR FATHER SMELT OF ELDERBERRIES!/n8675309";
        String key = "1234567890";
        String result = Cipher.decrypt(data, key);
        assertEquals("Qbz op buufoujpo up uif nbo cfijoe uif dvsubjo./nZPVS NPUIFS XBT " +
                "B IBNTUFS BOE ZPVS GBUIFS TNFMU PG FMEFSCFSSJFT!/n97864a0", result);
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