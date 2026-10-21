import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc = new Scanner(System.in);
    private int num=0;
    private List<WiseSaying> a = new ArrayList<>();
    public void run(){
        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            String word = sc.nextLine().trim();
            if(word.equals("종료")) break;
            else if(word.equals("등록")){
                actionWrite();
            } else if(word.equals("목록")){
                actionList();
            } else if (word.startsWith("삭제")){
                actionDelete(word);
            } else if (word.startsWith("수정")){
                actionModify(word);
            }
        }
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> flws = reverseList();
        for (WiseSaying a : flws) {
            System.out.printf("%d / %s / %s\n",a.getId(),a.getAuthor(),a.getContent());
        }
    }

    private List<WiseSaying> reverseList() {
        return a.reversed();
    }

    private void actionWrite(){
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying b = write(content,author);
        System.out.printf("%d번 명언이 등록되었습니다.\n",b.getId());
    }
    private WiseSaying write(String content,String author){
        WiseSaying c = new WiseSaying(++num,author,content);
        a.add(c);
        return c;
    }
    private void actionDelete(String word){
        String[] wordBits = word.split("=",2);
        if(wordBits.length < 2 || wordBits[1].isBlank()){
            System.out.println("id를 입력해주세요.");
            return;
        }
        int id =Integer.parseInt(wordBits[1]);
        int deletedIndex = delete(id);
        if (deletedIndex == -1) {
            System.out.printf("%d번 명언은 존재 하지 않습니다.\n",id);
            return;
        }
        System.out.printf("%d번 명언은 삭제 되었습니다.\n",id);
    }
    private int delete(int id){
        int deleteIndex = findIndexById(id);
        if (deleteIndex == -1) return deleteIndex;
        a.remove(deleteIndex);
        return deleteIndex;
    }
    private  int findIndexById(int id){
        for(int i=0;i <a.size();i++){
            if(a.get(i).getId()== id){
                return i;
            }
        }
        return -1;
    }
    private void actionModify(String word){
        String[] wordBit = word.split("=",2);
        if (wordBit.length <2 || wordBit[1].isBlank()) {
            System.out.println("id를 입력해주세요");
            return;
        }
        int id=Integer.parseInt(wordBit[1]);
        WiseSaying d = findById(id);
        if(d==null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }
        System.out.printf("명언(기존) : %s\n",d.getContent());
        System.out.print("명언 : ");
        d.setContent(sc.nextLine().trim());
        System.out.printf("작가(기존) : %s\n",d.getAuthor());
        System.out.print("작가 : ");
        d.setAuthor(sc.nextLine().trim());
    }
    private  WiseSaying findById (int id){
        int index= findIndexById(id);
        if (index==-1) return null;
        return a.get(index);
    }
}
