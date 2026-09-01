import java.util.*;

class Student {
    String roll, name;
    double marks;

    Student(String roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public String toString() {
        return roll + " - " + name + " (Marks: " + marks + ")";
    }
}

class Project {
    String title, desc;
    List<String> progress = new ArrayList<>();

    Project(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }
}

class Team {
    String name;
    List<Student> members = new ArrayList<>();
    Project project;
    List<String> seminars = new ArrayList<>();

    Team(String name) {
        this.name = name;
    }
}

public class Main {

    static Scanner in = new Scanner(System.in);
    static Map<String, Team> teams = new HashMap<>();

    public static void main(String[] args) {

        while (true) {

            System.out.println(
                "\n1. Create team\n" +
                "2. Add student\n" +
                "3. Assign project\n" +
                "4. Add progress\n" +
                "5. Record marks\n" +
                "6. Show teams\n" +
                "7. Exit"
            );

            System.out.print("Choice: ");
            int choice = Integer.parseInt(in.nextLine());

            if (choice == 7)
                break;

            switch (choice) {

                case 1:
                    createTeam();
                    break;

                case 2:
                    addStudent();
                    break;

                case 3:
                    assignProject();
                    break;

                case 4:
                    addProgress();
                    break;

                case 5:
                    recordMarks();
                    break;

                case 6:
                    showTeams();
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        System.out.println("Program exited.");
    }

    static void createTeam() {

        System.out.print("Team name: ");
        String name = in.nextLine();

        teams.put(name, new Team(name));

        System.out.println("Team created.");
    }

    static Team getTeam() {

        System.out.print("Team name: ");
        String name = in.nextLine();

        Team t = teams.get(name);

        if (t == null)
            System.out.println("Team not found!");

        return t;
    }

    static void addStudent() {

        Team t = getTeam();

        if (t == null)
            return;

        System.out.print("Student roll: ");
        String roll = in.nextLine();

        System.out.print("Student name: ");
        String name = in.nextLine();

        t.members.add(new Student(roll, name));

        System.out.println("Student added.");
    }

    static void assignProject() {

        Team t = getTeam();

        if (t == null)
            return;

        System.out.print("Project title: ");
        String title = in.nextLine();

        System.out.print("Project desc: ");
        String desc = in.nextLine();

        t.project = new Project(title, desc);

        System.out.println("Project assigned.");
    }

    static void addProgress() {

        Team t = getTeam();

        if (t == null || t.project == null) {

            System.out.println("Team or project not found!");
            return;
        }

        System.out.print("Progress note: ");
        String note = in.nextLine();

        t.project.progress.add(note);

        System.out.print("Seminar date: ");
        String info = in.nextLine();

        t.seminars.add(info);

        System.out.println("Progress added.");
    }

    static void recordMarks() {

        Team t = getTeam();

        if (t == null)
            return;

        for (int i = 0; i < t.members.size(); i++) {

            Student s = t.members.get(i);

            System.out.print("Marks for " + s.name + ": ");

            s.marks = Double.parseDouble(in.nextLine());
        }

        System.out.println("Marks recorded.");
    }

    static void showTeams() {

        if (teams.isEmpty()) {

            System.out.println("No teams.");
            return;
        }

        List<Team> teamList = new ArrayList<>(teams.values());

        for (int i = 0; i < teamList.size(); i++) {

            Team t = teamList.get(i);

            System.out.println("\nTeam: " + t.name);

            System.out.println("Members:");

            for (int j = 0; j < t.members.size(); j++) {

                System.out.println("  " + t.members.get(j));
            }

            if (t.project != null) {

                System.out.println(
                    "Project: " +
                    t.project.title +
                    " - " +
                    t.project.desc
                );

                System.out.println("Progress:");

                for (int j = 0; j < t.project.progress.size(); j++) {

                    System.out.println("  " + t.project.progress.get(j));
                }
            }

            System.out.println("Seminars:");

            for (int j = 0; j < t.seminars.size(); j++) {

                System.out.println("  " + t.seminars.get(j));
            }
        }
    }
}# java-project
Final year project management 
