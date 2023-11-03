package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class StockContest implements Contest{

    private String contestId;
    private String title;

    private String description;

    private ArrayList<User> members;

    private String industry;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public String getTitle(){ return this.title; }

    public String getDescription(){ return this.description; }

    public ArrayList<User> getMembers(){ return this.members; }

    public String getContestId(){ return this.contestId; }

    public String getContestIndustry(){ return this.industry; }



    //TODO: Implement Method Later when API call logic is finished
    public User getWinner(){ return null; }

    public StockContest(String contestId, String title, String description, ArrayList<User> members,
                        String industry, LocalDateTime startTime, LocalDateTime endTime){
        this.contestId = contestId;
        this.title = title;
        this.description = description;
        this.members = members;
        this.industry = industry;
        this.startTime = startTime;
        this.endTime = endTime;

    }



}
