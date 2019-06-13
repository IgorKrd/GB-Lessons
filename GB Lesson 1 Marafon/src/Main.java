import Competitor.Competitor;
import Obstacles.*;
import Competitor.Human;
import Competitor.Cat;
import Competitor.Dog;
import Competitor.Team;
import Competitor.Crocodile;


public class Main {
    public static void main(String[] args) {

       Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"), new Crocodile("Гена")};
       Obstacle[] obstacles = {new Cross(300), new Wall(2), new Water(300)};



        Team team = new Team(competitors);
        team.setTeamName("FLASH");


        System.out.println(">>>>>>>>>>> New Team " + team.getTeamName() + " on the start <<<<<<<<<<<<");
        System.out.println();


        System.out.println("Team members is: ");
        System.out.println();

        team.showResults();

        System.out.println();


        Course course = new Course(obstacles);
        course.setCourseName("Road to Hell");

        System.out.println(">>>>>>>>>>> Team on the course: " + course.getCourseName()+ " <<<<<<<<<<");
        System.out.println();

        course.doIt(team);

        System.out.println();

        System.out.println(">>>>>>>>>>> Show team Results <<<<<<<<<<<");
        team.showResults();

        System.out.println();

        System.out.println(">>>>>>>>>>> Team members on the Finish <<<<<<<<<<<");
        System.out.println();

        team.showMembersFinishedCourse();


        }
    }
