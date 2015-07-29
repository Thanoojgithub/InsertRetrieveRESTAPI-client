package com.insertretrieverestapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.insertretrieverestapi.vo.Element;

@Component
@Qualifier("insertRetrieveRESTAPIClient")
public class InsertRetrieveRESTAPIClient {

	@Autowired
	@Qualifier("insertretrieve")
	private org.apache.cxf.jaxrs.client.WebClient webClient;

	private static Logger LOGGER = LoggerFactory
			.getLogger(InsertRetrieveRESTAPIClient.class);

	public void insert(final String id) {
		webClient.reset();
		webClient.path("/insert/" + id);
		webClient.post(null);
	}

	@SuppressWarnings("unchecked")
	public void retrieve() {
		List<Element> eleList = new ArrayList<Element>();
		webClient.reset();
		webClient.path("/retrieve");
		Response response = webClient.get();
		if (response.getStatus() == 200) {
			eleList = (List<Element>) response.readEntity(List.class);
			LOGGER.info("inserted elements size :: " + eleList.size());
		} else {
			LOGGER.warn("insert failed, status code :: " + response.getStatus());
		}
		for(int i = 0; i<eleList.size(); i++){
			System.out.println(eleList.get(i));
		}
	}

}
