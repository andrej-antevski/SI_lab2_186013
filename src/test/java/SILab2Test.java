import org.junit.jupiter.api.Test;

        import java.util.List;

        import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    SILab2 siLab2 = new SILab2();

    @Test
    void multipleCondition() {
        RuntimeException ex;
        //(deg >= 0 && deg < 360); TT, TF, FX; (H-I), (H-N), (H-N);
        assertEquals(List.of(146440, 360240, 1296000),siLab2.function(List.of(new Angle(40, 40, 40), new Angle(100, 4, 0), new Angle(360, 0, 0))));
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(400, 0, 0))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(-400, 21, 3))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());


        //(min < 0 || min > 59); TX, FT, FF; (I-J), (I-J), (I-K);
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(100, -10, 0))));
        assertEquals("The minutes of the angle are not valid!", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(100, 71, 3))));
        assertEquals("The minutes of the angle are not valid!", ex.getMessage());


        //(sec < 0 || sec > 59); TX, FT, FF; (K-L), (K-L), (K-M)
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(100, 10, -1))));
        assertEquals("The seconds of the angle are not valid", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(100, 1, 603))));
        assertEquals("The seconds of the angle are not valid", ex.getMessage());

        //(min == 0 && sec == 0); TT, TF, FX; (O-P), (O-Q), (O-Q)
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 0, 11))));
        assertEquals("The angle is greater then the maximum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 10, 0))));
        assertEquals("The angle is greater then the maximum", ex.getMessage());

    }

    @Test
    void everyPath(){
        RuntimeException ex;
        // ABCST
        assertEquals(List.of(),siLab2.function(List.of()));
        // ABCEFGHNRT RuntimeException("The angle is smaller or greater then the minimum")
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(400, 0, 0))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(-400, 21, 3))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        // ABCEFGHNOQT RuntimeException("The angle is greater then the maximum")
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 0, 11))));
        assertEquals("The angle is greater then the maximum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 10, 0))));
        assertEquals("The angle is greater then the maximum", ex.getMessage());
        // ABCEFGHIJT RuntimeException("The minutes of the angle are not valid!")
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(400, 0, 0))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(-400, 21, 3))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        // ABCEFGHIKLT RuntimeException("The seconds of the angle are not valid")
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(100, 10, -1))));
        assertEquals("The seconds of the angle are not valid", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(100, 1, 603))));
        assertEquals("The seconds of the angle are not valid", ex.getMessage());

        // ABC(EFGHNOPDC)ST
        assertEquals(List.of(1296000, 1296000), siLab2.function(List.of(new Angle(360, 0, 0), new Angle(360, 0, 0))));
        // ABC(EFGHIKMDC)ST
        assertEquals(List.of(151952, 548040),siLab2.function(List.of(new Angle(42, 12, 32), new Angle(152, 14, 0))));
        //mixed
        assertEquals(List.of(146440, 360240, 1296000),siLab2.function(List.of(new Angle(40, 40, 40), new Angle(100, 4, 0), new Angle(360, 0, 0))));

        // ABC(EFGHNOPDC)EFGHNRT
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 0, 0), new Angle(400, 0, 0))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 0, 0), new Angle(-400, 21, 3))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        // ABC(EFGHNOPDC)EFGHNOQT
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 0, 0), new Angle(360, 0, 11))));
        assertEquals("The angle is greater then the maximum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 0 ,0), new Angle(360, 10, 0))));
        assertEquals("The angle is greater then the maximum", ex.getMessage());
        // ABC(EFGHNOPDC)EFGHIJT
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 0, 0), new Angle(400, 0, 0))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 0, 0), new Angle(-400, 21, 3))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        // ABC(EFGHNOPDC)EFGHIKLT
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 0, 0), new Angle(100, 10, -1))));
        assertEquals("The seconds of the angle are not valid", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(360, 0, 0), new Angle(100, 1, 420))));
        assertEquals("The seconds of the angle are not valid", ex.getMessage());


        // ABC(EFGHIKMDC)EFGHNRT
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(12, 21, 21), new Angle(400, 0, 0))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(53, 12, 2), new Angle(-400, 21, 3))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        // ABC(EFGHIKMDC)EFGHNOQT
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(3, 32, 12), new Angle(360, 0, 11))));
        assertEquals("The angle is greater then the maximum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(69, 12 ,4), new Angle(360, 10, 0))));
        assertEquals("The angle is greater then the maximum", ex.getMessage());
        // ABC(EFGHIKMDC)EFGHIJT
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(32, 40, 52), new Angle(400, 0, 0))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(153, 0, 12), new Angle(-400, 21, 3))));
        assertEquals("The angle is smaller or greater then the minimum", ex.getMessage());
        // ABC(EFGHIKMDC)EFGHIKLT
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(123, 4, 5), new Angle(100, 10, -1))));
        assertEquals("The seconds of the angle are not valid", ex.getMessage());
        ex = assertThrows(RuntimeException.class, () -> siLab2.function(List.of(new Angle(98, 7, 6), new Angle(100, 1, 420))));
        assertEquals("The seconds of the angle are not valid", ex.getMessage());
    }
}