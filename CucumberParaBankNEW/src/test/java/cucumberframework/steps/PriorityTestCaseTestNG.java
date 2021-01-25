package cucumberframework.steps;

import org.testng.annotations.*;

public class PriorityTestCaseTestNG{

            @Test(priority=0)

            public void testCase1() { 

                         System.out.print("***World***");

            }

            @Test(priority=1)

            public void testCase2() {           

                         System.out.print("***Hello ***");

            }

}
