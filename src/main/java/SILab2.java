import java.util.ArrayList;
import java.util.List;

class Angle {
    int degrees;
    int minutes;
    int seconds;

    public Angle(int degrees, int minutes, int seconds) {
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getDegrees() {
        return degrees;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {

    public List<Integer> function(List<Angle> angleList) {
        List<Integer> result = new ArrayList<>(); //A

        for (int i = 0; i < angleList.size(); i++) { //B, C, D
            int deg = angleList.get(i).getDegrees(); //E
            int min = angleList.get(i).getMinutes(); //F
            int sec = angleList.get(i).getSeconds(); //G
            if (deg >= 0 && deg < 360) { //H
                if (min < 0 || min > 59) //I
                    throw new RuntimeException("The minutes of the angle are not valid!"); // J
                else {
                    if (sec < 0 || sec > 59) //K
                        throw new RuntimeException("The seconds of the angle are not valid"); //L
                    else
                        result.add(deg * 3600 + min * 60 + sec); //M
                }
            } else if (deg == 360) { //N			
                if (min == 0 && sec == 0) //O
                    result.add(deg * 3600 + min * 60 + sec); //P
                else
                    throw new RuntimeException("The angle is greater then the maximum"); //Q
            } else {
                throw new RuntimeException("The angle is smaller or greater then the minimum"); //R
            }
        }
        return result; //S

    } //T
}

/*
Every path
ABCST
ABCEFGHNRT RuntimeException("The angle is smaller or greater then the minimum")
ABCEFGHNOQT RuntimeException("The angle is greater then the maximum")
ABCEFGHIJT RuntimeException("The minutes of the angle are not valid!")
ABCEFGHIKLT RuntimeException("The seconds of the angle are not valid")

ABC(EFGHNOPDC)ST
ABC(EFGHIKMDC)ST


ABC(EFGHNOPDC)EFGHNRT
ABC(EFGHNOPDC)EFGHNOQT
ABC(EFGHNOPDC)EFGHIJT
ABC(EFGHNOPDC)EFGHIKLT

ABC(EFGHIKMDC)EFGHNRT
ABC(EFGHIKMDC)EFGHNOQT
ABC(EFGHIKMDC)EFGHIJT
ABC(EFGHIKMDC)EFGHIKLT
*/