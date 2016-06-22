package br.com.eduandrade.bluegreendeploy;

import static spark.Spark.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class ServiceMain {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceMain.class);
	
	private static final int DEFAULT_PORT = 8080;
	
	private static final Gson GSON = new Gson();

	public static void main(String[] args) {
		ServiceMain serviceMain = new ServiceMain();
		LOG.info("Configuring...");
		serviceMain.configure();
		LOG.info("Executing...");
		serviceMain.execute();
	}

	private void configure() {
		final int port = System.getenv("PORT") == null ? DEFAULT_PORT : Integer.parseInt(System.getenv("PORT"));
		port(port);
	}

	private void execute() {
		get("/info", (req, res) -> {
			String hostName = getHostName();
			LOG.info("/info - hostName=[{}] clientIP=[{}]", hostName, req.ip());
			ServiceResponseInfo response = new ServiceResponseInfo();
			response.setClientIP(req.ip());
			response.setHostName(hostName);
			response.setTimestamp(new Date());
			return GSON.toJson(response);
		});
	}

	private String getHostName() {
		String hostname = "Unknown";
		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException ex) {
			LOG.error("Hostname can not be resolved", ex);
		}
		return hostname;
	}

}
