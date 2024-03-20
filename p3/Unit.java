import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class Unit {

    /*
    * name:      testClass
    * purpose:   Executes test methods of a class and returns the results
    *            as a map.
    * arguments: name: name of test class to be tested
    * returns:   map: keys that are test method names, and values are null
    *            for passing tests or exceptions thrown for failed tests
    */
    public static Map<String, Throwable> testClass(String name) {
        Class<?> testerClass = null;
        
        try {
            // Load class using provided name
            testerClass = Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found");
        }

        // Obtain methods from testerClass
        Method[] classMethods = testerClass.getMethods();
        // Initialize map to store test results
        Map<String, Throwable> testResults = new HashMap<>();


        Object o = null;
        try {
            o = testerClass.getConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Unable to create object");
        } catch (InstantiationException e) {
            throw new RuntimeException("Unable to create object");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to create object");
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Unable to create object");
        }

        
        // Store methods from classMethods
        List<Method> testList = new ArrayList<Method>();
        List<Method> beforeList = new ArrayList<Method>();
        List<Method> afterList = new ArrayList<Method>();
        List<Method> beforeClassList = new ArrayList<Method>();
        List<Method> afterClassList = new ArrayList<Method>();

        for (int methodCtr = 0; methodCtr < classMethods.length; methodCtr++) {
            Annotation[] currMethodAnnotation = classMethods[methodCtr].getAnnotations();
            if (currMethodAnnotation.length > 1) {
                throw new RuntimeException("Too many annotations");
            }
            if (currMethodAnnotation.length == 1) {
                if (currMethodAnnotation[0].annotationType().equals(Test.class)) {
                    testList.add(classMethods[methodCtr]);
                }
                if (currMethodAnnotation[0].annotationType().equals(Before.class)) {
                    beforeList.add(classMethods[methodCtr]);
                }
                if (currMethodAnnotation[0].annotationType().equals(After.class)) {
                    afterList.add(classMethods[methodCtr]);
                }
                if (currMethodAnnotation[0].annotationType().equals(BeforeClass.class)) {
                    beforeClassList.add(classMethods[methodCtr]);
                }
                if (currMethodAnnotation[0].annotationType().equals(AfterClass.class)) {
                    afterClassList.add(classMethods[methodCtr]);
                }
            }
        }

        // Sort lists in alpha order
        Collections.sort(testList, Comparator.comparing(Method::getName));
        Collections.sort(beforeList, Comparator.comparing(Method::getName));
        Collections.sort(afterList, Comparator.comparing(Method::getName));
        Collections.sort(beforeClassList, Comparator.comparing(Method::getName));
        Collections.sort(afterClassList, Comparator.comparing(Method::getName));

        // Run @BeforeClass methods
        runBeforeClassMethods(beforeClassList, o);
        // For all @Test methods, run @Before methods before @Test method and follow with @After methods
        runBeforeTestAfterMethods(testList, beforeList, afterList, o, testResults);
        runAfterClassMethods(afterClassList, o);

        return testResults;
    }


    /*
    * name:      runBeforeTestAfterMethods
    * purpose:   Runs all Before/After methods for each Test methods
    * arguments: testList: list of test methods
    *            beforeList: list of before methods
    *            afterList: list of after methods
    *            o: instance to have methods applied on
    *            testResults: map for testClass method
    * returns:   
    */
    private static void runBeforeTestAfterMethods(List<Method> testList, List<Method> beforeList, List<Method> afterList, Object o,
                                                 Map<String, Throwable> testResults) {
        for (Method method : testList) {
            runBeforeMethods(beforeList, o);
            try {
                method.invoke(o);
                testResults.put(method.getName(), null);
            } catch (InvocationTargetException e) {
                testResults.put(method.getName(), e.getCause());
            } catch (IllegalAccessException e) {
                throw new IllegalAccessError();
            }
            runAfterMethods(afterList, o);
        }

    } 

    /*
    * name:      runBeforeMethods
    * purpose:   Runs BeforeClass methods for the class
    * arguments: beforeClassList: list of methods annotated BeforeClass
    *            o: instance to have methods applied on
    * returns:   
    */
    private static void runBeforeMethods(List<Method> beforeList, Object o) {
        // Run all before methods (in alpha order)
        for (Method method : beforeList) {
            try {
                method.invoke(o);
            } catch (InvocationTargetException e) {
                throw new RuntimeException();
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }
        }
    }

    /*
    * name:      runAfterMethods
    * purpose:   Runs BeforeClass methods for the class
    * arguments: beforeClassList: list of methods annotated BeforeClass
    *            o: instance to have methods applied on
    * returns:   
    */
    private static void runAfterMethods(List<Method> afterList, Object o) {
        // Run all after methods (in alpha order)
        for (Method method : afterList) {
            try {
                method.invoke(o);
            } catch (InvocationTargetException e) {
                throw new RuntimeException();
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }
        }
    }

    /*
    * name:      runBeforeClassMethods
    * purpose:   Runs BeforeClass methods for the class
    * arguments: beforeClassList: list of methods annotated BeforeClass
    *            o: instance to have methods applied on
    * returns:   
    */
    private static void runBeforeClassMethods(List<Method> beforeClassList, Object o) {
        // Run all beforeClassList methods (in alpha order)
        for (Method method : beforeClassList) {
            try {
                method.invoke(o);
            } catch (InvocationTargetException e) {
                throw new RuntimeException();
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }
        }
    }

    /*
    * name:      runAfterClassMethods
    * purpose:   Runs AfterClass methods for the class
    * arguments: afterClassList: list of methods annotated AfterClass
    *            o: instance to have methods applied on
    * returns:   
    */
    private static void runAfterClassMethods(List<Method> afterClassList, Object o) {
        // Run all beforeClassList methods (in alpha order)
        for (Method method : afterClassList) {
            try {
                method.invoke(o);
            } catch (InvocationTargetException e) {
                throw new RuntimeException();
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }
        }
    }

    /*
    * name:      quickCheckClass
    * purpose:   Runs methods with the @Property annotation
    * arguments: name: name of test class to be tested
    * returns:   testResults: maps of test names to argument list
                 which causes the test to fail / null if passes
    */
    public static Map<String, Object[]> quickCheckClass(String name) {
        Class<?> testerClass = null;
        // Store valid methods with @Property
        List<Properties> methodsSaved = new ArrayList<>();

        // Load class using provided name
        try {
            testerClass = Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found");
        }

        Object o = null; 

        // Create instance of the loaded class
        try {
            o = testerClass.getConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Unable to create object");
        } catch (InstantiationException e) {
            throw new RuntimeException("Unable to create object");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to create object");
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Unable to create object");
        }

        // Obtain methods from testerClass
        Method[] classMethods = testerClass.getMethods();
        // Initialize map to store test results
        Map<String, Object[]> testResults = new HashMap<>();

        // Loop through methods and store those with @{Property annotation}
        for (Method method : classMethods) {
            Annotation a = method.getAnnotation(Property.class);
            if (a != null) {
                methodsSaved.add(new Properties(method, o, testerClass));
            }
        }

        // Sort the methods in alpha order
        Collections.sort(methodsSaved, (m1, m2) -> m1.getName().compareTo(m2.getName()));

        // Run each method and store their results in testResults
        for (Properties method : methodsSaved) {
            testResults.put(method.getName(), method.run());
        }

        return testResults; 
    }

}