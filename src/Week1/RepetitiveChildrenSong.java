package Week1;

public class RepetitiveChildrenSong {
    public static void singBabyShark() {

        String[] names = {"Mommy Shark", "Daddy Shark", "Baby Shark", "Grandma Shark", "Grandpa Shark"};
        String appended = "doo-doo, doo-doo";
        for (String name : names) {
            for (int j = 0; j < 4; ++j) {
                System.out.println(name + "" + appended);

            }
        }
    }
    public static void main(String[] args) {
        singBabyShark();
    }
}