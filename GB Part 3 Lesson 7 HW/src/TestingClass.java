import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TestingClass {

    public static void start(Class cls) {
        performTests(cls);
    }

    private static void performTests(Class cls) throws RuntimeException {
        TestingClass testingObj = null;
        try {
            testingObj = (TestingClass) cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        Method beforeMethod = null;
        Method afterMethod = null;
        Method[] methods = cls.getMethods();
        List<MethodWithPriority> testingMethods = new ArrayList<>();

        for (Method method : methods)
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (beforeMethod != null)
                    throw new RuntimeException("The method with the @BeforeSuite annotation should be one");
                beforeMethod = method;
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                if (afterMethod != null)
                    throw new RuntimeException("The method with the @AfterSuite annotation should be one");
                afterMethod = method;
            } else if (method.getAnnotation(Test.class) != null) {
                Test annotationTst = method.getAnnotation(Test.class);
                testingMethods.add(new MethodWithPriority(method, annotationTst.priority()));
            }

        testingMethods.sort(
                Comparator.comparing(MethodWithPriority::getPriority));

        try {
            if (beforeMethod != null)
                beforeMethod.invoke(testingObj);

            for (MethodWithPriority methodWP : testingMethods)
                methodWP.method.invoke(testingObj);

            if (afterMethod != null)
                afterMethod.invoke(testingObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 1)
    public void test5() {
        System.out.println("Performed Test #5");
    }
    @Test(priority = 10)
    public void test4() {
        System.out.println("Performed Test #4");
    }
    @Test(priority = 2)
    public void test3() {
        System.out.println("Performed Test #3");
    }
    @Test(priority = 4)
    public void test2(){
        System.out.println("Performed Test #2");
    }
    @Test(priority = 6)
    public void test1(){
        System.out.println("Performed Test #1");
    }
    @BeforeSuite
    public void BeforeAll(){
        System.out.println("This method with the @BeforeSuite annotation is performed before all");
    }
    @AfterSuite
    public void AfterAll() {
        System.out.println("This method with the @AfterSuite annotation is performed after all");
    }
//    @AfterSuite
//    public void AfterAllTwo() {
//        System.out.println("This method (@AfterSuite) is performed after all");
////    }
//    @BeforeSuite
//    public void BeforeAllTwo(){
//    System.out.println("This method(@BeforeSuite) is performed before all");
//}


}
