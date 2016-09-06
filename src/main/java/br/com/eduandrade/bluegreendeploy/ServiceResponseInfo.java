package br.com.eduandrade.bluegreendeploy;

public class ServiceResponseInfo {

	private String hostName;
	private String clientIP;
	private String timestamp;
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getClientIP() {
		return clientIP;
	}
	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "ServiceResponseInfo [hostName=" + hostName + ", clientIP=" + clientIP + ", timestamp=" + timestamp
				+ "]";
	}
	
}
