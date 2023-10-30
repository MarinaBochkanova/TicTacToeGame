public class Train {
    public static final int SIZ = 5;

    public static void main(String[] args) {
        char[][] fid = new char[SIZ][SIZ];
        fid[0] = new char[]{0, 0, 0, 0, 'x'};
        fid[1] = new char[]{0, 0, 0, 'x', 0};
        fid[2] = new char[]{0, 0, 'x', 0, 0};
        fid[3] = new char[]{0, 'x', 0, 0, 0};
        fid[4] = new char[]{'x', 0, 0, 0, 0};
        printFid(fid);

        isW(fid);

    }

    public static void printFid(char[][] fid) {
        for (char[] row : fid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static boolean isW(char[][] fid) {
        int countPlayer = 0;
        int cP = 0;
        for (int num = 0; num < SIZ; num++) {
            if (fid[num][num] == 'x') {
                countPlayer++;
            }
            //System.out.println(countPlayer);
        }
        System.out.println(countPlayer);
        if (countPlayer == SIZ){
            System.out.println("Крестики победили!");
            return true;
        }
       // countPlayer = 0;


        for (int num = 0; num < SIZ; num++) {
            if (fid[num][SIZ - 1 - num] == 'x') {
                cP++;
            }
            //System.out.println(countPlayer);
        }
        System.out.println(cP);
        if (cP == SIZ){
            System.out.println("Крестики победили!");
            return true;
        }

        System.out.println("Не  победили");
        return false;

    }


}
