package codelearn.io;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BestTeamWithNoConflicts {
    public static void main(String[] args) {
        System.out.println((new BestTeamWithNoConflicts()).bestTeamScore(
                new int[]{
                        4,5,6,5
                },
                new int[] {
                        2,1,2,1
                }
        ));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        List<Person> people = new ArrayList<>();
        int n = scores.length;
        int[] dp = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            Person person = new Person(scores[i], ages[i]);
            people.add(person);
        }
        people = people.stream()
                .sorted((p1, p2) -> {
                    if( p1.getAge() > p2.getAge()) return 1;
                    if( p1.getAge() < p2.getAge()) return -1;

                    if( p1.getScore() > p2.getScore()) return -1;
                    if( p1.getScore() < p2.getScore()) return 1;
                    return 0;
                })
                .collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            Person p = people.get(i);
            dp[i] = p.getScore();
            for (int j = 0; j < i; j++) {
                Person anotherP = people.get(j);
                if( anotherP.getScore() <= p.getScore()){
                    dp[i] = Math.max(dp[i], dp[j] + p.getScore());
                }
            }
            result = Math.max( result, dp[i]);
        }
        return result;
    }
}

class Person{
    private int score;
    private int age;

    public Person(int score, int age) {
        this.score = score;
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
