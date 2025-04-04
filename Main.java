import java.util.*;

public class Main {
    static class Student {
        String name;
        int age;
        List<String> subjects = new ArrayList<>();
        Map<String, Integer> scores = new HashMap<>();

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void addSubject(String subject) {
            subjects.add(subject);
            scores.put(subject, 0); // default score
        }

        public void updateScore(String subject, int score) {
            if (scores.containsKey(subject)) {
                scores.put(subject, score);
            }
        }

        public void displayProfile() {
            System.out.println("\n📘 Student Profile:");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Subjects: " + subjects);
            System.out.println("Scores: " + scores);
        }

        public void showRecommendations() {
            System.out.println("\n🎓 Personalized Learning Tips:");
            for (String subject : subjects) {
                int score = scores.get(subject);
                if (score < 50) {
                    System.out.println("- Improve basics in " + subject + " (Try video lessons or quizzes)");
                } else if (score < 80) {
                    System.out.println("- Good in " + subject + ", try advanced exercises");
                } else {
                    System.out.println("- Excellent in " + subject + "! Keep practicing 😊");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Student profile
        System.out.println("🎓 Welcome to Smart Education System");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); scanner.nextLine();

        Student student = new Student(name, age);

        // Subject selection
        System.out.println("\n📚 Choose your subjects (type 'done' to finish):");
        while (true) {
            System.out.print("Enter subject name: ");
            String sub = scanner.nextLine();
            if (sub.equalsIgnoreCase("done")) break;
            student.addSubject(sub);
        }

        // Enter scores
        System.out.println("\n📊 Enter your scores out of 100:");
        for (String subject : student.subjects) {
            System.out.print(subject + ": ");
            int score = scanner.nextInt(); scanner.nextLine();
            student.updateScore(subject, score);
        }

        // Display profile & recommendations
        student.displayProfile();
        student.showRecommendations();

        System.out.println("\n✅ Thank you for using Smart Education System!");
    }
}