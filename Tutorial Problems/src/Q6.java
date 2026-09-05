import java.util.Scanner;
import java.util.Arrays;
class Candidate {
    int Candidate_Id;
    String name;
    int aptitude;
    int technical;
    int communication;
    Candidate(int Candidate_Id, String name, int aptitude,
              int technical, int communication) {
        this.Candidate_Id = Candidate_Id;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }
    int getTotalScore() {
        return aptitude + technical + communication;
    }

}
public class Q6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Candidate[] candidates = new Candidate[N];
        for (int i = 0; i < N; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int aptitude = sc.nextInt();
            int technical = sc.nextInt();
            int communication = sc.nextInt();
            candidates[i] = new Candidate(
                    id, name, aptitude, technical, communication);
        }
        Arrays.sort(candidates, (a, b) -> {
// Higher total score gets higher priority
            if (a.getTotalScore() != b.getTotalScore()) {
                return b.getTotalScore() - a.getTotalScore();
            }
            return a.Candidate_Id - b.Candidate_Id;
        });
        for (int i = 0; i < K; i++) {
            System.out.println(
                    candidates[i].Candidate_Id + " " +
                            candidates[i].name + " " +
                            candidates[i].getTotalScore()
            );

        }
    }
}