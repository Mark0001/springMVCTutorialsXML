package utils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import model.Person;

public class PseudoData {
	public static List<Person> getPersons() {
		final List<Person> result = new LinkedList<Person>();
		Person p1 = new Person();
		p1.setAge(2);
		p1.setGender(false);
		p1.setName("老王1");
		result.add(p1);
		Person p2 = new Person();
		p2.setAge(2);
		p2.setGender(true);
		p2.setName("老王2");
		result.add(p2);

		return result;
	}

	public static String getHtmlContent(final String baseUrl) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String responseBody = null;
		HttpGet httpget = new HttpGet(baseUrl);

		System.out.println("Executing request " + httpget.getRequestLine());

		// Create a custom response handler
		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			@Override
			public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			}

		};

		try {
			responseBody = httpclient.execute(httpget, responseHandler);

		} catch (IOException ioexc) {
			System.err.println("Fatal transport error: " + ioexc.getMessage());
			ioexc.printStackTrace();
		} finally {

			// ** 無論如何都必須釋放連接.
			httpclient.close();
		}

		return responseBody;
	}
}
