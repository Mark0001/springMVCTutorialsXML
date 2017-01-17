package controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
@RunWith(PowerMockRunner.class)
@PrepareForTest(MyClass.class)
public class MyClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
    public void testMethod1() throws Exception {      
        MyObject myObjectMock = Mockito.mock(MyObject.class);
        Mockito.when(myObjectMock.method1()).thenReturn("" );   
        PowerMockito.whenNew(MyObject.class).withNoArguments().thenReturn(myObjectMock);

        MyClass objectTested = new MyClass();
        objectTested.method1();
 
    }

}
