package domain;

// Generated 9 nov. 2015 19:47:09 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Event generated by hbm2java
 */
@Entity
@Table(name = "event", schema = "public")
@XmlRootElement	(name ="event")
public class Event implements java.io.Serializable {

	private short eventId;
	private Repetition repetition;
	private User user;
	private Room room;
	private Activity activity;
	private String eventName;
	private Date eventStartDate;
	private Date eventEndDate;
	private Double eventPrice;
	private Set<Inscription> inscriptions = new HashSet<Inscription>(0);
	private Set<Excludeddate> excludeddates = new HashSet<Excludeddate>(0);

	public Event() {
	}

	public Event(short eventId, User user, Room room, Date eventStartDate,
			Date eventEndDate) {
		this.eventId = eventId;
		this.user = user;
		this.room = room;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
	}

	public Event(short eventId, Repetition repetition, User user, Room room,
			Activity activity, String eventName, Date eventStartDate,
			Date eventEndDate, Double eventPrice,
			Set<Inscription> inscriptions, Set<Excludeddate> excludeddates) {
		this.eventId = eventId;
		this.repetition = repetition;
		this.user = user;
		this.room = room;
		this.activity = activity;
		this.eventName = eventName;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.eventPrice = eventPrice;
		this.inscriptions = inscriptions;
		this.excludeddates = excludeddates;
	}

	@Id
	@Column(name = "event_id", unique = true, nullable = false)
	@SequenceGenerator(name="eventIdSeq", sequenceName="public.event_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="eventIdSeq")
	public short getEventId() {
		return this.eventId;
	}

	public void setEventId(short eventId) {
		this.eventId = eventId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "repetition_id")
	public Repetition getRepetition() {
		return this.repetition;
	}

	public void setRepetition(Repetition repetition) {
		this.repetition = repetition;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "participant", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_id", nullable = false)
	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "activity_id")
	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Column(name = "event_name", length = 50)
	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "event_start_date", nullable = false, length = 13)
	public Date getEventStartDate() {
		return this.eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "event_end_date", nullable = false, length = 13)
	public Date getEventEndDate() {
		return this.eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	@Column(name = "event_price", precision = 17, scale = 17)
	public Double getEventPrice() {
		return this.eventPrice;
	}

	public void setEventPrice(Double eventPrice) {
		this.eventPrice = eventPrice;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "event")
	public Set<Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "event")
	public Set<Excludeddate> getExcludeddates() {
		return this.excludeddates;
	}

	public void setExcludeddates(Set<Excludeddate> excludeddates) {
		this.excludeddates = excludeddates;
	}

}
