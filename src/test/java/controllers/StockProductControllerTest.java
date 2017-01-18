package controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse; 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
// TODO: Auto-generated Javadoc

/**
 * The Class StockProductControllerTest.
 * spring framework test 3.0寫法
 */
@WebAppConfiguration
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/dispatcher-context.xml"  })
@RunWith(SpringJUnit4ClassRunner.class)
public class StockProductControllerTest {
	
	/** The mock mvc. */
	private MockMvc mockMvc;
	
	/** The wac. */
	@Autowired
	protected WebApplicationContext wac;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build(); 
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test get data.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetData() throws Exception {
		
		/***
		 * 沒甚麼意義，反正一定可以回傳
		 * **/
		this.mockMvc
		.perform(get("/12324354364364564"))
		.andExpect(status().isOk());
		
		this.mockMvc
		.perform(get("/stocks/exp"))
		.andExpect(status().isOk());
		
		/***
		 * 測試json內容(demo)
		 * **/		
		MvcResult mvcResult01 = this.mockMvc.perform(get("/stocks/exp.json"))
			.andReturn();
		
		MockHttpServletResponse data01 = mvcResult01.getResponse();
		 
		System.out.println(data01.getContentType()); 
		System.out.println(data01.getContentAsString()); 
		
		/***
		 * 測試xml內容(正常寫法)
		 * **/		  
		this.mockMvc.perform(get("/stocks/exp.xml")).
		andExpect(content().
				xml("<linked-list><model.Person><age>2</age><name>老王1</name><gender>false</gender></model.Person><model.Person><age>2</age><name>老王2</name><gender>true</gender></model.Person></linked-list>"));
	}

}
