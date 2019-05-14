/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.Order;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.Mock;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author frede
 */
public class CommandCarportSelectPremadeTest {

    @Mock
    private LogicFacade logic;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    @Mock
    private Order order;

    public CommandCarportSelectPremadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class CommandCarportSelectPremade.
     *
     * @throws java.lang.Exception
     */
    /*
    @Test
    public void testExecute() throws Exception {
        when(request.getParameter("premadeCarport")).thenReturn("1");
        when(request.getSession()).thenReturn(session);
        when(logic.getPremadeOrder(1)).thenReturn(order);
        when(order.getCarportLength()).thenReturn(720);
        when(order.getCarportWidth()).thenReturn(360);
        when(order.getCarportHeight()).thenReturn(305);
        when(order.getRoofType()).thenReturn("med rejsning");
        when(order.getRoofAngle()).thenReturn(25);
        when(order.getShedWidth()).thenReturn(360);
        when(order.getShedLength()).thenReturn(225);
        when(order.getTotalSale()).thenReturn(7000);
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    switch (key) {
                        case "carportlength":
                            int carportLength = invocation.getArgument(1);
                            assertThat(carportLength, is(720));
                            break;
                        case "carportwidth":
                            int carportWidth = invocation.getArgument(1);
                            assertThat(carportWidth, is(360));
                            break;
                        case "carportheight":
                            int carportHeight = invocation.getArgument(1);
                            assertThat(carportHeight, is(305));
                            break;
                        case "roofangle":
                            int roofAngle = invocation.getArgument(1);
                            assertThat(roofAngle, is(25));
                            break;
                        case "shedwidth":
                            int shedWidth = invocation.getArgument(1);
                            assertThat(shedWidth, is(360));
                            break;
                        case "shedlength":
                            int shedLength = invocation.getArgument(1);
                            assertThat(shedLength, is(225));
                            break;
                        case "totalsale":
                            int totalSale = invocation.getArgument(1);
                            assertThat(totalSale, is(7000));
                            break;
                        default:
                            fail(key + " not expected");
                            break;
                    }
                    return null;
                }
        ).when(request).setAttribute(any(String.class), anyInt());
        doAnswer(
                invocation -> {
                    String key = invocation.getArgument(0);
                    String roofType = invocation.getArgument(1);
                    assertThat(roofType, is("med rejsning"));
                    return null;
                }
        ).when(session).setAttribute(any(String.class), any(String.class));
        Command command = new CommandCarportSelectPremade();
        System.out.println(command.getClass());
        String target = command.execute(request, logic);
        assertThat(target, is("createPremadeOrderPage.jsp"));
    }*/
}
