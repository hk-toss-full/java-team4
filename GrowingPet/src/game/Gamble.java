package game;

import java.util.Scanner;

public class Gamble {
    public static void main(String[] args) {
        int totalSeed = 100;
        Scanner sc = new Scanner(System.in);
        System.out.println("현재 소지 코인 : " + totalSeed +"개");
        System.out.println("게임 시작!! 판돈 입력!!");
        int seedMoney = Integer.parseInt(sc.nextLine());
        totalSeed -= seedMoney;
        for(int i=2;i<9;i*=2){
            System.out.println("홀/짝 택 1!!(홀은 0 짝은 1)");
            int select = Integer.parseInt(sc.nextLine());
            int result = (int) (Math.random()*2);
            if(select == result){
                System.out.println("정답!!");
                System.out.println(i+ "배가 되었습니다!!");
                seedMoney = seedMoney * i;
                System.out.println("현재 판돈 : " + seedMoney);
                System.out.println("게임 진행은 총 3번 가능합니다 다시 하시겠습니까? (NO는 0 YES는 1)");
                int isContinue = Integer.parseInt(sc.nextLine());
                if(isContinue == 0){
                    System.out.println("겁쟁이래요~");
                    break;
                }
                if(isContinue == 1){
                    System.out.println("야 수 의 심 장");
                    continue;
                }
            }
            if(select != result){
                System.out.println("오답!!");
                seedMoney = 0;
                break;
            }

        }
        totalSeed += seedMoney;
        System.out.println("게임 후 최종 소지 코인 : " + totalSeed);
    }
}
