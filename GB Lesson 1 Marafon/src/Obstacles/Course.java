package Obstacles;

import Competitor.Competitor;
import Competitor.Team;


public class Course {

    private String courseName;

    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void setCourseName(String userCourseName) {
        courseName = userCourseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void doIt(Team team) {
        Competitor[] teamMembers = team.getMembers();
        if(teamMembers.length > 0) {
            for(Competitor c : teamMembers) {
                for(Obstacle o : obstacles) {
                    o.doIt(c);
                    if(!c.isOnDistance()) break;
                }
            }
        }
    }
}
