import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    WiseSaying[] a = new WiseSaying[100];
    int index=1;
    void run(){
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            String word = sc.nextLine().trim();
            String[] input = sc.nextLine().split("?");
            if(word.equals("등록")){
                actionWrite();
            } else if(word.equals("목록")){
                actionList();
            } else if(word.equals("종료")) break;
            //else if(input[0].equals("삭제")){
              //  actionDelete(input[1]);
           // }

        }
    }
    void actionWrite(){
        System.out.print("명언 : ");
        String tell = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        WiseSaying wiseSaying = write(tell,author);
        System.out.printf("%d번 명언이 등록되었습니다.\n",wiseSaying.num);
    }
    WiseSaying write(String tell,String author){
        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.num=index;
        wiseSaying.tell=tell;
        wiseSaying.author=author;
        a[index-1]=wiseSaying;
        index++;
        return wiseSaying;
    }
    void actionList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i=index-1;i>0;i--){
            System.out.printf("%d / %s / %s\n",a[i-1].num,a[i-1].author,a[i-1].tell);
        }
    }
   // void actionDelete(){


       // System.out.printf("%d번 명언이 삭제되었습니다.",)
                //}
}
