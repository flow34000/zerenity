package domain;

// Generated 9 nov. 2015 19:47:09 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Activity generated by hbm2java
 */
@Entity
@Table(name = "activity", schema = "public")
@XmlRootElement	(name ="activity")
public class Activity implements java.io.Serializable {

	private short activityId;
	private User user;
	private String activityName;
	private String activityShortDesc;
	private String activityLongDesc;
	private Set<Event> events = new HashSet<Event>(0);

	public Activity() {
	}

	public Activity(short activityId, User user, String activityName,
			String activityShortDesc) {
		this.activityId = activityId;
		this.user = user;
		this.activityName = activityName;
		this.activityShortDesc = activityShortDesc;
	}

	public Activity(short activityId, User user, String activityName,
			String activityShortDesc, String activityLongDesc, Set<Event> events) {
		this.activityId = activityId;
		this.user = user;
		this.activityName = activityName;
		this.activityShortDesc = activityShortDesc;
		this.activityLongDesc = activityLongDesc;
		this.events = events;
	}

	@Id
	@Column(name = "activity_id", unique = true, nullable = false)
	@SequenceGenerator(name="activityIdSeq", sequenceName="public.activity_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="activityIdSeq")
	public short getActivityId() {
		return this.activityId;
	}

	public void setActivityId(short activityId) {
		this.activityId = activityId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manager", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "activity_name", nullable = false, length = 25)
	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Column(name = "activity_short_desc", nullable = false, length = 250)
	public String getActivityShortDesc() {
		return this.activityShortDesc;
	}

	public void setActivityShortDesc(String activityShortDesc) {
		this.activityShortDesc = activityShortDesc;
	}

	@Column(name = "activity_long_desc", length = 500)
	public String getActivityLongDesc() {
		return this.activityLongDesc;
	}

	public void setActivityLongDesc(String activityLongDesc) {
		this.activityLongDesc = activityLongDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "activity")
	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

}
