import com.gargoylesoftware.htmlunit.WebClient;

public class MyTest {
	private WebClient webClient;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		@Before
		public void init() throws Exception {
		    webClient = new WebClient();
		}
		 
		@After
		public void close() throws Exception {
		    webClient.close();
		}
		 
		@Test
		public void givenAClient_whenEnteringBaeldung_thenPageTitleIsOk()
		  throws Exception {
		    HtmlPage page = webClient.getPage("/");
		     
		    Assert.assertEquals(
		      "Baeldung | Java, Spring and Web Development tutorials",
		        page.getTitleText());
		}
		
	}

	
	
	 
	
	
}
