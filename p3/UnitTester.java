import java.util.*;
class UnitTester {

        public UnitTester() {}

        @BeforeClass 
        public static void bc1() {
                System.out.println("@BeforeClass before all test cases (bc1)");
        }

        @BeforeClass 
        public static void bc2() {
                System.out.println("@BeforeClass before all test cases (bc2)");
        }

        @BeforeClass 
        public static void bc3() {
                System.out.println("@BeforeClass before all test cases (bc3) ");
        }
        

        @AfterClass
        public static void ac1() {
                System.out.println("@AfterClass after all test cases (ac1)");
        }

        @AfterClass
        public static void ac2() {
                System.out.println("@AfterClass after all test cases (ac2)");
        }

        @AfterClass
        public static void ac3() {
                System.out.println("@AfterClass after all test cases (ac3)");
        }

        @Before 
        public static void b1() {
                System.out.println("@Before before each test case (b1)");
        }

        @Before 
        public static void b2() {
                System.out.println("@Before before each test case (a2)");
        }

        @After
        public void a1() {
                System.out.println("@After after each test case (a1)");
        }

        @After
        public void a2() {
                System.out.println("@After after each test case (a2)");
        }

        @Test
        public void hello() {
                String test1 = null;
                System.out.println("Result: " + Assertion.assertThat(test1).isNotNull()); 
        }

        @Test
        public void goodbye() {
                String test2 = "hello";
                System.out.println("Result: ");
                Assertion.assertThat(test2).isNotNull().isEqualTo("hello");
        }

}
           
