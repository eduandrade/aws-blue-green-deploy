package br.com.eduandrade.bluegreendeploy;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;

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
		port(System.getenv("PORT") == null ? DEFAULT_PORT : Integer.parseInt(System.getenv("PORT")));
	}

	private void execute() {
		get("/info", (req, res) -> {
			ServiceResponseInfo response = new ServiceResponseInfo();
			response.setClientIP(req.ip());
			response.setHostName(getHostName());
			response.setTimestamp(Instant.now().toString());
			LOG.info("/info - response=[{}]", response);
			return GSON.toJson(response);
		});
		after((req, res) -> {
			res.type("application/json");
		});
	}

	private String getHostName() {
		String hostname = "Unknown!";
		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException ex) {
			LOG.error("Hostname can not be resolved", ex);
		}
		return hostname;
	}

}
