package Bean;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Consommation.MeetingConsomation;
import tn.esprit.imputation.entity.Meeting;





@ManagedBean
@SessionScoped
public class MeetingBean {
	private List<Meeting> meetings = new ArrayList<Meeting>();
	
	private int MeetingId;
	private String Title;
	private Date Date;
	private String Details;
	private int Id;
	private int ProjectId;
	
	

	public int getMeetingId() {
		return MeetingId;
	}

	public void setMeetingId(int meetingId) {
		MeetingId = meetingId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getProjectId() {
		return ProjectId;
	}

	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}

	public MeetingConsomation getDcr() {
		return dcr;
	}

	public void setDcr(MeetingConsomation dcr) {
		this.dcr = dcr;
	}

	@EJB
	private MeetingConsomation dcr;
	
	
	public List<Meeting> getMeetings() {
		 meetings = dcr.consomation();
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = dcr.consomation();
	}

	@PostConstruct
	public void init() {
			meetings = dcr.consomation();
	}
	
	
	
	public  String supprimer(Integer id){
		String navigateTo ="null";
		dcr.deleteMeeting(id);
		navigateTo ="ListMeeting?faces-redirect=true";
		return navigateTo;
	}
	
	public void modifier(Meeting e){
		
		
		
		this.setMeetingId(e.getMeetingId());
		
		this.setTitle(e.getTitle());
		this.setDate(e.getDate());
		this.setDetails(e.getDetails());
		this.setProjectId(e.getProjectId());
		this.setId(e.getId());
		
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("UpdateMeeting.jsf");
		} catch (IOException r) {
			// TODO Auto-generated catch block
			r.printStackTrace();
		}
		
	}
	
	
	
	
}
