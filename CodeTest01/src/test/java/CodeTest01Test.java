import org.junit.Assert;
import org.junit.Test;

public class CodeTest01Test {


    @Test
    public void coverTest01() {
        //given
        CodeTest01 codeTest01 = new CodeTest01();
        //when
        codeTest01.test01("aabcccbbad", 0, 1);
        //then
    }

    @Test
    public void coverTest02() {
        //given
        CodeTest01 codeTest01 = new CodeTest01();
        //when
        codeTest01.test02("abcccbad", 0, 1);
        //then
    }
}
