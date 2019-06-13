package Competitor;

public class Team {

    private String teamName;

    Competitor[] teamMembers;


    public Team(Competitor[] teamMembers) {
        this.teamMembers = teamMembers;
    }

    public void setTeamName(String userTeamName) {
        teamName = userTeamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public Competitor[] getMembers() {
        return teamMembers;
    }

    public void showResults() {
        for (Competitor c : teamMembers) {
            c.showResult();
        }
    }

    public void showMembersFinishedCourse() {
        for (Competitor c : teamMembers) {
            if (c.isOnDistance()) c.showResult();
            else if (!c.isOnDistance()) c.DropInfo();
            }
        }
    }
