import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class Testing {

    @Test
    @DisplayName("STUDENT TEST - Case #1")
    public void firstCaseTest() {
        Client a = new Client();
        List<Region> sites = new ArrayList<Region>();
        Region r1 = new Region("Region #1", 500);
        Region r2 = new Region("Region #2", 700);
        Region r3 = new Region("Region #3", 900);
        Region r4 = new Region("Region #4", 400);
        Region r5 = new Region("Region #5", 300);
        Region r6 = new Region("Region #6", 800);
        r1.addConnection(r2, 2000.0);
        r1.addConnection(r4, 1500.0);
        r1.addConnection(r5, 1800.0);

        r2.addConnection(r1, 2000.0);
        r2.addConnection(r3, 1500.0);
        r2.addConnection(r4, 500.0);
        r2.addConnection(r5, 700.0);

        r3.addConnection(r2, 1500.0);

        r4.addConnection(r1, 1500.0);
        r4.addConnection(r2, 500.0);
        r4.addConnection(r5, 1400.0);
        r4.addConnection(r6, 200.0);

        r5.addConnection(r1, 1800.0);
        r5.addConnection(r2, 700.0);
        r5.addConnection(r4, 1400.0);

        r6.addConnection(r4, 200.0);
        sites.add(r1);
        sites.add(r2);
        sites.add(r3);
        sites.add(r4);
        sites.add(r5);
        sites.add(r6);
        assertTrue(a.findPath(sites).toString().equals("[Region #1: pop. 500 - [Region #2 " + 
        "(2000.0), Region #4 (1500.0), Region #5 (1800.0)], Region #4: pop. 400 - [Region #2 " + 
        "(500.0), Region #6 (200.0), Region #5 (1400.0), Region #1 (1500.0)], Region #5: pop. " + 
        "300 - [Region #2 (700.0), Region #4 (1400.0), Region #1 (1800.0)], Region #2: pop. 700" + 
        " - [Region #4 (500.0), Region #5 (700.0), Region #3 (1500.0), Region #1 (2000.0)], " + 
        "Region #3: pop. 900 - [Region #2 (1500.0)]]"));
    }

    @Test
    @DisplayName("STUDENT TEST - Case #2")
    public void secondCaseTest() {
        Client a = new Client();
        List<Region> sites = new ArrayList<Region>();
        Region r1 = new Region("Region #1", 1200);
        Region r2 = new Region("Region #2", 9000);
        Region r3 = new Region("Region #3", 4500);
        Region r4 = new Region("Region #4", 4600);
        Region r5 = new Region("Region #5", 1300);
        Region r6 = new Region("Region #6", 7800);
        Region r7 = new Region("Region #7", 2400);
        r1.addConnection(r2, 2900.0);
        r1.addConnection(r4, 2400.0);

        r2.addConnection(r1, 2900.0);
        r2.addConnection(r3, 1600.0);
        r2.addConnection(r4, 1300.0);
        r2.addConnection(r5, 3100.0);

        r3.addConnection(r2, 1600.0);
        r3.addConnection(r5, 900.0);

        r4.addConnection(r1, 2400.0);
        r4.addConnection(r2, 1300.0);
        r4.addConnection(r6, 1700.0);
        r4.addConnection(r7, 1200.0);

        r5.addConnection(r2, 3100.0);
        r5.addConnection(r3, 900.0);

        r6.addConnection(r4, 1700.0);
        r6.addConnection(r7, 600.0);

        r7.addConnection(r4, 1200.0);
        r7.addConnection(r6, 600.0);
        sites.add(r1);
        sites.add(r2);
        sites.add(r3);
        sites.add(r4);
        sites.add(r5);
        sites.add(r6);
        sites.add(r7);
        assertTrue(a.findPath(sites).toString().equals("[Region #1: pop. 1200 - [Region #2 " + 
        "(2900.0), Region #4 (2400.0)], Region #2: pop. 9000 - [Region #1 (2900.0), Region #5 " + 
        "(3100.0), Region #3 (1600.0), Region #4 (1300.0)], Region #4: pop. 4600 - [Region #1 " + 
        "(2400.0), Region #7 (1200.0), Region #2 (1300.0), Region #6 (1700.0)], Region #7: pop. " +
        "2400 - [Region #6 (600.0), Region #4 (1200.0)], Region #6: pop. 7800 - [Region #7 " + 
        "(600.0), Region #4 (1700.0)]]"));
    }

    @Test
    @DisplayName("STUDENT TEST - DIY")
    public void diyTest() {
        Client a = new Client();
        List<Region> sites = new ArrayList<Region>();
        Region r1 = new Region("Region #1", 1000);
        Region r2 = new Region("Region #2", 800);
        Region r3 = new Region("Region #3", 1200);
        Region r4 = new Region("Region #4", 600);
        Region r5 = new Region("Region #5", 900);
        r1.addConnection(r2, 2500.0);
        r1.addConnection(r3, 1800.0);

        r2.addConnection(r4, 1500.0);

        r3.addConnection(r4, 1300.0);

        r4.addConnection(r5, 1100.0);
        sites.add(r1);
        sites.add(r2);
        sites.add(r3);
        sites.add(r4);
        sites.add(r5);
        System.out.println(a.findPath(sites).toString());
        assertTrue(a.findPath(sites).toString().equals("[Region #1: pop. 1000 - [Region #3 " +
        "(1800.0), Region #2 (2500.0)], Region #3: pop. 1200 - [Region #4 (1300.0)], Region #4:" + 
        " pop. 600 - [Region #5 (1100.0)], Region #5: pop. 900 -]]"));
    }
}
