import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataFileHandlerTest {

    @Test
    void fileReturn_returnsCorrectContents() {
        assertEquals("Dbsojwpsf, mbufs sfobnfe EDT2aaa, xbt b tztufn jnqmfnfoufe cz uif Gfefsbm Cvsfbv pg Jowftujhbujpo (GCJ) uibu xbt\n" +
                "eftjhofe up npojups fnbjm boe fmfduspojd dpnnvojdbujpot. Ju vtfe b dvtupnjAbcmf qbdlfu tojggfs uibu dpvme npojups bmm\n" +
                "pg b ubshfu vtfs't Joufsofu usbggjd. Dbsojwpsf xbt jnqmfnfoufe jo Pdupcfs 2008. Cz 3aa6 ju ibe cffo sfqmbdfe xjui\n" +
                "jnqspwfe dpnnfsdjbm tpguxbsf.", DataFileHandler.fileReturn("01").trim());
        assertEquals("Carnivore, later renamed DCS1000, was a system implemented by the Federal Bureau of Investigation (FBI) that was\n" +
                "designed to monitor email and electronic communications. It used a customizable packet sniffer that could monitor all\n" +
                "of a target user's Internet traffic. Carnivore was implemented in October 1997. By 2005 it had been replaced with\n" +
                "improved commercial software.", DataFileHandler.fileReturn("02").trim());
        assertEquals("DPJOUFMQSP (b tzmmbcjd bccsfwjbujpo efsjwfe gspn Dpvoufs Joufmmjhfodf Qsphsbn) xbt b tfsjft pg dpwfsu boe jmmfhbm\n" +
                "qspkfdut dpoevdufe cfuxffo 2067 boe 2082 cz uif Vojufe Tubuft Gfefsbm Cvsfbv pg Jowftujhbujpo (GCJ) bjnfe bu\n" +
                "tvswfjmmjoh, jogjmusbujoh, ejtdsfejujoh, boe ejtsvqujoh Bnfsjdbo qpmjujdbm qbsujft boe pshbojAbujpot uibu uif GCJ\n" +
                "qfsdfjwfe bt tvcwfstjwf.", DataFileHandler.fileReturn("03").trim());
    }
    @Test
    void fileReturn_invalidIndex() {
        assertEquals("", DataFileHandler.fileReturn("0"));
        assertEquals("", DataFileHandler.fileReturn("99"));

    }
    @Test
    void fileReturn_nonNumber() {
        assertEquals("", DataFileHandler.fileReturn("abc"));
    }
    @Test
    void fileList_returnsList() {
        List<String> list = DataFileHandler.fileList();
        assertEquals(5, list.size());
        assertTrue(list.contains("carnivore.txt"));
        assertTrue(list.contains("cointelpro.txt"));
        assertTrue(list.contains("carnivore.cip"));
    }

    @Test
    void fileList_returnsFullList() {
        List<String> list = DataFileHandler.fileList();
        System.out.println(list);
        assertEquals(5, list.size());
    }
}
