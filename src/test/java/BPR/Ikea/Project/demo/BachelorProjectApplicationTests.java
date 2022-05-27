package BPR.Ikea.Project.demo;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BachelorProjectApplicationTests {

	@Autowired
	private DBConnection dbConnection;
	@Test
	public void DBConnectionTest() throws Exception {
		assertThat(dbConnection).isNotNull();
	}
	@Test
	public void DBTest() throws Exception {

	}

	@Autowired
	private Controller controller;

	@Test
	public void ControllerTest() throws Exception {
		assertThat(controller).isNotNull();
	}
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void ApiTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/Testing",
				String.class)).contains("This is a test");
	}
	@org.testng.annotations.Test

	@Test
	public void test() throws Exception {
		Class.forName("org.h2.Driver");

		Connection conn = DriverManager.
				getConnection("jdbc:h2:tcp://nyxzx8czn4kekwn0@i54jns50s3z6gbjt.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/lsixgbt8anazl3cm","d5mcw7cvheivyqp9","nyxzx8czn4kekwn0");
//MODE=MySQL;IGNORECASE=TRUE;INIT=RUNSCRIPT FROM 'src/test/java/BPR.Ikea.Project.demo/test.sql'

		System.out.println(conn);
	}

}
