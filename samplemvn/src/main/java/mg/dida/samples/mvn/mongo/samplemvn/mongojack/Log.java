package mg.dida.samples.mvn.mongo.samplemvn.mongojack;

import java.util.Date;

import javax.persistence.Id;

public class Log {

	@Id
	private String id;

	private String url;
	private Date created;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
