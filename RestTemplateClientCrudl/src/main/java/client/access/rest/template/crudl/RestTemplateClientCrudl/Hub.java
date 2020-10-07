package client.access.rest.template.crudl.RestTemplateClientCrudl;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Hub")
public class Hub implements Serializable
{
	private long hubId;
	private String hubName;
	private int javaCount;
	private int pythonCount;
	public Hub() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hub(long hubId, String hubName, int javaCount, int pythonCount) {
		super();
		this.hubId = hubId;
		this.hubName = hubName;
		this.javaCount = javaCount;
		this.pythonCount = pythonCount;
	}
	public Hub(String hubName, int javaCount, int pythonCount) {
		super();
		this.hubName = hubName;
		this.javaCount = javaCount;
		this.pythonCount = pythonCount;
	}
	@Override
	public String toString() {
		return "Hub [hubId=" + hubId + ", hubName=" + hubName + ", javaCount=" + javaCount + ", pythonCount="
				+ pythonCount + "]";
	}
	public long getHubId() {
		return hubId;
	}
	public void setHubId(long hubId) {
		this.hubId = hubId;
	}
	public String getHubName() {
		return hubName;
	}
	public void setHubName(String hubName) {
		this.hubName = hubName;
	}
	public int getJavaCount() {
		return javaCount;
	}
	public void setJavaCount(int javaCount) {
		this.javaCount = javaCount;
	}
	public int getPythonCount() {
		return pythonCount;
	}
	public void setPythonCount(int pythonCount) {
		this.pythonCount = pythonCount;
	}
	
}
