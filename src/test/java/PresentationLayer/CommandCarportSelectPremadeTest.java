/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PresentationLayer;
//
//import DBAccess.Order;
//import FunctionLayer.LogicFacade;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import static org.hamcrest.CoreMatchers.any;
//import static org.hamcrest.CoreMatchers.is;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.anyInt;
//import org.mockito.Mock;
//import static org.mockito.Mockito.doAnswer;
//import static org.mockito.Mockito.when;
//import org.mockito.MockitoAnnotations;
//
///**
// *
// * @author frede
// */
//public class CommandCarportSelectPremadeTest {
//   @Mock
//  private LogicFacade logic;
//  
//  @Mock
//  private HttpServletRequest request;
//  
//  @Mock
//  private HttpSession session;
//  
//  @Mock
//  private Order order;
//    public CommandCarportSelectPremadeTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of execute method, of class CommandCarportSelectPremade.
     * @throws java.lang.Exception
     */
//    @Test
//    public void testExecute() throws Exception {
//    when(request.getParameter("premadeCarport")).thenReturn("1");
//    when(request.getSession()).thenReturn(session);
//    when(logic.getPremadeOrder(1)).thenReturn(order);
//    doAnswer( 
//      invocation -> {
//          String key = invocation.getArgument(0);
//          int carportLength = invocation.getArgument(1);
//          switch (key){
//              case "carportlength":
//                assertThat(carportLength, is(720));
//                break;
//              default: fail(key+" not expected");
//                break;
//          }
//          return null;
//          }
//      ).when(request).setAttribute(any(String.class),anyInt());
//    Command command = new CommandCarportSelectPremade();
//    System.out.println(command.getClass());
//    String target = command.execute(request, logic);
//    assertThat(target, is("createPremadeOrderPage.jsp"));
//    }
    
//}
