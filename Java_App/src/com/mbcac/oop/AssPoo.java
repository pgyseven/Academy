import java.util.Scanner;

public class AssPoo {
    public static void main(String[] args) {
        Board[] blist = createList();
        showList(blist);
        Scanner kbd = new Scanner(System.in);
        boolean go = true;
        while (go) {
            String m = showMenu(kbd);

            switch (m) {
                case "x":
                    go = false;
                    break;
                case "s":
                    showList(blist);
                    break;
                case "t":
                    showDetail(blist, kbd);
                    break;
                default:
                    System.err.println("메뉴입력 오류");
            }
        }

        System.out.printf("프로그램 종료%n");
    }

    private static String showMenu(Scanner kbd) {
        System.out.println();
        System.out.println("추가(a), 목록(s), 검색(f), 상세보기(t), 수정(u), 삭제(d), 종료(x):");
        return kbd.nextLine();
    }

    private static Board[] createList() {
        Board[] blist = new Board[5];
        blist[0] = new Board(11, "게시판 개시", "김윤정", "와우~ 축하드려요!", 0);
        blist[1] = new Board(12, "자바를 내것으로", "김희석", "꼭 알아야 합니다", 0);
        blist[2] = new Board(13, "축하 메시지", "윤석열", "내가 범인이다", 0);
        blist[3] = new Board(14, "안녕~", "김건희", "천공을 아시나요?", 0);
        blist[4] = new Board(15, "국가안보는...", "이종섭", "나만 몰라요~", 0);
        return blist;
    }

    private static void showList(Board[] blist) {
        System.out.println();
        System.out.println("\t ** 게시글 목록 **");
        System.out.printf("%s\t%10s\t%s\t%s%n", "번호", "제목", "작성자", "히트수");
        System.out.println("=====================================");
        for (Board b : blist) {
            if (b != null) {
                b.print();
            }
        }
    }

    private static void showDetail(Board[] blist, Scanner kbd) {
        System.out.println("글번호");
        int bnum = kbd.nextInt();
        kbd.nextLine();

        Board b = findByNum(blist, bnum);
        if (b == null) {
            System.out.println("\t검색된 게시글이 없습니다");
            return;
        }

        System.out.println();
        System.out.println("\t ** 게시글 상세보기 **");
        System.out.printf("번호: %d%n제목: %s%n작성자: %s%n히트수: %d%n", b.getNum(), b.getTitle(), b.getAuthor(), b.getHit());
        System.out.println("-------------------------------------");
        System.out.println("본문: " + b.getContents());
        b.printComments(); // 댓글 출력

        System.out.println();
        System.out.println("댓글 달기? y or n");
        String or = kbd.nextLine();
        if (or.equals("y")) {
            System.out.println("댓글 내용을 입력하세요:");
            String comment = kbd.nextLine();
            b.addComment(comment); // 댓글 추가
            System.out.println("댓글이 추가되었습니다.");
        }
    }

    private static Board findByNum(Board[] blist, int bnum) {
        for (Board b : blist) {
            if (b != null && b.getNum() == bnum) {
                return b;
            }
        }
        System.out.println("\t검색 실패");
        return null;
    }
}

class Board {
    private int num;
    private String title;
    private String author;
    private String contents;
    private int hit;
    private String[] comments = new String[5]; // 댓글을 담을 배열 추가
    private int commentCount; // 댓글 개수

    public Board(int num, String title, String author, String contents, int hit) {
        this.num = num;
        this.title = title;
        this.author = author;
        this.contents = contents;
        this.hit = hit;
    }

    public int getNum() {
        return num;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContents() {
        return contents;
    }

    public int getHit() {
        return hit;
    }

    // 댓글 추가 메소드
    public void addComment(String comment) {
        if (commentCount < comments.length) {
            comments[commentCount++] = comment;
        } else {
            System.out.println("더 이상 댓글을 추가할 수 없습니다.");
        }
    }

    // 댓글 출력 메소드
    public void printComments() {
        if (comments != null) {
            System.out.println("댓글:");
            for (String comment : comments) {
                if (comment != null) {
                    System.out.println("- " + comment);
                }
            }
        } else {
            System.out.println("댓글이 없습니다.");
        }
    }

    public void print() {
        System.out.printf("%d\t%10s\t%s\t%d%n", num, title, author, hit);
    }
}